package com.microservices.kafka.billing.microservices_kafka_demo.services;

import com.microservices.kafka.billing.microservices_kafka_demo.dto.OrderCreatedEvent;
import com.microservices.kafka.billing.microservices_kafka_demo.entities.Invoices;
import com.microservices.kafka.billing.microservices_kafka_demo.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Override
    public void createInvoice(OrderCreatedEvent orderCreatedEvent) {
        invoiceRepository.save(Invoices.builder()
                .orderId(orderCreatedEvent.orderId())
                .customerName(orderCreatedEvent.customerName())
                .amount(orderCreatedEvent.amount())
                .invoiceNumber(UUID.randomUUID().toString())
                .createdAt(LocalDateTime.now())
                .build());
    }
}
