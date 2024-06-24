package com.dendyramdhan.productrabbitmq.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductMessage {
    private String action;
    private Product product;
}
