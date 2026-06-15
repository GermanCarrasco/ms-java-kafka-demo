package com.microservices.kafka.billing.microservices_kafka_demo.services;

import com.microservices.kafka.billing.microservices_kafka_demo.dto.OrderCreatedEvent;

public interface InvoiceService {
    void createInvoice(OrderCreatedEvent orderCreatedEvent);
}
