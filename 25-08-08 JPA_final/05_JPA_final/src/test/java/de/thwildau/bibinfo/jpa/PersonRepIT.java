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

import de.thwildau.bibinfo.jpa.model.Person;
import de.thwildau.bibinfo.jpa.repository.PersonRepository;

@SpringBootTest
// Reihenfolge festlegen
@TestMethodOrder(OrderAnnotation.class)
// Stück für Stück und Pro Klasse festlegen
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersonRepIT {

    // Mithilfe von Spring die Konstruktoren Autowiren
    @Autowired
    private PersonRepository personRepository;

    // Speichervariablen für die Ids
    private Integer testPersonId;


    // Eine Person Speichern
    @Test
    // Ausführen als ersten Test
    @Order(1)
    void createPerson() {
        // Person anlegen
        Person person = new Person();
        person.setForename("Ivan");
        person.setSurname("Ivanov");
        person.setStreet("Ivan Street");
        person.setNumber("12");
        person.setCity("Ivanov City");
        person.setZipCode("12345");

        // Person speichern
        Person savedPerson = personRepository.save(person);

        // Test auf selbe PersonId
        testPersonId = savedPerson.getId();
    }

    // Eine Person finden
    @Test
    // Ausführen als zweiten Test
    @Order(2)
    void getPerson() {
        // Person anhand der ID dinden
        // Optional, da leer sein könnte
        Optional<Person> person = personRepository.findById(testPersonId);
        // Test auf vorhandensein
        Assertions.assertTrue(person.isPresent());
        // Test auf korrekte Nachnamen (kann auch auf andere Felder testen)
        Assertions.assertEquals("Ivanov", person.get().getSurname());
    }

    // Eine Person updaten
    @Test
    // Ausführen als dritten Test
    @Order(3)
    void updatePerson() {
        // Person anhand der ID finden, sonst fehler ausgeben (orElseThrow)
        Person person = personRepository.findById(testPersonId).orElseThrow();
        // Anpassung der Wohmeldung
        person.setCity("New City");
        person.setStreet("New Street");
        person.setNumber("56");
        person.setZipCode("54321");

        // Speichern/Überschreiben des Datensatzes
        Person updatedPerson = personRepository.save(person);

        // Test auf korrekt geänderte Werte
        Assertions.assertEquals("New City", updatedPerson.getCity());
        Assertions.assertEquals("New Street", updatedPerson.getStreet());
        Assertions.assertEquals("56", updatedPerson.getNumber());
        Assertions.assertEquals("54321", updatedPerson.getZipCode());

    }

    // eine Person löschen
    @Test
    // Test als viertes ausführen
    @Order(4)
    void deletePerson() {
        // Employee anhand der ID löschen
        personRepository.deleteById(testPersonId);
        // Test auf nicht (mehr) vorhandenen Datensatz
        Assertions.assertFalse(personRepository.findById(testPersonId).isPresent());
    }

}
