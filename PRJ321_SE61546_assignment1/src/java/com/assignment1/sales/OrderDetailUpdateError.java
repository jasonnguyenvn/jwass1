/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.sales;

import com.assignment1.common.DBErrorBaseClass;

/**
 *
 * @author Hau
 */
public class OrderDetailUpdateError extends DBErrorBaseClass {
    private String quantityLessThanOneErr;
    private String invalidQuantityValueErr;
    

    public String getQuantityLessThanOneErr() {
        return quantityLessThanOneErr;
    }

    public void setQuantityLessThanOneErr(String quantityLessThanOneErr) {
        this.quantityLessThanOneErr = quantityLessThanOneErr;
        this.setRaisedErrors(true);
    }

    public String getInvalidQuantityValueErr() {
        return invalidQuantityValueErr;
    }

    public void setInvalidQuantityValueErr(String invalidQuantityValueErr) {
        this.invalidQuantityValueErr = invalidQuantityValueErr;
        this.setRaisedErrors(true);
    }
    
    
}
