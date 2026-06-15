package com.microservices.kafka.order.microservices_kafka_demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateOrderRequest {
    @NotBlank(message = "Customer cannot be blank, is required ")
    @NotNull
    String customerName;
    @NotNull
    @Positive(message = "amount must be greater than 0")
    BigDecimal amount;
}
