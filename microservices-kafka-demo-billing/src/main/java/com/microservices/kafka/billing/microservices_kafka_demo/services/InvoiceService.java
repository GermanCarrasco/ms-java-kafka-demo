package com.microservices.kafka.billing.microservices_kafka_demo.services;

import com.microservices.kafka.billing.microservices_kafka_demo.dto.OrderCreatedEvent;
import com.microservices.kafka.billing.microservices_kafka_demo.entities.Invoices;

import java.util.Optional;

public interface InvoiceService {
    void createInvoice(OrderCreatedEvent orderCreatedEvent);
    Optional<Invoices> findInvoiceByOrderId(Long orderId);
}
