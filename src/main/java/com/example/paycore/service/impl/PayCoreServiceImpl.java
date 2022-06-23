package com.example.paycore.service.impl;

import com.example.paycore.entities.Employee;
import com.example.paycore.model.Request;
import com.example.paycore.model.Response;
import com.example.paycore.repository.EmployeeRepository;
import com.example.paycore.service.PayCoreService;
import com.example.paycore.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PayCoreServiceImpl implements PayCoreService {

    private final ProducerService producerService;

    private final EmployeeRepository employeeRepository;

    @Override
    public Response<Employee> action(Request request) {

        Response<Employee> response = new Response<>();

        switch (request.getAction()) {
            case INSERT:
                producerService.insertMessage(request.getEmployee());
                break;
            case UPDATE:
                if(Objects.isNull(request.getEmployee().getId())) {
                    response.setMessage("Id is required!");
                }else {
                    response = fetchList(request.getEmployee());
                    if(response.isSuccess()){
                        producerService.updateMessage(request.getEmployee());
                        response.setData(List.of(request.getEmployee()));
                    }
                }
                break;
            case SELECT:
                response = fetchList(request.getEmployee());
                break;
            default:
                return null;
        }

        return response;
    }

    @Override
    public Response<Employee> fetchList(Employee employee) {
        Response<Employee> response = new Response<>();
        List<Employee> employeeList = new ArrayList<>();
        if(Objects.nonNull(employee.getId())) {
            Optional<Employee> employeeOpt = employeeRepository.findById(employee.getId());
            if(employeeOpt.isPresent()) {
                employeeList.add(employeeOpt.get());
            }else {
                response.setMessage("Data not found!");
                response.setSuccess(false);
            }
        }else {
            employeeList.addAll(employeeRepository.findEmployeeByFirstNameContainsAndLastNameContains(employee.getFirstName(), employee.getLastName()));
        }
        response.setData(employeeList);
        return response;
    }

    @CacheEvict(value = "employee", allEntries=true)
    @Override
    public void insert(Employee employee) {
        employeeRepository.save(employee);
    }

    @CacheEvict(value = "employee", allEntries=true)
    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }
}
