package com.example.paycore.entities;

import com.example.paycore.enums.EmployeeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = -8340365816082106109L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private int age;

    private Date startDate;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    @Override
    public String toString() {
        return id + ". " + firstName + " " + lastName + " " + age + " " + startDate + " " + employeeType;
    }
}
