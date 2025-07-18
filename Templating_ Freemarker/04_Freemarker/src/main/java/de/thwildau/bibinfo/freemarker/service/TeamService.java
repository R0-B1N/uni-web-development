package de.thwildau.bibinfo.freemarker.service;

import java.util.List;
import java.util.Optional;

import de.thwildau.bibinfo.freemarker.api.PersonDto;
import de.thwildau.bibinfo.freemarker.api.TeamDto;

public interface TeamService {

    //lt. Aufgabe
    List<TeamDto> getTeams();

    Optional<TeamDto> getTeam(Integer id);

    List<PersonDto> getTeamMembers(Integer teamId);


    //Zusatz 8
    TeamDto addTeam(TeamDto teamDto);

}
