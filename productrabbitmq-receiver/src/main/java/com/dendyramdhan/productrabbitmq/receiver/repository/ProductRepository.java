package com.dendyramdhan.productrabbitmq.receiver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dendyramdhan.productrabbitmq.common.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}