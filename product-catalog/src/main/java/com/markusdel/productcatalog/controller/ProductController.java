package com.markusdel.productcatalog.controller;

import com.markusdel.productcatalog.model.Product;
import com.markusdel.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product newProduct) {
        Product createdProduct = repository.save(newProduct);
        return createdProduct;
    }

    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return repository.findById(id);
    }
}
