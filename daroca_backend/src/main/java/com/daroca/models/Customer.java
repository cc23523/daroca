package com.daroca.models;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100)
    private String email;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    //the builder
    public Customer(Integer id, String name, String email, Double latitude, Double longitude){
        this.id = id;
        this.name = name;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //getter e setter
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Double getLatitude(){
        return this.latitude;
    }

    public void setLatitude(Double latitude){
        this.latitude = latitude;
    }

    public Double getLongitude(){
        return this.longitude;
    }

    public void setLongitude(Double longitude){
        this.longitude = longitude;
    }

    //Equals
    public boolean equals(Customer other){
        return this.id.equals(other.getId()) && this.name.equals(other.getName());
    }

    //toString
    public String toString() {
        return "Customer[id = " + this.id + ", name = " + this.name + "]";
    }

}
