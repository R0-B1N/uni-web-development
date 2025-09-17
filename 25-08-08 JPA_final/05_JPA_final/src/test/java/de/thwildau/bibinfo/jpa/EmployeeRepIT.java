// Aufgabe 13
package de.thwildau.bibinfo.jpa;

import java.util.Optional;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import de.thwildau.bibinfo.jpa.model.Employee;
import de.thwildau.bibinfo.jpa.model.Person;
import de.thwildau.bibinfo.jpa.model.Team;
import de.thwildau.bibinfo.jpa.repository.EmployeeRepository;
import de.thwildau.bibinfo.jpa.repository.PersonRepository;
import de.thwildau.bibinfo.jpa.repository.TeamRepository;

@SpringBootTest
// Reihenfolge festlegen
@TestMethodOrder(OrderAnnotation.class)
// Stück für Stück und Pro Klasse festlegen
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EmployeeRepIT {

    // Mithilfe von Spring die Konstruktoren Autowiren
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PersonRepository personRepository;

    // Speichervariablen für die Ids
    private Integer testPersonId;
    private Integer testTeamId;
    private Integer testEmployeeId;

    // Datenbank mit einem Datensatz vorbereiten
    @BeforeAll
    void setup() {
        // Person anlegen
        Person person = new Person();
        person.setForename("Peace");
        person.setSurname("Maker");
        person.setStreet("Friedensstrasse");
        person.setNumber("1");
        person.setCity("Murica");
        person.setZipCode("12345");

        // Person speichern
        testPersonId = personRepository.save(person).getId();

        // Team anlegen
        Team team = new Team();
        team.setName("Friedensstifter");
        team.setCode("FrSt");

        // Team speichern
        testTeamId = teamRepository.save(team).getId();
    }

    // Danach Datenbank bereinigen
    @AfterAll
    void cleanup() {
        // Person löschen
        personRepository.deleteById(testPersonId);
        // Team löschen
        teamRepository.deleteById(testTeamId);
    }

    // Employee Tests
    // Einen Employee einstellen
    @Test
    // Ausführen als ersten Test
    @Order(1)
    // Daten beibehalten und nicht verwerfen
    @Transactional
    @Rollback(false)
    void createEmployee() {
        // Angelegte person anhand der Id finden, sonst fehler ausgeben (orElseThrow)
        Person person = personRepository.findById(testPersonId).orElseThrow();
        // Angelegtes team anhand der Id finden
        Team team = teamRepository.findById(testTeamId).orElseThrow();

        // neuen Employee anlegen
        Employee employee = new Employee();
        employee.setPerson(person);
        employee.setTeam(team);
        employee.setEmployeeNumber("PM1");

        // Employee speichern
        testEmployeeId = employeeRepository.save(employee).getId();

        // Test auf nicht leer, passende PersonID und passende TeamID
        Assertions.assertNotNull(testEmployeeId);
        Assertions.assertEquals(person.getId(), employee.getPerson().getId());
        Assertions.assertEquals(team.getId(), employee.getTeam().getId());

    }

    // Einen Employee finden
    @Test
    // Ausführen als zweiten Test
    @Order(2)
    // Daten beibehalten und nicht verwerfen
    @Transactional
    @Rollback(false)
    void getEmployee() {
        // Employee anhand der ID finden
        // Optional, da leer sein könnte
        Optional<Employee> employee = employeeRepository.findById(testEmployeeId);
        // Test auf vorhandensein
        Assertions.assertTrue(employee.isPresent());
        // Test auf korrekte Employee-Number
        Assertions.assertEquals("PM1", employee.get().getEmployeeNumber());
    }

    // Einen Employee updaten
    @Test
    // Ausführen als dritten Test
    @Order(3)
    // Daten beibehalten und nicht verwerfen
    @Transactional
    @Rollback(false)
    void updateEmployee() {
        // Employee anhand der ID finden, sonst fehler ausgeben (orElseThrow)
        Employee employee = employeeRepository.findById(testEmployeeId).orElseThrow();
        // Anpassung der Employee-Number
        employee.setEmployeeNumber("PeMa1");

        // Speichern/Überschreiben des Datensatzes
        Employee updatedEmployee = employeeRepository.save(employee);

        // Test auf korrekt geänderten Wert
        Assertions.assertEquals("PeMa1", updatedEmployee.getEmployeeNumber());
    }

    // Einen Employee löschen
    @Test
    // Test als viertes ausführen
    @Order(4)
    // beibehaltene Daten übernehmen aber danach verwerfen
    @Transactional
    void deleteEmployee() {
        // Employee anhand der ID löschen
        employeeRepository.deleteById(testEmployeeId);
        // Test auf nicht (mehr) vorhandenen Datensatz
        Assertions.assertFalse(employeeRepository.findById(testEmployeeId).isPresent());
    }

}
