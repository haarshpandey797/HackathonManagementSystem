package com.nucleus.mapper.teambulkuploadmappers;

import com.nucleus.dto.teambulkuploaddto.TeamBulkDTO;
import com.nucleus.mapper.EventMapper;
import com.nucleus.model.hmsmodels.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamBulkMappers {

    // DTO -> Entity
    public Team teamBulkDtoToEntity(TeamBulkDTO teamBulkDto){
        Team teamBulk = new Team();
        if(teamBulkDto == null) return teamBulk;
        teamBulk.setTeamName(teamBulkDto.getTeamName());
        teamBulk.setTeamSize(teamBulkDto.getTeamSize());
        teamBulk.setStatus(teamBulkDto.getStatus());
        teamBulk.setCodeRepositoryLink(teamBulkDto.getCodeRepositoryLink());
        return teamBulk;
    }

    // List of DTO -> List of Entity
    public List<Team> teamBulkDtoToEntityList(List<TeamBulkDTO> teamBulkDtos){
        return teamBulkDtos.stream()
                .map(this::teamBulkDtoToEntity)
                .collect(Collectors.toList());
    }

    // Entity -> DTO
    public TeamBulkDTO teamBulkToTeamBulkDto(Team teamBulk){
        TeamBulkDTO teamBulkDto = new TeamBulkDTO();
        if(teamBulk == null) return teamBulkDto;
        teamBulkDto.setTeamName(teamBulk.getTeamName());
        teamBulkDto.setTeamSize(teamBulk.getTeamSize());
        teamBulkDto.setEventID(teamBulk.getEvent().getEventId());
        teamBulkDto.setStatus(teamBulk.getStatus());
        teamBulkDto.setCodeRepositoryLink(teamBulk.getCodeRepositoryLink());
        return teamBulkDto;
    }

    // List of Entity -> List of DTO
    public List<TeamBulkDTO> teamBulkEntityToDTOList(List<Team> teamBulks){
        return teamBulks.stream()
                .map(this::teamBulkToTeamBulkDto)
                .collect(Collectors.toList());
    }
}
