package com.microservices.kafka.order.microservices_kafka_demo.controller;

import io.micrometer.observation.annotation.Observed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    @Observed(name = "test.endpoint")
    public String test() {
        return "OK";
    }
}
