package com.example.paycore.model;

import com.example.paycore.entities.Employee;
import com.example.paycore.enums.Actions;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request {
    private Actions action;
    private Employee employee;
}
