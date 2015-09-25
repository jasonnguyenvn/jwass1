/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.sales;

import com.assignment1.DBUtils.MSSQLUtil;
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
    
    public List<OrderDTO> searchOrdersByDate(Date fromDate, Date toDate) 
            throws ClassNotFoundException, SQLException,  NullPointerException {
        List<OrderDTO> result = new ArrayList<>();
        
        Connection con = MSSQLUtil.openConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM tbl_order WHERE orderDate >= ? "
                + " AND orderDate <= ? ";
        
        try {
            stm = con.prepareCall(sql);
            stm.setDate(1,  fromDate);
            stm.setDate(2,  toDate);
            
            rs = stm.executeQuery();
            
            while(rs.next()) {
                String orderID = rs.getString("orderID");
                Date orderDate = rs.getDate("orderDate");
                String customerID = rs.getString("customerID");
                float total = rs.getFloat("total");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                
                OrderDTO dto = new OrderDTO(orderID, orderDate, customerID, 
                                            total, address, phone);
                this.getDetails(orderID, dto.getItems());
                
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
    
    protected List<OrderDetailDTO> getDetails(String orderID,
            List<OrderDetailDTO> itemList) 
            throws ClassNotFoundException, SQLException,  NullPointerException {
        List<OrderDetailDTO> result;
        
        OrderDetailDAO dao = new OrderDetailDAO();
        
        result = dao.getOrderDetailByOrderId(orderID, itemList);
        
        return result;
    }
    
}
