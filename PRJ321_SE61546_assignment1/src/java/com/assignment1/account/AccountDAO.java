/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.account;

import com.assignment1.DBUtils.CouldNotOpenDatabaseConnection;
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
public class AccountDAO implements Serializable {
    
    public boolean createAccount(String accountID, String customerName,
            String password, String email) 
            throws ClassNotFoundException, SQLException, CouldNotOpenDatabaseConnection {
        boolean result = false;
        Connection con = MSSQLUtil.openConnection();
        PreparedStatement stm = null;
        
        String sql = "INSERT INTO tbl_account(accountID, customerName, password,"
                        + " email) VALUES(?, ?, ?, ?) ";
        
        try {
            stm = con.prepareCall(sql);
            stm.setString(1, accountID);
            stm.setString(2, customerName);
            stm.setString(3, password);
            stm.setString(4, email);
            
            int rs = stm.executeUpdate();
            if (rs > 0) {
                result = true;
            }
            
        } finally {
            if (stm!=null) {
                stm.close();
            }
            
            con.close();
        }
        
        return result;
    }
    
    public AccountDTO checkLogin(String accountID, String password) 
            throws ClassNotFoundException, SQLException, CouldNotOpenDatabaseConnection {
        AccountDTO result = null;
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
                
                AccountDTO acc = new AccountDTO(accountID, customerName, 
                        password, email);
                result = acc;             
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
    
    public AccountDTO getAccountById(String accountID) 
            throws ClassNotFoundException, SQLException, CouldNotOpenDatabaseConnection {
        AccountDTO result = null;
        Connection con = MSSQLUtil.openConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM tbl_account WHERE accountID=? ";
        
        try {
            stm = con.prepareCall(sql);
            stm.setString(1, accountID);
            
            rs = stm.executeQuery();
            
            if(rs.next()) {
                String customerName = rs.getString("customerName");
                String email = rs.getString("email");
                String password = rs.getString("password");
                
                AccountDTO acc = new AccountDTO(accountID, customerName, 
                        password, email);
                result = acc;             
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
