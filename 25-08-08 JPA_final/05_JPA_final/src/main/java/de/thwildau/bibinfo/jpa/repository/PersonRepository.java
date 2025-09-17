package de.thwildau.bibinfo.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.thwildau.bibinfo.jpa.model.Person;

// Aufgabe 9
// Repository für die jeweilige Entität
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
