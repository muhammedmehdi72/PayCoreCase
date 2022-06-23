package com.example.paycore.repository;

import com.example.paycore.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findEmployeeByFirstNameContainsAndLastNameContains(String firstName, String lastName);
}
