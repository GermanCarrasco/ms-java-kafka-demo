package com.microservices.kafka.billing.microservices_kafka_demo.listener;

import com.microservices.kafka.billing.microservices_kafka_demo.dto.OrderCreatedEvent;
import com.microservices.kafka.billing.microservices_kafka_demo.services.InvoiceServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.BackOff;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final InvoiceServiceImpl invoiceService;

    @RetryableTopic(
            attempts = "3",
            backOff = @BackOff(delay = 6000)
    )
    @KafkaListener(topics = "order-created",groupId = "billing-group",containerFactory = "ordersFactory")
    public void listen(OrderCreatedEvent orderCreatedEvent) {
        log.info("Received OrderCreatedEvent from Kafka Order {}",orderCreatedEvent.toString());
        invoiceService.createInvoice(orderCreatedEvent);
    }
}
