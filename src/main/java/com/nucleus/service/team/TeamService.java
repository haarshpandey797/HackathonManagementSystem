package com.nucleus.service.team;

import com.nucleus.dao.teamdao.TeamDao;
import com.nucleus.dto.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TeamService {
    @Autowired
    TeamDao teamDao;

    public List<TeamDto> getAllTeams() {
        List<TeamDto> teamDtos=teamDao.getAllTeams();
        return teamDtos;
    }
    public TeamDto getTeamsByTeamName(String teamName){
        return teamDao.getTeamsByTeamName(teamName);
    }

}
