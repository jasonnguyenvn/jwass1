/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.account;

/**
 *
 * @author Hau
 */
public class AccountLoginError extends AccountErrorBaseClass {
    
    private String invalidUsernamePasswordErr;
    private String nullUsernameErr;
    private String nullPasswordErr;
    
    

    public String getInvalidUsernamePasswordErr() {
        return invalidUsernamePasswordErr;
    }

    public void setInvalidUsernamePasswordErr(String invalidUsernamePassword) {
        this.invalidUsernamePasswordErr = invalidUsernamePassword;
        this.setRaisedErrors(true);
    }

    public String getNullUsernameErr() {
        return nullUsernameErr;
    }

    public void setNullUsernameErr(String nullUsername) {
        this.nullUsernameErr = nullUsername;
        this.setRaisedErrors(true);
    }

    public String getNullPasswordErr() {
        return nullPasswordErr;
    }

    public void setNullPasswordErr(String nullPassword) {
        this.nullPasswordErr = nullPassword;
        this.setRaisedErrors(true);
    }
    
    
}
