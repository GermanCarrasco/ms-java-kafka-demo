package com.microservices.kafka.billing.microservices_kafka_demo.listener;

import com.microservices.kafka.billing.microservices_kafka_demo.dto.OrderCreatedEvent;
import com.microservices.kafka.billing.microservices_kafka_demo.services.InvoiceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final InvoiceServiceImpl invoiceService;

    @KafkaListener(topics = "order-created",groupId = "billing-group",containerFactory = "ordersFactory")
    public void listen(OrderCreatedEvent orderCreatedEvent) {
        System.out.println("Order Created Event: " + orderCreatedEvent.toString());
        invoiceService.createInvoice(orderCreatedEvent);
    }
}
