package com.microservices.kafka.order.microservices_kafka_demo.mapping;

import com.microservices.kafka.order.microservices_kafka_demo.dtos.CreateOrderRequest;
import com.microservices.kafka.order.microservices_kafka_demo.dtos.CreatedOrderResponse;
import com.microservices.kafka.order.microservices_kafka_demo.entity.Order;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class OrdersMapping {


    public static Order RequestToOrders(CreateOrderRequest request){
        return Order.builder()
                .amount(request.getAmount())
                .customerName(request.getCustomerName())
                .status("CREATED")
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static CreatedOrderResponse  OrderToCreatedOrderResponse(Order order){
        return CreatedOrderResponse.builder()
                .orderStatus(order.getStatus())
                .orderId(order.getId())
                .build();
    }

}
