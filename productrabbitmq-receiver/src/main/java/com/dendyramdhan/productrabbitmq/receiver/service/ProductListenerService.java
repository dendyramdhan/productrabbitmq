package com.dendyramdhan.productrabbitmq.receiver.service;

import com.dendyramdhan.productrabbitmq.common.entity.Product;
import com.dendyramdhan.productrabbitmq.common.entity.ProductMessage;
import com.dendyramdhan.productrabbitmq.receiver.repository.ProductRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductListenerService {

    private static final Logger logger = LoggerFactory.getLogger(ProductListenerService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductListenerService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RabbitListener(queues = "product_queue")
    @Transactional
    public void receive(ProductMessage message) {
        Product product = message.getProduct();
        logger.info("Received message: action={}, product={}", message.getAction(), product);

        switch (message.getAction()) {
            case "CREATE":
            case "UPDATE":
                productRepository.save(product);
                logger.info("Saved product: {}", product);
                break;
            case "DELETE":
                productRepository.deleteById(product.getId());
                logger.info("Deleted product with ID: {}", product.getId());
                break;
        }
    }
}