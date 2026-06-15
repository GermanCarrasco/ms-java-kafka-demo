package com.microservices.kafka.order.microservices_kafka_demo.dtos;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatedOrderResponse {
    private Long orderId;
    private String orderStatus;
}
