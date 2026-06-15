package com.microservices.kafka.order.microservices_kafka_demo.controller;

import com.microservices.kafka.order.microservices_kafka_demo.dtos.CreateOrderRequest;
import com.microservices.kafka.order.microservices_kafka_demo.service.IOrdersService;
import com.microservices.kafka.order.microservices_kafka_demo.service.OrdersServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
@RequestMapping("api/v1/orders")
public class OrdersController {

    @Autowired
    private OrdersServiceImpl ordersService;

    @PostMapping
    public ResponseEntity<?> CreateOrder(@Valid @RequestBody CreateOrderRequest order)
    {
        return ResponseEntity.ok(ordersService.createOrder(order));
    }

}
