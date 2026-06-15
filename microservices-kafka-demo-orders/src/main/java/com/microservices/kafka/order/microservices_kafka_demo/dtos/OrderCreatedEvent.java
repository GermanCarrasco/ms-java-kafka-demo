package com.microservices.kafka.order.microservices_kafka_demo.dtos;

import java.math.BigDecimal;

public record OrderCreatedEvent (Long orderId, String customerName, BigDecimal amount) { };

