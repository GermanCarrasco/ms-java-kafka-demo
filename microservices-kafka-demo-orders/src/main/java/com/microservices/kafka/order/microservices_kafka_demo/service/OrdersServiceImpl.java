package com.microservices.kafka.order.microservices_kafka_demo.service;

import com.microservices.kafka.order.microservices_kafka_demo.dtos.CreateOrderRequest;
import com.microservices.kafka.order.microservices_kafka_demo.dtos.CreatedOrderResponse;
import com.microservices.kafka.order.microservices_kafka_demo.dtos.OrderCreatedEvent;
import com.microservices.kafka.order.microservices_kafka_demo.entity.Order;
import com.microservices.kafka.order.microservices_kafka_demo.mapping.OrdersMapping;
import com.microservices.kafka.order.microservices_kafka_demo.repository.IOrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersRepository ordersRepository;
    @Autowired
    private OrderProducer orderProducer;

    @Override
    public CreatedOrderResponse createOrder(CreateOrderRequest request) {

        var response = OrdersMapping.OrderToCreatedOrderResponse(ordersRepository.save(OrdersMapping.RequestToOrders(request)));
        //Se publica el evento en kafka
        orderProducer.publish(new OrderCreatedEvent(response.getOrderId(),request.getCustomerName(),request.getAmount()));
        return response;
    }

}
