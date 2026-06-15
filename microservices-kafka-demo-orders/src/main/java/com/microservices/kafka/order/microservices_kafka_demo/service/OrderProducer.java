package com.microservices.kafka.order.microservices_kafka_demo.service;

import com.microservices.kafka.order.microservices_kafka_demo.dtos.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public void publish(OrderCreatedEvent event){
        kafkaTemplate.send("order-created",event.orderId().toString(),event);
    }
}
