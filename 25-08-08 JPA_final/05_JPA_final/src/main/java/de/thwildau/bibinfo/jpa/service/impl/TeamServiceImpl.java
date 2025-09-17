// Datei Refractored aus Zip-Datei lt. Aufgabe 10
package de.thwildau.bibinfo.jpa.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;

import de.thwildau.bibinfo.jpa.api.PersonDto;
import de.thwildau.bibinfo.jpa.api.TeamDto;
import de.thwildau.bibinfo.jpa.model.Employee;
import de.thwildau.bibinfo.jpa.model.Team;
import de.thwildau.bibinfo.jpa.repository.EmployeeRepository;
import de.thwildau.bibinfo.jpa.repository.TeamRepository;
import de.thwildau.bibinfo.jpa.service.TeamService;

@Component
public class TeamServiceImpl implements TeamService {


    // Abhängigkeiten von Repositorien herstellen
    private final TeamRepository teamRepository;
    private final EmployeeRepository employeeRepository;

    // Konstruktor injizieren (Spring liefert das Repository)
    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, EmployeeRepository employeeRepository) {
        this.teamRepository = teamRepository;
        this.employeeRepository = employeeRepository;
    }

    // Implementierung Service Methoden

    // gibt eine Liste aller Teams aus
    @Override
    @Transactional(readOnly = true)
    public List<TeamDto> getTeams(){
        // findAll gibt Interable Variable zurück, über Stream kann man Iterationen "auseinander nehmen"
        return StreamSupport.stream(teamRepository.findAll().spliterator(), false).map(this::toTeamDto).toList();
    }

    // gibt ein Team anhand seiner ID zurück
    @Override
    @Transactional(readOnly = true)
    public Optional<TeamDto> getTeam(Integer id){
        //
        return teamRepository.findById(id).map(this::toTeamDto);
    }

    // gibt Mitglieder eines Teams zurück (Personen, nicht Employees)
    @Override
    @Transactional(readOnly = true)
    public List<PersonDto> getTeamMembers(Integer teamId){
        //
        return employeeRepository.findByTeamId(teamId).stream().map(Employee::getPerson).map(p -> {
            PersonDto dto = new PersonDto();
            dto.setId(p.getId());
            dto.setForename(p.getForename());
            dto.setSurname(p.getSurname());
            dto.setStreet(p.getStreet());
            dto.setNumber(p.getNumber());
            dto.setZipCode(p.getZipCode());
            dto.setCity(p.getCity());
            return dto;
        }).toList();
    }

    // legt ein neues Team an
    @Override
    public TeamDto addTeam(TeamDto teamDto){
        Team saved = teamRepository.save(toTeamEntity(teamDto));
        return toTeamDto(saved);
    }

    // Hilfsmethoden

    // Team-Entity zu TeamDto
    private TeamDto toTeamDto(Team team){
        TeamDto dto = new TeamDto();
        dto.setId(team.getId());
        dto.setName(team.getName());
        dto.setCode(team.getCode());
        return dto;
    }

    // TeamDto zu Team-Entity
    private Team toTeamEntity(TeamDto teamDto){
        Team t = new Team();
        // TeamId wird automatisch generiert, muss nicht gesetzt werden
        // t.setId(teamDto.getId());
        t.setName(teamDto.getName());
        t.setCode(teamDto.getCode());
        return t;
    }

    /*
     * Alte Programmierung
    public TeamServiceImpl() {

    }

    @Override
    public List<TeamDto> getTeams() {

        return List.of();
    }

    @Override
    public Optional<TeamDto> getTeam(Integer id) {

        return Optional.empty();
    }

    @Override
    public List<PersonDto> getTeamMembers(Integer teamId) {

        return List.of();
    }

    @Override
    public TeamDto addTeam(TeamDto teamDto) {

        return teamDto;
    }
    */

}
