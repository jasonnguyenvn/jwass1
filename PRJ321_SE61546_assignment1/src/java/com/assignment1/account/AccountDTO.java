/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.account;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Hau
 */
public class AccountDTO implements Serializable {
    private String accountID;
    private String customerName;
    private String password;
    private String email;

    public AccountDTO() {
    }

    public AccountDTO(String accountID, String customerName, String password, 
            String email) {
        this.accountID = accountID;
        this.customerName = customerName;
        this.password = password;
        this.email = email;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.accountID);
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
        final AccountDTO other = (AccountDTO) obj;
        return Objects.equals(this.accountID, other.accountID);
    }

    @Override
    public String toString() {
        return accountID ;
    }
    
}
