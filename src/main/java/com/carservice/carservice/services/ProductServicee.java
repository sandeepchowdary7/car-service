package com.carservice.carservice.services;

import com.carservice.carservice.models.Products;
import com.carservice.carservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServicee {
    private ProductRepository productRepository;

    public ProductServicee(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Object getAllProducts() {
        List<Products> products = new ArrayList();
        productRepository.findAll().forEach(products1 -> products.add(products1));
        if (products.isEmpty()) {
            return "No Products Found!";
        }
        return products;
    }

    public Object getProductById(int id) {
        Optional<Products> product = productRepository.findById(id);

        if (!product.isPresent()) {
            return "No Product Found with this is id "+id;
        }
        return product.get();
    }

    public Object saveProduct(Products product){
        return productRepository.save(product);
    }

    public Object updateProduct(Products newProduct, int id) {

        return productRepository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setDescription(newProduct.getDescription());
                    product.setCode(newProduct.getCode());
                    product.setAvailability(newProduct.getAvailability());
                    product.setStock(newProduct.getStock());

                    return productRepository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return productRepository.save(newProduct);
                });
    }

    public Object deleteproduct(int id) {
        Optional<Products> product = productRepository.findById(id);

        if (!product.isPresent()) {
            return "No product Found with this is id "+id;
        }
        productRepository.deleteById(id);
        return "product Deleted Successfully.";
    }
}