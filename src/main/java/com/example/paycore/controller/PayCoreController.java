package com.example.paycore.controller;

import com.example.paycore.entities.Employee;
import com.example.paycore.model.Request;
import com.example.paycore.model.Response;
import com.example.paycore.service.PayCoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PayCoreController {

    private final PayCoreService payCoreService;

    @Cacheable(value = "employee", key = "#request.action + ' ' + #request.employee.toString()")
    @PostMapping("/action")
    public Response<Employee> action(@RequestBody Request request) {
        return payCoreService.action(request);
    }
}
