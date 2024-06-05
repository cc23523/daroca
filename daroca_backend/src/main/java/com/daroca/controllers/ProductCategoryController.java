package com.daroca.controllers;

import com.daroca.models.ProductCategory;
import com.daroca.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pro category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryRepository repository;

    @GetMapping
    public List<ProductCategory> all(){
        return repository.findAll();
    }

    @GetMapping("/pro category/{productCategoryId}")
    public Optional<ProductCategory> one(@PathVariable Integer productCategoryId){
        return repository.findById(productCategoryId);
    }

    @DeleteMapping("/pro category/{productCategoryId}")
    public void delete(@PathVariable Integer productCategoryId){
        repository.deleteById(productCategoryId);
    }

    @PostMapping
    public ProductCategory save(@RequestBody ProductCategory newProductCategory){
        return repository.save(newProductCategory);
    }

    @PutMapping("/pro category/{productCategoryId}")
    public ProductCategory replace(@RequestBody ProductCategory newProductCategory, @PathVariable Integer productCategoryId){
        return repository.findById(productCategoryId)
                .map(productCategory -> {
                    productCategory.setName(newProductCategory.getName());
                    return repository.save(productCategory);
                })
                .orElseGet(() ->{
                    return repository.save(newProductCategory);
                });
    }
}
