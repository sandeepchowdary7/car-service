package com.carservice.carservice.controllers;

import com.carservice.carservice.models.Products;
import com.carservice.carservice.services.ProductServicee;
import org.springframework.web.bind.annotation.*;

public class ProductController {

    private ProductServicee productServicee;

    public ProductController(ProductServicee productServicee) {
        this.productServicee = productServicee;
    }

    @GetMapping("/products")
    private Object getAllProducts() {
      return productServicee.getAllProducts();
    }

    @GetMapping("/product/{productId}")
    private Object getProduct(@PathVariable("productId") int id) {
        return productServicee.getProductById(id);
    }

    @PostMapping("/product")
    private Object saveProduct(Products product) {
        return productServicee.saveProduct(product);
    }

    @PutMapping("/product/{productId}")
    private Object updateProduct(Products product, @PathVariable("productId") int id) {
        return productServicee.updateProduct(product, id);
    }

    @DeleteMapping("/product/{productId}")
    private Object deleteProduct(@PathVariable("productId") int id) {
        return productServicee.deleteproduct(id);
    }
}