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
public class AccountInsertError extends AccountErrorBaseClass {
    private String usernameLengthErr;
    private String customerNameLengthErr;
    private String passwordLengthErr;
    private String confimNotMatchedErr;
    private String emailLengthErr;
    private String invalidEmailErr;
    
    private String usernameEmailExistedErr;
    
    
    public String getUsernameEmailExistedErr() {
        return usernameEmailExistedErr;
    }

    public void setUsernameEmailExisted(String usernameEmailExisted) {
        this.usernameEmailExistedErr = usernameEmailExisted;
        this.setRaisedErrors(true);
    }

    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
        this.setRaisedErrors(true);
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
        this.setRaisedErrors(true);
    }

    public String getConfimNotMatchedErr() {
        return confimNotMatchedErr;
    }

    public void setConfimNotMatchedErr(String confimNotMatchedErr) {
        this.confimNotMatchedErr = confimNotMatchedErr;
        this.setRaisedErrors(true);
    }

    public String getEmailLengthErr() {
        return emailLengthErr;
    }

    public void setEmailLengthErr(String emailLengthErr) {
        this.emailLengthErr = emailLengthErr;
        this.setRaisedErrors(true);
    }

    public String getInvalidEmailErr() {
        return invalidEmailErr;
    }

    public void setInvalidEmailErr(String invalidEmailErr) {
        this.invalidEmailErr = invalidEmailErr;
        this.setRaisedErrors(true);
    }

    public String getCustomerNameLengthErr() {
        return customerNameLengthErr;
    }

    public void setCustomerNameLengthErr(String customerNameLengthErr) {
        this.customerNameLengthErr = customerNameLengthErr;
        this.setRaisedErrors(true);
    }
    
    
    
}
