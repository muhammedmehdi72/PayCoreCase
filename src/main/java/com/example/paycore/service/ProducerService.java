package com.example.paycore.service;

import com.example.paycore.entities.Employee;

public interface ProducerService {

    void insertMessage(Employee msg);

    void updateMessage(Employee msg);
}
