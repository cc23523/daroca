package com.daroca.models;


/*
- productId int
- name String
- unitPrice double
*/


import jakarta.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(length = 50, nullable = false)
    private String name;

    @Column
    private Double unitPrice;

    @OneToMany
    @JoinColumn(name = "product_category_id", foreignKey = @ForeignKey(name = "FK_Product_ProductCategory"))
    private ProductCategory productCategory;


    //Construtor
    public Product(Integer productId, String name, Double unitPrice){
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    //getter e setter

    public Integer getProductId(){
        return this.productId;
    }

    public void setProductId(){
        this.productId = productId;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = this.name;
    }

    public Double getUnitPrice(){
        return this.unitPrice;
    }

    public void setUnitPrice(Double unitPrice){
        this.unitPrice = this.unitPrice;
    }

    public boolean equals(Customer other){
        return this.productId.equals(other.getId()) && this.name.equals(other.getName());
    }

    //toString
    public String toString() {
        return "Customer[id = " + this.productId + ", name = " + this.name + "]";
    }

}
