/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.sales;

import com.assignment1.DBUtils.CouldNotOpenDatabaseConnection;
import com.assignment1.DBUtils.MSSQLUtil;
import com.assignment1.account.AccountDTO;
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
    
//    public class OnlyOneDetailForOrderException extends Exception {
//
//        public OnlyOneDetailForOrderException() {
//            super("COULD NOT DELETE THIS DETAIL BECAUSE "
//                    + "THERE IS NO MORE ORDER DETAIL FOR THIS ORDER!");
//        }
//
//        public OnlyOneDetailForOrderException(String message) {
//            super(message);
//        }
//        
//    }
    
    
//    public boolean deleteOrderDetailsByOrderId(String orderID, Connection con) 
//            throws   SQLException {
//        boolean result = false;
//        
//        PreparedStatement stm = null;
//        
//        String sql = "DELETE FROM tbl_orderDetail WHERE orderID=? ";
//        
//        
//        stm = con.prepareCall(sql);
//        stm.setString(1, orderID);
//
//        int rs = stm.executeUpdate();
//
//        if(rs > 0) {
//            result = true;
//        }
//        
//        
//        return result;
//    }
    
    protected boolean updateOrderTotalDelete(float detailTotal, String orderID, 
            AccountDTO loginAcc, Connection con) throws SQLException {
        OrderDAO dao = new OrderDAO();
        
        return dao.updateOrderTotalDeleteDetail(detailTotal, orderID, loginAcc, con);
    }
    
    public boolean deleteOrderDetails(int id, String orderID, 
            AccountDTO loginAcc) 
            throws SQLException, ClassNotFoundException, CouldNotOpenDatabaseConnection /*, OnlyOneDetailForOrderException  */ {
        boolean result = false;
        
        Connection con = MSSQLUtil.openConnection();
        con.setAutoCommit(false);
        
//        PreparedStatement stm1 = null;
        PreparedStatement stm2 = null;
        PreparedStatement stm3 = null;
        
//        String sql1 = "SELECT * FROM tbl_orderDetail WHERE orderID=? AND id<>? ";
        String sql2 = "SELECT total FROM tbl_orderDetail WHERE id=? ";
        String sql3 = "DELETE FROM tbl_orderDetail WHERE id=? AND orderID=? ";
        
        try {
//            stm1 = con.prepareCall(sql1);
//            stm1.setString(1, orderID);
//            stm1.setInt(2, id);
//            
//            
//            ResultSet rs1 = stm1.executeQuery();
//            if(rs1.next()==false) {
//                con.rollback();
//                rs1.close();
//                stm1.close();
//                con.close();
//                throw new OnlyOneDetailForOrderException();
//            }
//            
//            rs1.close(); 
            
            
            stm2 = con.prepareCall(sql2);
            stm2.setInt(1, id);
            ResultSet rs2 = stm2.executeQuery();
            if (rs2.next() == false) {
                con.rollback();
                rs2.close();
//                stm1.close();
                stm2.close();
                con.close();
                return false;
            }
            
            float detailTotal = rs2.getFloat("total");
            rs2.close();
            
            boolean updateTotalRs = this.updateOrderTotalDelete(detailTotal, orderID,
                                    loginAcc, con);
            
            if (updateTotalRs == false) {
                con.rollback();
                rs2.close();
//                stm1.close();
                stm2.close();
                con.close();
                return false;
            }
            
            
            stm3 = con.prepareCall(sql3);
            stm3.setInt(1, id);
            stm3.setString(2, orderID);

            int rs = stm3.executeUpdate();

            if(rs > 0) {
                result = true;
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException ex) {
            con.rollback();
//            if (stm1!=null) {
//                stm1.close();
//            }
            if (stm2!=null) {
                stm2.close();
            }
            if (stm3!=null) {
                stm3.close();
            }
            con.close();
            throw new SQLException("COULD NOT DELETE DETAIL - ROLLBACK !!! " + ex);
        }  finally {
//            if (stm1!=null) {
//                stm1.close();
//            }
            if (stm2!=null) {
                stm2.close();
            }
            if (stm3!=null) {
                stm3.close();
            }
            
            con.close();
        }
        
        
        return result;
    }
    
    protected boolean updateOrderTotalQuanlity(float preDetailTotal, 
            float detailTotal, String orderID, 
            AccountDTO loginAcc, Connection con) 
            throws SQLException {
        OrderDAO dao = new OrderDAO();
        
        return dao.updateOrderTotalUpdateDetailQuanlity(preDetailTotal,
                detailTotal, orderID, loginAcc, con);
    }
    
    
    public boolean updateOrderDetailQuantity(int id, 
            String orderID, int quantity, AccountDTO loginAcc) 
            throws SQLException, ClassNotFoundException, CouldNotOpenDatabaseConnection {
        boolean result = false;
        
        Connection con = MSSQLUtil.openConnection();
        con.setAutoCommit(false);
        
        PreparedStatement stm1 = null;
        PreparedStatement stm2 = null;
        
        String sql1 = "SELECT total, unitPrice FROM tbl_orderDetail WHERE id=? ";
        String sql2 = "UPDATE tbl_orderDetail SET quantity=?, total=?"
                + " WHERE id=? AND orderID=? ";
        
        try {
            
            stm1 = con.prepareCall(sql1);
            stm1.setInt(1, id);
            ResultSet rs2 = stm1.executeQuery();
            if (rs2.next() == false) {
                con.rollback();
                rs2.close();
                stm1.close();
                con.close();
                return false;
            }
            
            float preTotal = rs2.getFloat("total");
            float unitPrice = rs2.getFloat("unitPrice");
            float finalTotal = unitPrice * quantity;
            rs2.close();
            
            boolean updateTotalRs = this
                    .updateOrderTotalQuanlity(preTotal, finalTotal, 
                            orderID, loginAcc, con);
            
            if (updateTotalRs == false) {
                con.rollback();
                rs2.close();
                stm1.close();
                con.close();
                return false;
            }
            
            
            stm2 = con.prepareCall(sql2);
            stm2.setInt(1, quantity);
            stm2.setFloat(2, finalTotal);
            stm2.setInt(3, id);
            stm2.setString(4, orderID);

            int rs = stm2.executeUpdate();

            if(rs > 0) {
                result = true;
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException ex) {
            con.rollback();
            if (stm1!=null) {
                stm1.close();
            }
            if (stm2!=null) {
                stm2.close();
            }
            con.close();
            throw new SQLException("COULD NOT DELETE DETAIL - ROLLBACK !!! " + ex);
        }  finally {
            if (stm1!=null) {
                stm1.close();
            }
            if (stm2!=null) {
                stm2.close();
            }
            
            con.close();
        }
        
        
        return result;
    }
    
    
    public List<OrderDetailDTO> getOrderDetailsByOrderId(String orderID, 
            List<OrderDetailDTO> itemList) 
            throws ClassNotFoundException, SQLException, NullPointerException,
            CouldNotOpenDatabaseConnection {
        
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
            throws ClassNotFoundException, SQLException, 
            CouldNotOpenDatabaseConnection {
        ProductDTO result;
        
        ProductDAO dao = new ProductDAO();
        
        result = dao.getProductById(productID);
        
        return result;        
    }
    
    
}
