package com.dendyramdhan.productrabbitmq.sender.service;

import com.dendyramdhan.productrabbitmq.sender.entity.Product;
import com.dendyramdhan.productrabbitmq.sender.entity.ProductMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSenderService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ProductSenderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String action, Product product) {
        rabbitTemplate.convertAndSend("product_queue", new ProductMessage(action, product));
    }
}
