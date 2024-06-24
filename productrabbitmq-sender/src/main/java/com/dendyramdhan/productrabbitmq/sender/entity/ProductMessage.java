package com.dendyramdhan.productrabbitmq.sender.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductMessage {

    private String action;
    private Product product;
}
