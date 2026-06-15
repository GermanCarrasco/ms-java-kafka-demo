package com.microservices.kafka.order.microservices_kafka_demo.topics;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Configuration
public class KafkaTopics {

    @Bean
    public NewTopic orderCreatedTopic() {
        return TopicBuilder.name("order-created").build();
    }
}
