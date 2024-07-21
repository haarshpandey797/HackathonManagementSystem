package com.nucleus.dao.bulkuploaddao;

import com.nucleus.dto.EventDTO;

import com.nucleus.dto.teambulkuploaddto.TeamBulkDTO;
import com.nucleus.mapper.EventMapper;

import com.nucleus.mapper.teambulkuploadmappers.TeamBulkMappers;
import com.nucleus.model.hmsmodels.Event;
import com.nucleus.model.hmsmodels.Team;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TeamsBulkUploadDao {
    SessionFactory sessionFactory;
    TeamBulkMappers teamMapper;
    EventMapper eventMapper ;
    Logger logger;

    @Autowired
    public TeamsBulkUploadDao(SessionFactory sessionFactory , TeamBulkMappers teamBulkMappers, EventMapper eventMapper, Logger logger){
        this.sessionFactory = sessionFactory;
        this.teamMapper = teamBulkMappers;
        this.eventMapper = eventMapper;
        this.logger = logger;
    }

    // Function to insert List of Teams into the DB
    public boolean insertBulkTeams(List<TeamBulkDTO> teamDtoList) throws HibernateException {
        int rowsAffected = 0;
        if (teamDtoList == null || teamDtoList.isEmpty()) {
            return false;
        }
        try  {
            Session session = sessionFactory.getCurrentSession();
            List<Team> teamList = teamMapper.teamBulkDtoToEntityList(teamDtoList);
            for (Team team : teamList) {
                team.setEvent(session.get(Event.class,teamDtoList.get(rowsAffected).getEventID()));
                session.save(team);
                rowsAffected++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error Occurred While Inserting Teams " + e);
            throw new HibernateException("Insertion Unsuccessful! Try Again Later");
        }
        return rowsAffected > 0;
    }
    // Get a single Team Based on Team ID
    public TeamBulkDTO getTeamDto(int teamId) {

        if (teamId < 0) return null;
        TeamBulkDTO teamDto = null;
        try  {
            Session session = sessionFactory.getCurrentSession();
            // Getting the Team from the Team Table
            Team team = session.get(Team.class, teamId);
            // Converting the Team entity to the Team DTO
            teamDto = teamMapper.teamBulkToTeamBulkDto(team);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return teamDto;
    }
    public EventDTO getEventDTO(long eventID){
        if(eventID < 0) return new EventDTO();
        EventDTO eventDTO = new EventDTO();
        try {
            Session session = sessionFactory.getCurrentSession();
            Event event = session.get(Event.class,eventID);
            eventDTO = eventMapper.eventToDTO(event);
        } catch (HibernateException he){
            he.printStackTrace();
        }
        return eventDTO;
    }
}
