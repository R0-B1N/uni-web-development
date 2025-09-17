package de.thwildau.bibinfo.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import de.thwildau.bibinfo.jpa.model.Employee;

// Aufgabe 9
// Repository für die jeweilige Entität
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findByTeamId(Integer teamId);
}
