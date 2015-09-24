/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.account;

import com.assignment1.DBUtils.MSSQLUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hau
 */
public class accountDAO implements Serializable {
    
    public accountDTO checkLogin(String accountID, String password) 
            throws ClassNotFoundException, SQLException {
        accountDTO result = null;
        Connection con = MSSQLUtil.openConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM tbl_account WHERE accountID=? "
                + "AND password=? ";
        
        try {
            stm = con.prepareCall(sql);
            stm.setString(1, accountID);
            stm.setString(2, password);
            
            rs = stm.executeQuery();
            
            if(rs.next()) {
                String customerName = rs.getString("customerName");
                String email = rs.getString("email");
                
                accountDTO acc = new accountDTO(accountID, customerName, 
                        password, email);
                return acc;                
            }
            
        } finally {
            if (rs!=null) {
                rs.close();
            }
            if (stm!=null) {
                stm.close();
            }
            
            con.close();
        }
        
        return result;
    }
}
