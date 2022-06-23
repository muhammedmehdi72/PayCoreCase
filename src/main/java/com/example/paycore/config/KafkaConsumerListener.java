package com.example.paycore.config;

import com.example.paycore.entities.Employee;
import com.example.paycore.service.PayCoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumerListener {

    private final PayCoreService payCoreService;

    @KafkaListener(topics = "${spring.kafka.topic.insert}", groupId = "${spring.kafka.consumer.group-id}")
    public void listenInsert(Employee employee) {
        System.out.println(String.format("Received Messasge: [%s] ", employee));
        payCoreService.insert(employee);
    }

    @KafkaListener(topics = "${spring.kafka.topic.update}", groupId = "${spring.kafka.consumer.group-id}")
    public void listenUpdate(Employee employee) {
        System.out.println(String.format("Received Messasge: [%s] ", employee));
        payCoreService.update(employee);
    }
}