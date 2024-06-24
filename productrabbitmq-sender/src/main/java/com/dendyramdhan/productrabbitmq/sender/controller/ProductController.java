package com.dendyramdhan.productrabbitmq.sender.controller;

import com.dendyramdhan.productrabbitmq.common.entity.Product;
import com.dendyramdhan.productrabbitmq.sender.service.ProductSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductSenderService productSenderService;

    @Autowired
    public ProductController(ProductSenderService productSenderService) {
        this.productSenderService = productSenderService;
    }

    @Operation(summary = "Create a new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        productSenderService.send("CREATE", product);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Update an existing product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productSenderService.send("UPDATE", product);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Delete a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productSenderService.send("DELETE", new Product(id, null, null, 0));
        return ResponseEntity.ok().build();
    }
}
