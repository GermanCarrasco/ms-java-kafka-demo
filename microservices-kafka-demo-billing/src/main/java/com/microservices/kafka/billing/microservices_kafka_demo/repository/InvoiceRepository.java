package com.microservices.kafka.billing.microservices_kafka_demo.repository;

import com.microservices.kafka.billing.microservices_kafka_demo.entities.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoices,Long> {
}
