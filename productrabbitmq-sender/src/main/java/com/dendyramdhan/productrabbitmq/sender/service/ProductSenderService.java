package com.dendyramdhan.productrabbitmq.sender.service;

import com.dendyramdhan.productrabbitmq.common.entity.Product;
import com.dendyramdhan.productrabbitmq.common.entity.ProductMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProductSenderService {

    private static final Logger logger = LoggerFactory.getLogger(ProductSenderService.class);

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ProductSenderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String action, Product product) {
        logger.info("Sending message: action={}, product={}", action, product);
        rabbitTemplate.convertAndSend("product_queue", new ProductMessage(action, product));
    }
}
