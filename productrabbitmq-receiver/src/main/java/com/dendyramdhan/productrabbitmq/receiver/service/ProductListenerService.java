package com.dendyramdhan.productrabbitmq.receiver.service;

import com.dendyramdhan.productrabbitmq.receiver.entity.Product;
import com.dendyramdhan.productrabbitmq.receiver.entity.ProductMessage;
import com.dendyramdhan.productrabbitmq.receiver.repository.ProductRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductListenerService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductListenerService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RabbitListener(queues = "product_queue")
    public void receive(ProductMessage message) {
        Product product = message.getProduct();
        switch (message.getAction()) {
            case "CREATE":
            case "UPDATE":
                productRepository.save(product);
                break;
            case "DELETE":
                productRepository.deleteById(product.getId());
                break;
        }
    }
}