package com.daroca.controllers;

import com.daroca.models.Customer;
import com.daroca.models.Product;
import com.daroca.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> all(){
        return repository.findAll();
    }

    @GetMapping("/products/{productId}")
    public Optional<Product> one(@PathVariable Integer productId){
        return repository.findById(productId);
    }

    @DeleteMapping("/products/{productId}")
    public void delete(@PathVariable Integer productId){
        repository.deleteById(productId);
    }

    @PostMapping("/products/{productId}")
    public Product save(@RequestBody Product newProduct){
        return repository.save(newProduct);
    }

    @PutMapping("/products/{productId}")
    public Product replace(@RequestBody Product newProduct, @PathVariable Integer productId){

        return repository.findById(productId)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setUnitPrice(newProduct.getUnitPrice());
                    return repository.save(product);
                })
                .orElseGet(() ->{
                    return repository.save(newProduct);
                });
    }
}
