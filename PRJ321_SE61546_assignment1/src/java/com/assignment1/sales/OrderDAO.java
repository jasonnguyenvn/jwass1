/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.sales;

import com.assignment1.DBUtils.MSSQLUtil;
import com.assignment1.account.AccountDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Hau
 */
public class OrderDAO implements Serializable {
    
//    public class CustomerNotFoundException extends Exception {
//        public CustomerNotFoundException() {
//            super("COULD NOT FIND CUSTOMER IN THE DATABASE FOR THIS ORDER");
//        }
//        
//        public CustomerNotFoundException(String reason) {
//            super(reason);
//        }
//        
//    }
    
    
    protected boolean deleteOrderDetails(String orderID, Connection con) 
            throws SQLException {
        boolean result;
        
        OrderDetailDAO dao = new OrderDetailDAO();
        
        result = dao.deleteOrderDetailsByOrderId(orderID, con);
        
        return result;
    }
    
    public final int DELETE_SUCCESSFULLY_NO_DETAILS_DELLETED = 1;
    public final int DELETE_SUCCESSFULLY_DETAILS_DELLETED = 2;
    public final int DELETE_UNSUCCESSFULLY_ROLLBACK = 0;
    
    public int deleteOrderByOrderId(String orderID) 
            throws ClassNotFoundException, SQLException {
        int result = DELETE_UNSUCCESSFULLY_ROLLBACK;
        
        Connection con = MSSQLUtil.openConnection();
        PreparedStatement stm = null;
        
        String sql = "DELETE FROM tbl_order WHERE orderID=? ";
        
        boolean delDetailsResult = this.deleteOrderDetails(orderID, con);

        try {
            stm = con.prepareCall(sql);
            stm.setString(1, orderID);

            int rs = stm.executeUpdate();

            if(rs > 0) {
                if(delDetailsResult == true) {
                    result = DELETE_SUCCESSFULLY_DETAILS_DELLETED;
                } else {
                    result = DELETE_SUCCESSFULLY_NO_DETAILS_DELLETED;
                }
                
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException ex) {
            con.rollback();
            con.close();
            throw new SQLException("DATABASE ERROR - ROLLBACK !!! " + ex);
        } finally {
            if (stm!=null) {
                stm.close();
            }
            con.setAutoCommit(true);
            con.close();
            
        }
        
        
        return result;
    }
    
    public List<OrderDTO> searchOrdersByDateNotLoadItems(Date fromDate, 
            Date toDate, AccountDTO loginAcc) 
            throws ClassNotFoundException, SQLException, NullPointerException {
        
        List<OrderDTO> result = new ArrayList<>();
        
        Connection con = MSSQLUtil.openConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM tbl_order WHERE customerID=? AND"
                    + " orderDate >= ? AND orderDate <= ? ";
        
        try {
            stm = con.prepareCall(sql);
            stm.setString(1, loginAcc.getAccountID());
            stm.setDate(2,  fromDate);
            stm.setDate(3,  toDate);
            
            rs = stm.executeQuery();
            
            while(rs.next()) {
                String orderID = rs.getString("orderID");
                Date orderDate = rs.getDate("orderDate");
                float total = rs.getFloat("total");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                
                OrderDTO dto = new OrderDTO(orderID, orderDate, loginAcc, 
                                    total, address, phone);
                
                // this.getDetails(orderID, dto.getItems());
                
                result.add(dto);
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
    
    
    public OrderDTO getOrderByID(String orderID, AccountDTO loginAcc) 
            throws ClassNotFoundException, SQLException {
        
        OrderDTO result =null;
        
        Connection con = MSSQLUtil.openConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM tbl_order WHERE customerID=? AND"
                    + " orderID=? ";
        
        try {
            stm = con.prepareCall(sql);
            stm.setString(1, loginAcc.getAccountID());
            stm.setString(2, orderID);
            
            rs = stm.executeQuery();
            
            while(rs.next()) {
                Date orderDate = rs.getDate("orderDate");
                float total = rs.getFloat("total");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                
                OrderDTO dto = new OrderDTO(orderID, orderDate, loginAcc, 
                                    total, address, phone);
                this.getDetails(orderID, dto.getItems());
                
                result = dto;
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
    
//    protected AccountDTO getCustomer(String customerID) 
//            throws ClassNotFoundException, SQLException {
//        AccountDTO result;
//        
//        AccountDAO dao = new AccountDAO();
//        
//        result = dao.getAccountById(customerID);
//        
//        return result;
//    }
    
    protected List<OrderDetailDTO> getDetails(String orderID,
            List<OrderDetailDTO> itemList) 
            throws ClassNotFoundException, SQLException,  NullPointerException {
        List<OrderDetailDTO> result;
        
        OrderDetailDAO dao = new OrderDetailDAO();
        
        result = dao.getOrderDetailsByOrderId(orderID, itemList);
        
        return result;
    }
    
}
