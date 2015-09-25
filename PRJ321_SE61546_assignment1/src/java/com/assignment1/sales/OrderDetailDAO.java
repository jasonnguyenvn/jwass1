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
import java.util.List;

/**
 *
 * @author Hau
 */
public class OrderDetailDAO implements Serializable {
    
    
    public boolean deleteOrderDetailsByOrderId(String orderID, Connection con) 
            throws   SQLException {
        boolean result = false;
        
        PreparedStatement stm = null;
        
        String sql = "DELETE FROM tbl_orderDetail WHERE orderID=? ";
        
        try {
            stm = con.prepareCall(sql);
            stm.setString(1, orderID);
            
            int rs = stm.executeUpdate();
            
            if(rs > 0) {
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
    
    
    public List<OrderDetailDTO> getOrderDetailsByOrderId(String orderID, 
            List<OrderDetailDTO> itemList) 
            throws ClassNotFoundException, SQLException, NullPointerException {
        
        Connection con = MSSQLUtil.openConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM tbl_orderDetail WHERE orderID=? ";
        
        try {
            stm = con.prepareCall(sql);
            stm.setString(1, orderID);
            
            rs = stm.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                float unitPrice = rs.getFloat("unitPrice");
                String unitItem = rs.getString("unitItem");
                float total = rs.getFloat("total");
                
                String productID = rs.getString("productID");
                
                ProductDTO product = this.getProduct(productID);
                
                OrderDetailDTO dto = new OrderDetailDTO(id, product, quantity,
                                unitPrice, unitItem, total, orderID);
                itemList.add(dto);
                
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
        
        return itemList;
    }
    
    protected ProductDTO getProduct(String productID) 
            throws ClassNotFoundException, SQLException {
        ProductDTO result;
        
        ProductDAO dao = new ProductDAO();
        
        result = dao.getProductById(productID);
        
        return result;        
    }
    
    
}
