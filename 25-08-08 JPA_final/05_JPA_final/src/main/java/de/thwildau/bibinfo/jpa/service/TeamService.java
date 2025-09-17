// Datei Refractored aus Zip-Datei lt. Aufgabe 10
package de.thwildau.bibinfo.jpa.service;

import java.util.List;
import java.util.Optional;

import de.thwildau.bibinfo.jpa.api.PersonDto;
import de.thwildau.bibinfo.jpa.api.TeamDto;

public interface TeamService {

    //lt. Aufgabe
    List<TeamDto> getTeams();

    Optional<TeamDto> getTeam(Integer id);

    List<PersonDto> getTeamMembers(Integer teamId);

    //Zusatz 8 (aus eigener Freemaker)
    TeamDto addTeam(TeamDto teamDto);

}
