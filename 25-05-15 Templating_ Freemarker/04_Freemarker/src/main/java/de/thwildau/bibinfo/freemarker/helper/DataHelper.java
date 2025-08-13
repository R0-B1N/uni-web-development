package de.thwildau.bibinfo.freemarker.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import de.thwildau.bibinfo.freemarker.api.EmployeeDto;
import de.thwildau.bibinfo.freemarker.api.PersonDto;
import de.thwildau.bibinfo.freemarker.api.TeamDto;

public class DataHelper {

    private static List<PersonDto> personDtos;
    private static List<EmployeeDto> employeeDtos;
    private static List<TeamDto> teamDtos;

    public static List<PersonDto> getPersonDtos() {
        if (personDtos == null || personDtos.isEmpty()) {
            generateDataStructure();
        }
        return personDtos;
    }


    public static List<EmployeeDto> getEmployeeDtos() {
        if (employeeDtos == null || employeeDtos.isEmpty()) {
            generateDataStructure();
        }
        return employeeDtos;
    }

    public static List<TeamDto> getTeamDtos() {
        if (teamDtos == null || teamDtos.isEmpty()) {
            generateDataStructure();
        }
        return teamDtos;
    }

    private static void generateDataStructure() {
        //Listen anlegen
        personDtos = new ArrayList<>();
        employeeDtos = new ArrayList<>();
        teamDtos = new ArrayList<>();

        //PersonenDto-Instanzen erzeugen
        PersonDto p1 = new PersonDto(1, "Horst", "Lichter", "Barstrasse", "20", "01234", "Rarstadt");
        PersonDto p2 = new PersonDto(2, "Ulrike", "Beetmann", "Irgendwo", "30", "56789", "Nuernberg");
        PersonDto p3 = new PersonDto(3, "Marcell", "Davis", "Voller Empfang", "100", "11111", "Einsundeins");
        PersonDto p4 = new PersonDto(4, "Huhu", "der Uhu", "Tanne", "2536715", "00000", "Wald");
        //in Klasse hinzufuegen
        personDtos.addAll(Arrays.asList(p1, p2, p3, p4));

        //AngestelltenDto-Instanzen erzeugen
        EmployeeDto e1 = new EmployeeDto(101, "101", personDtos.get(1));
        EmployeeDto e2 = new EmployeeDto(102, "102", personDtos.get(2));
        EmployeeDto e3 = new EmployeeDto(103, "103", personDtos.get(3));
        EmployeeDto e4 = new EmployeeDto(104, "104", personDtos.get(4));
        //in Klasse hinzufuegen
        employeeDtos.addAll(Arrays.asList(e1, e2, e3, e4));

        //Teamsets erstellen, da Angestellte in TeamDto als Set angelegt
        Set<EmployeeDto> teamset1 = new HashSet<>();
        teamset1.add(e1);
        teamset1.add(e2);
        Set<EmployeeDto> teamset2 = new HashSet<>();
        teamset2.add(e3);
        teamset2.add(e4);

        //TeamDto-Instanzen erzeugen
        TeamDto t1 = new TeamDto(1001, "Team Alpha", "alpha", teamset1);
        TeamDto t2 = new TeamDto(1002, "Team 1", "eins", teamset2);
        //in Klasse hinzufuegen
        teamDtos.addAll(Arrays.asList(t1, t2));

    }


    //Zusatz 8 + 9
    public static TeamDto addTeam(TeamDto teamDto) {
        //id von Team "generieren" wenn 0 oder null
        if (teamDto.getId() == null || teamDto.getId() == 0) {
            teamDto.setId(teamDtos.getLast().getId() + 1);
            //team zum teamDtos hinzufuegen
            teamDtos.add(teamDto);
        } else {
            //Schleife durch teamDtos
            for (int i = 0; i < teamDtos.size(); i++) {
                //pruefen auf gleiche id
                if (Objects.equals(teamDtos.get(i).getId(), teamDto.getId())) {
                    //entsprechend entfernen
                    teamDtos.remove(i);
                    //for Schleife vorzeitig verlassen
                    break;
                }
            }
            //team zum teamDtos hinzufuegen
            teamDtos.add(teamDto);
        }
        return teamDto;
    }


}


