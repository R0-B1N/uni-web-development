package de.thwildau.bibinfo.freemarker.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import de.thwildau.bibinfo.freemarker.api.EmployeeDto;
import de.thwildau.bibinfo.freemarker.api.PersonDto;
import de.thwildau.bibinfo.freemarker.api.TeamDto;
import de.thwildau.bibinfo.freemarker.helper.DataHelper;
import de.thwildau.bibinfo.freemarker.service.TeamService;

@Component
public class TeamServiceImpl implements TeamService {

    @Override
    public List<TeamDto> getTeams() {
        //Alle Teams ausgeben
        return DataHelper.getTeamDtos();
    }

    @Override
    public Optional<TeamDto> getTeam(Integer id) {
        //Nach TeamId filtern
        return DataHelper.getTeamDtos().stream()
                         .filter(team -> team.getId().equals(id))
                         .findFirst();
    }

    @Override
    public List<PersonDto> getTeamMembers(Integer teamId) {
        //Angestellte aus Team holen, und ueber EmployeeDto in PersonDto liste ueberfuehren
        //wenn kein Ergebnis, leere Liste
        return getTeam(teamId)
            .map(team ->
                     team.getEmployees().stream()
                         .map(EmployeeDto::getPerson)
                         .collect(Collectors.toList())
                )
            .orElse(Collections.emptyList());

    }


    //Zusatz 8
    @Override
    public TeamDto addTeam(TeamDto teamDto) {
        return DataHelper.addTeam(teamDto);
    }

}
