package com.daroca.models;

import jakarta.persistence.*;

@Entity
@Table
public class SalesOrderItem {

    @EmbeddedId
    private SalesOrderItemKey salesOrderItemId;

    @ManyToOne
    @MapsId("salesOrderId")
    @JoinColumn(name = "sales_order_id", foreignKey = @ForeignKey(name = "FK_SalesOrderItem_Sales"))
    private SalesOrder salesOrder;

    @ManyToOne // cardinalidade da relação
    @MapsId("productId")
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "FK_SalesOrderItem_Product"))
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    public SalesOrderItem(){

    }

    public SalesOrderItem(SalesOrder salesOrder, Product product, Integer quantity){
        this.salesOrder = salesOrder;
        this.product = product;
        this.quantity = quantity;
    }

    public SalesOrder getSalesOrder(){
        return this.salesOrder;
    }

    public void setSalesOrder(){
        this.salesOrder = salesOrder;
    }

    public Product getProduct(){
        return this.product;
    }

    public void setProduct(){
        this.product = product;
    }

    public Integer getQuantity(){
        return this.quantity;
    }

    public void setQuantity(){
        this.quantity = quantity;
    }

    public boolean equals(SalesOrderItem other){
        return this.salesOrder.equals(other.getSalesOrder()) && this.product.equals(other.getProduct());
    }
    
}
