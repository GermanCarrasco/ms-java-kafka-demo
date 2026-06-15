package com.microservices.kafka.order.microservices_kafka_demo.service;

import com.microservices.kafka.order.microservices_kafka_demo.dtos.CreateOrderRequest;
import com.microservices.kafka.order.microservices_kafka_demo.dtos.CreatedOrderResponse;
import com.microservices.kafka.order.microservices_kafka_demo.entity.Order;

public interface IOrdersService {
    CreatedOrderResponse createOrder(CreateOrderRequest order);
}
