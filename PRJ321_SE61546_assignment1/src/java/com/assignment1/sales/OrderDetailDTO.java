/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.sales;

import java.io.Serializable;

/**
 *
 * @author Hau
 */
public class OrderDetailDTO implements Serializable {
    private int id;
    private ProductDTO product;
    private int quantity;
    private float unitPrice;
    private String unitItem;
    private float total;
    private String orderID;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(ProductDTO product, int quantity, float unitPrice, String unitItem, float total, String orderID) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.unitItem = unitItem;
        this.total = total;
        this.orderID = orderID;
    }

    public OrderDetailDTO(int id, ProductDTO product, int quantity, float unitPrice, String unitItem, float total, String orderID) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.unitItem = unitItem;
        this.total = total;
        this.orderID = orderID;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnitItem() {
        return unitItem;
    }

    public void setUnitItem(String unitItem) {
        this.unitItem = unitItem;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderDetailDTO other = (OrderDetailDTO) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "orderDetailDTO{" + "id=" + id + ", productID=" + product + ", orderID=" + orderID + '}';
    }
    
    
    
}
