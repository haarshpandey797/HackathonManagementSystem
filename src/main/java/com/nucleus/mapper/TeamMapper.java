package com.nucleus.mapper;

import com.nucleus.dto.TeamDto;
import com.nucleus.model.hmsmodels.Team;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamMapper {

    // DTO -> Entity
    public Team teamDtoToEntity(TeamDto teamDto) {
        Team team = new Team();
        if (teamDto == null) return team;
        team.setTeamId(teamDto.getTeamId());
        team.setTeamName(teamDto.getTeamName());
        team.setTeamSize(teamDto.getTeamSize());
        team.setEvent(teamDto.getEvent());
        team.setProblemStatement(teamDto.getProblemStatement());
        team.setStatus(teamDto.getStatus());
        team.setCodeRepositoryLink(teamDto.getCodeRepositoryLink());

        team.setTeamResult(teamDto.getTeamResult());
        return team;
    }

    // List of DTO -> List of Entity
    public List<Team> teamDtoToEntityList(List<TeamDto> teamDtos) {
        return teamDtos.stream()
                .map(this::teamDtoToEntity)
                .collect(Collectors.toList());
    }

    // Entity -> DTO
    public  TeamDto teamToDto(Team team) {
        TeamDto teamDto = new TeamDto();
        if (team == null) return teamDto;
        teamDto.setTeamId(team.getTeamId());
        teamDto.setTeamName(team.getTeamName());
        teamDto.setTeamSize(team.getTeamSize());
        teamDto.setEvent(team.getEvent());
        teamDto.setProblemStatement(team.getProblemStatement());
        teamDto.setStatus(team.getStatus());
        teamDto.setCodeRepositoryLink(team.getCodeRepositoryLink());
        teamDto.setTeamResult(team.getTeamResult());
        return teamDto;
    }

    // List of Entity -> List of DTO
    public List<TeamDto> teamEntityToDtoList(List<Team> teams) {
        return teams.stream()
                .map(this::teamToDto)
                .collect(Collectors.toList());
    }
}
