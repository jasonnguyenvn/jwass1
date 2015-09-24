/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.sales;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Hau
 */
public class orderDTO implements Serializable {
    private String orderID;
    private Date orderDate;
    private String customerID;
    private float total;
    private String address;
    private String phone;
    
    private List<orderDetailDTO> items;

    public orderDTO() {
        items = new ArrayList<>();
    }

    public orderDTO(String orderID, Date orderDate, String customerID, 
            float total, String address, String phone) {
        items = new ArrayList<>();
        
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.customerID = customerID;
        this.total = total;
        this.address = address;
        this.phone = phone;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.orderID);
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
        final orderDTO other = (orderDTO) obj;
        return Objects.equals(this.orderID, other.orderID);
    }

    @Override
    public String toString() {
        return "orderDTO{" + "orderID=" + orderID + '}';
    }
    
}
