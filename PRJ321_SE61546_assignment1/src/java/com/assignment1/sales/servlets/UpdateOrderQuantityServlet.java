/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.sales.servlets;

import com.assignment1.account.AccountDTO;
import com.assignment1.sales.OrderDAO;
import com.assignment1.sales.OrderDTO;
import com.assignment1.sales.OrderDetailDAO;
import com.assignment1.sales.OrderDetailUpdateError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hau
 */
public class UpdateOrderQuantityServlet extends HttpServlet {
    private final String viewOrderDetailPage = "/views/OrderDetails.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String pk  = request.getParameter("pk");
            String txtQuantity = request.getParameter("txtQuantity");
            String orderID = request.getParameter("orderID");
            String fromDate = request.getParameter("txtFromDate");
            String toDate = request.getParameter("txtToDate");
            if(pk==null) 
                response.sendError(400);
            if(txtQuantity==null)
                response.sendError(400);
            if(orderID==null)
                response.sendError(400);
            if(fromDate==null)
                response.sendError(400);
            if(toDate==null)
                response.sendError(400);
                
            
            OrderDetailUpdateError erroObj = new OrderDetailUpdateError();
            
            
            int id = -1;
            try {
                id = Integer.parseInt(pk);
            } catch (NumberFormatException ex) {
                log(ex.getMessage());
                response.sendError(400);
            }
            
            int quantity = -1;
            try {
                quantity = Integer.parseInt(txtQuantity);
            } catch (NumberFormatException ex) {
                log(ex.getMessage());
                erroObj.setInvalidQuantityValueErr("INVALID QUANTITY VALUE!");
            }
            
            if(quantity < 1) {
                erroObj.setQuantityLessThanOneErr("Quantity cannot be less than 1!");
            }
            
            
            
            OrderDetailDAO dao = new OrderDetailDAO();
            try {
                HttpSession session ;
                AccountDTO loginUser = null;
                try {
                    session = request.getSession(false);
                    loginUser = (AccountDTO) session.getAttribute("LOGGINUSR");
                } catch (NullPointerException ex) {
                    log("Session time out or occurs error! " + ex.getMessage());
                    response.sendRedirect("Controller");
                }
                
                OrderDAO dao2 = new OrderDAO();
                
                if(erroObj.isRaisedErrors()) {
                    OrderDTO dto = dao2.getOrderByID(orderID, loginUser);
                    request.setAttribute("DTO", dto);
                    request.setAttribute("UPDATEORDERERROROBJ", erroObj);

                    RequestDispatcher dr = request.getRequestDispatcher(viewOrderDetailPage);
                    dr.forward(request, response);
                    return;
                }
                
                
                boolean result = dao.updateOrderDetailQuantity(id, orderID, quantity, loginUser);
                
                if (result) {
                    String urlRewring = "Controller?btAction=view_detail"
                            + "&orderID=" + orderID 
                            + "&txtFromDate=" + fromDate
                            + "&txtToDate=" + toDate;
                    response.sendRedirect(urlRewring);
                    return;
                }
                
                ServletException ex = new ServletException("UNKNOWN ERROR!");
                log(ex.getMessage(), ex);
                response.sendError(500);
            } catch (    SQLException | ClassNotFoundException ex) {
                log(ex.getMessage());
                response.sendError(500);
            }
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
