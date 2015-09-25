/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.sales;

import com.assignment1.account.AccountDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Hau
 */
public class OrderDTO implements Serializable {
    private String orderID;
    private Date orderDate;
    private AccountDTO customer;
    private float total;
    private String address;
    private String phone;
    
    private List<OrderDetailDTO> items;

    public OrderDTO() {
        items = new ArrayList<>();
    }

    public OrderDTO(String orderID, Date orderDate, AccountDTO customer, 
            float total, String address, String phone) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.customer = customer;
        this.total = total;
        this.address = address;
        this.phone = phone;
        
        items = new ArrayList<>();
    }

    public OrderDTO(String orderID, Date orderDate, AccountDTO customer, 
            float total, String address, String phone, List<OrderDetailDTO> items) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.customer = customer;
        this.total = total;
        this.address = address;
        this.phone = phone;
        this.items = items;
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

    public AccountDTO getCustomer() {
        return customer;
    }

    public void setCustomer(AccountDTO customer) {
        this.customer = customer;
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

    public List<OrderDetailDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderDetailDTO> items) {
        this.items = items;
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
        final OrderDTO other = (OrderDTO) obj;
        return Objects.equals(this.orderID, other.orderID);
    }

    @Override
    public String toString() {
        return "orderDTO{" + "orderID=" + orderID + '}';
    }
    
}
