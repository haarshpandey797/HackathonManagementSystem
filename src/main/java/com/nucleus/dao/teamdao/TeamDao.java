package com.nucleus.dao.teamdao;


import com.nucleus.dto.TeamDto;
import com.nucleus.mapper.TeamMapper;
import com.nucleus.model.hmsmodels.Team;
import org.apache.logging.log4j.LogManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TeamDao {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    TeamMapper teamMapper;

    public List<TeamDto> getAllTeams() {
        try {
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("FROM Team", Team.class)
                    .getResultList()
                    .stream()
                    .map(teamMapper::teamToDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LogManager.getLogger(TeamDao.class).error("Error fetching Teams: {}", e.getMessage());
            return Collections.emptyList();
        }
    }
public TeamDto getTeamsByTeamName(String name) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String queryStr = "SELECT t FROM Team t WHERE teamName = :name";
            Query query = session.createQuery(queryStr, Team.class);
            query.setParameter("name", name);

            Team team = (Team) query.getSingleResult();
            if (team != null) {
                return teamMapper.teamToDto(team);
            } else {
                return null; // or throw an exception if no team is found
            }
        } catch (Exception e) {
            LogManager.getLogger(TeamDao.class).error("Error fetching Team: {}", e.getMessage());
            return null; // Handle exception gracefully or throw it further
        }
    }
}
