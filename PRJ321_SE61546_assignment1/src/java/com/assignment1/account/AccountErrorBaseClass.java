/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.account;

import java.io.Serializable;

/**
 *
 * @author Hau
 */
public abstract class AccountErrorBaseClass implements Serializable {
    private boolean raisedErrors = false;
    
    private String nullPointerErr;
    
    public boolean isRaisedErrors() {
        return raisedErrors;
    }

    public void setRaisedErrors(boolean raisedErrors) {
        this.raisedErrors = raisedErrors;
    }
    
    

    public String getNullPointerErr() {
        return nullPointerErr;
    }

    public void setNullPointerErr(String nullPointer) {
        this.nullPointerErr = nullPointer;
        this.setRaisedErrors(true);
    }

    
}
