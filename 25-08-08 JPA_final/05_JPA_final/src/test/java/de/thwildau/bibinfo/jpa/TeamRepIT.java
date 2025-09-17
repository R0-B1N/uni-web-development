// Aufgabe 13
package de.thwildau.bibinfo.jpa;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import de.thwildau.bibinfo.jpa.model.Team;
import de.thwildau.bibinfo.jpa.repository.TeamRepository;

@SpringBootTest
// Reihenfolge festlegen
@TestMethodOrder(OrderAnnotation.class)
// Stück für Stück und Pro Klasse festlegen
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TeamRepIT {

    // Mithilfe von Spring die Konstruktoren Autowiren
    @Autowired
    private TeamRepository teamRepository;

    // Speichervariablen für die Ids
    private Integer testTeamId;

    // Ein Team erstellen
    @Test
    // Ausführen als ersten Test
    @Order(1)
    void createTeam() {
        // Team anlegen
        Team team = new Team();
        team.setName("Test Team");
        team.setCode("TT");

        // Team speichern
        Team savedTeam = teamRepository.save(team);

        // Team auf angelegte Id prüfen
        testTeamId = savedTeam.getId();

    }

    // Ein Team finden
    @Test
    // Ausführen als zweiten Test
    @Order(2)
    void getTeam() {
        // Team anhand der ID dinden
        // Optional, da leer sein könnte
        Optional<Team> team = teamRepository.findById(testTeamId);
        // Test auf nicht vorhandensein
        Assertions.assertTrue(team.isPresent());
        // Test auf korrekte Team Namen (kann auch auf andere Felder testen)
        Assertions.assertEquals("Test Team", team.get().getName());
    }

    // Ein Team updaten
    @Test
    // Ausführen als dritten Test
    @Order(3)
    void updateTeam() {
        // Team anhand der ID finden, sonst fehler ausgeben (orElseThrow)
        Team team = teamRepository.findById(testTeamId).orElseThrow();
        // Anpassung des Team-Codes
        team.setCode("TeTe");

        // Speichern/Überschreiben des Datensatzes
        Team updatedTeam = teamRepository.save(team);

        // Test auf korrekt geänderten Wert
        Assertions.assertEquals("TeTe", updatedTeam.getCode());
    }

    // Ein Team löschen
    @Test
    // Test als viertes ausführen
    @Order(4)
    void deleteTeam() {
        // Employee anhand der ID löschen
        teamRepository.deleteById(testTeamId);
        // Test auf nicht (mehr) vorhandenen Datensatz
        Assertions.assertFalse(teamRepository.findById(testTeamId).isPresent());
    }
}
