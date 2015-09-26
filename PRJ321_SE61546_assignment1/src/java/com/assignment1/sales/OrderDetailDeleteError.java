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
public class OrderDetailDeleteError extends DBErrorBaseClass {
    
    private String couldNotDeleteOrderDetail;
    private String onlyOneDetailForOrder;

    public String getCouldNotDeleteOrderDetail() {
        return couldNotDeleteOrderDetail;
    }

    public void setCouldNotDeleteOrderDetail(String couldNotDeleteOrderDetail) {
        this.couldNotDeleteOrderDetail = couldNotDeleteOrderDetail;
        this.setRaisedErrors(true);
    }

    public String getOnlyOneDetailForOrder() {
        return onlyOneDetailForOrder;
    }

    public void setOnlyOneDetailForOrder(String onlyOneDetailForOrder) {
        this.onlyOneDetailForOrder = onlyOneDetailForOrder;
        this.setRaisedErrors(true);
    }
    
    
    
    
}
