package com.microservices.kafka.order.microservices_kafka_demo;

import com.microservices.kafka.order.microservices_kafka_demo.dtos.CreateOrderRequest;
import com.microservices.kafka.order.microservices_kafka_demo.dtos.OrderCreatedEvent;
import com.microservices.kafka.order.microservices_kafka_demo.entity.Order;
import com.microservices.kafka.order.microservices_kafka_demo.repository.IOrdersRepository;
import com.microservices.kafka.order.microservices_kafka_demo.service.OrderProducer;
import com.microservices.kafka.order.microservices_kafka_demo.service.OrdersServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    private OrdersServiceImpl ordersService;

    @Mock
    private OrderProducer producer;

    @Mock
    private IOrdersRepository repository;

    @Test
    void shouldCreateOrder(){

        CreateOrderRequest req = CreateOrderRequest.builder()
                .customerName("German")
                .amount(BigDecimal.valueOf(50200))
                .build();

        Order savedOrder = Order.builder()
                .id(1L)
                .status("CREATED")
                .build();

        when(repository.save(any(Order.class)))
                .thenReturn(savedOrder);

        ordersService.createOrder(req);

        verify(repository).save(any(Order.class));

        ArgumentCaptor<OrderCreatedEvent> captor =
                ArgumentCaptor.forClass(OrderCreatedEvent.class);

        verify(producer).publish(captor.capture());

        OrderCreatedEvent event = captor.getValue();

        assertEquals(1L, event.orderId());
        assertEquals("German", event.customerName());
        assertEquals(BigDecimal.valueOf(50200), event.amount());
    }

}
