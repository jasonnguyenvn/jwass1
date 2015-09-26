/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.account;

import com.assignment1.common.DBErrorBaseClass;

/**
 *
 * @author Hau
 */
public class AccountLoginError extends DBErrorBaseClass {
    
    private String invalidUsernamePasswordErr;
    private String nullUsernameErr;
    private String nullPasswordErr;
    private String permissionDeniedErr;
    

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

    public String getPermissionDeniedErr() {
        return permissionDeniedErr;
    }

    public void setPermissionDeniedErr(String permissionDeniedErr) {
        this.permissionDeniedErr = permissionDeniedErr;
        this.setRaisedErrors(true);
    }
    
    
    
    
}
