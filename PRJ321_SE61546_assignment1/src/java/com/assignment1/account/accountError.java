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
public class accountError {
    private boolean raisedErrors;
    
    private String invalidUsernamePassword;
    private String nullUsername;
    private String nullPassword;
    private String nullPointer;

    public boolean isRaisedErrors() {
        return raisedErrors;
    }

    public void setRaisedErrors(boolean raisedErrors) {
        this.raisedErrors = raisedErrors;
    }
    
    

    public String getInvalidUsernamePassword() {
        return invalidUsernamePassword;
    }

    public void setInvalidUsernamePassword(String invalidUsernamePassword) {
        this.invalidUsernamePassword = invalidUsernamePassword;
        this.setRaisedErrors(true);
    }

    public String getNullUsername() {
        return nullUsername;
    }

    public void setNullUsername(String nullUsername) {
        this.nullUsername = nullUsername;
        this.setRaisedErrors(true);
    }

    public String getNullPassword() {
        return nullPassword;
    }

    public void setNullPassword(String nullPassword) {
        this.nullPassword = nullPassword;
        this.setRaisedErrors(true);
    }

    public String getNullPointer() {
        return nullPointer;
    }

    public void setNullPointer(String nullPointer) {
        this.nullPointer = nullPointer;
        this.setRaisedErrors(true);
    }
    
    
    
    
}
