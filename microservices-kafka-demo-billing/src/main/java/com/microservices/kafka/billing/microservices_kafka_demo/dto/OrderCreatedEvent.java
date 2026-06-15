package com.microservices.kafka.billing.microservices_kafka_demo.dto;

import java.math.BigDecimal;

public record OrderCreatedEvent(Long orderId, String customerName, BigDecimal amount) {
}
