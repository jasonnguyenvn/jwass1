/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.sales.servlets;

import com.assignment1.DBUtils.CouldNotOpenDatabaseConnection;
import com.assignment1.account.AccountDTO;
import com.assignment1.sales.OrderDetailDAO;
import com.assignment1.sales.OrderDetailDeleteError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class DeleteOrderDetailItemServlet extends HttpServlet {
    private final String viewDetailPage = "/Actions/ViewOrderDetailServlet";
    
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
            
            String pkID = request.getParameter("ID");
            int id = -1;
            
            try {
                id = Integer.parseInt(pkID);
            } catch (NumberFormatException | NullPointerException ex) {
                log("User try to request bad query. " + ex.getMessage());
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            
            String orderID = request.getParameter("orderID");
            
            if (id < 0 || orderID == null) {
                 log("User try to request bad query. ");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            
            OrderDetailDeleteError errorObj = new OrderDetailDeleteError();
            OrderDetailDAO dao = new OrderDetailDAO();
             boolean result = false;
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
                
                result = dao.deleteOrderDetails(id, orderID, loginUser);
            } catch (SQLException ex) {
                log(ex.getMessage());
                errorObj.setCouldNotDeleteOrderDetail("Could not delete order "
                        + "detail. Please, ask the web master to solve this problem.");
                
            } catch (CouldNotOpenDatabaseConnection | ClassNotFoundException ex) {
                log(ex.getMessage());
                response.sendError(500);
            } 
//            catch (OrderDetailDAO.OnlyOneDetailForOrderException ex) {
//                log(ex.getMessage());
//                errorObj.setOnlyOneDetailForOrder("COULD NOT DELETE THIS DETAIL BECAUSE "
//                    + "THERE IS NO MORE ORDER DETAIL FOR THIS ORDER! Please, "
//                        + "contact to customer service for more information.");
//                request.setAttribute("DELDETAILERROROBJ", errorObj);
//                RequestDispatcher dr = request.getRequestDispatcher(viewDetailPage);
//                dr.forward(request, response);
//                return;
//            }
            
            if (result == false) {
                
                errorObj.setCouldNotDeleteOrderDetail("Could not delete order "
                        + "detail. Invalid request or Order/Order Detail not found.");
                
            }
            
            if (errorObj.isRaisedErrors()) {
                request.setAttribute("DELDETAILERROROBJ", errorObj);
                
                RequestDispatcher dr = request.getRequestDispatcher(viewDetailPage);
                dr.forward(request, response);
                return;
            }
            
            String urlRewriting = "Controller?btAction=view_detail&orderID="
                                    + orderID;
            
            String fromDate = request.getParameter("txtFromDate");
            String toDate = request.getParameter("txtToDate");
            if (fromDate != null && toDate != null) {
                urlRewriting += "&txtFromDate=" + fromDate 
                        + "&txtToDate=" + toDate;
            }
            
            response.sendRedirect(urlRewriting);
            
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
