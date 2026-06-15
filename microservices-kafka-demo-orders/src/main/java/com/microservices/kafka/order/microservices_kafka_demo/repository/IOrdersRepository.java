package com.microservices.kafka.order.microservices_kafka_demo.repository;

import com.microservices.kafka.order.microservices_kafka_demo.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdersRepository extends CrudRepository<Order, Long> {
}
