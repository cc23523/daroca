package com.daroca.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class SalesOrder{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salesOrderId;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = true)
    private LocalDate estimatedDeliveryDate;

    @Column(nullable = false, length = 30)
    private String status;

    @Column(nullable = false)
    private Double total;

    public SalesOrder(){

    }
    public SalesOrder(Integer salesOrderId, LocalDateTime orderDate,
                      LocalDate estimatedDeliveryDate, String status,
                      Double total){
        this.salesOrderId = salesOrderId;
        this.orderDate = orderDate;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.status = status;
        this.total = total;
    }

    //getter e setter

    public Integer getSalesOrderId(){
        return this.salesOrderId;
    }

    public void setSalesOrderId(){
        this.salesOrderId = salesOrderId;
    }

    public LocalDateTime getOrderDate(){
        return this.orderDate;
    }

    public void setOrderDate(){
        this.orderDate = orderDate;
    }

    public LocalDate getEstimatedDeliveryDate(){
        return this.estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(){
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(){
        this.status = status;
    }

    public Double getTotal(){
        return this.total;
    }

    public void setTotal(){
        this.total = total;
    }

    public boolean equals(SalesOrder other){
        return this.salesOrderId.equals(other.getSalesOrderId()) && this.status.equals(other.getStatus());
    }

    public String toString(){
        return "Sale Order[id" + this.salesOrderId +
                ", estimated delivery date:" + this.estimatedDeliveryDate +
                ", order status:" + status + ", total:" + this.total + "]";
    }
}
