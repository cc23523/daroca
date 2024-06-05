package com.daroca.models;

/*
- productId Integer
- name      string(50)
* * */

import jakarta.persistence.*;

@Entity
@Table
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productCategoryId;

    @Column(length = 50, nullable = false)
    private String name;



    public ProductCategory(Integer productId, String name){
        this.productCategoryId = productId;
        this.name = name;
    }

    public Integer getProductCategoryId(){
        return this.productCategoryId;
    }

    public void setProductCategoryId(){
        this.productCategoryId = productCategoryId;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = this.name;
    }

    public boolean equals(Customer other){
        return this.productCategoryId.equals(other.getId()) && this.name.equals(other.getName());
    }

    //toString
    public String toString() {
        return "Product category  [id = " + this.productCategoryId + ", name = " + this.name + "]";
    }
}
