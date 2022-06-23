package com.example.paycore.service.impl;

import com.example.paycore.entities.Employee;
import com.example.paycore.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

    private final KafkaTemplate<String, Employee> kafkaTemplate;

    @Value("${spring.kafka.topic.insert}")
    private String insertTopic;

    @Value("${spring.kafka.topic.update}")
    private String updateTopic;

    @Override
    public void insertMessage(Employee msg) {
        kafkaTemplate.send(insertTopic, msg);
    }

    @Override
    public void updateMessage(Employee msg) {
        kafkaTemplate.send(updateTopic, msg);
    }
}