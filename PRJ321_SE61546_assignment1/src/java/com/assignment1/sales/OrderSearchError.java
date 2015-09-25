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
public class OrderSearchError implements Serializable {
    boolean raisedErrors = false;

    public boolean isRaisedErrors() {
        return raisedErrors;
    }

    public void setRaisedErrors(boolean raisedErrors) {
        this.raisedErrors = raisedErrors;
    }
    
    String invalidFromDateFormatErr;
    String invalidToDateFormatErr;

    public String getInvalidFromDateFormatErr() {
        return invalidFromDateFormatErr;
    }

    public void setInvalidFromDateFormatErr(String invalidDateFormatErr) {
        this.invalidFromDateFormatErr = invalidDateFormatErr;
        this.setRaisedErrors(true);
    }

    public String getInvalidToDateFormatErr() {
        return invalidToDateFormatErr;
    }

    public void setInvalidToDateFormatErr(String invalidToDateFormatErr) {
        this.invalidToDateFormatErr = invalidToDateFormatErr;
        this.setRaisedErrors(true);
    }
    
    
    
    
}
