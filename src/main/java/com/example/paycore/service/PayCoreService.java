package com.example.paycore.service;

import com.example.paycore.entities.Employee;
import com.example.paycore.model.Request;
import com.example.paycore.model.Response;

public interface PayCoreService {

    Response<Employee> action(Request request);

    Response<Employee> fetchList(Employee employee);

    void update(Employee employee);

    void insert(Employee employee);
}
