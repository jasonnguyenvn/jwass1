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
public class orderDetailDTO implements Serializable {
    private int id;
    private String productID;
    private int quantity;
    private float unitPrice;
    private String unitItem;
    private float total;
    private String orderID;

    public orderDetailDTO() {
    }

    public orderDetailDTO(String productID, int quantity, float unitPrice, String unitItem, float total, String orderID) {
        this.productID = productID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.unitItem = unitItem;
        this.total = total;
        this.orderID = orderID;
    }

    public orderDetailDTO(int id, String productID, int quantity, float unitPrice, String unitItem, float total, String orderID) {
        this.id = id;
        this.productID = productID;
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

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
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
        final orderDetailDTO other = (orderDetailDTO) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "orderDetailDTO{" + "id=" + id + ", productID=" + productID + ", orderID=" + orderID + '}';
    }
    
    
    
}
