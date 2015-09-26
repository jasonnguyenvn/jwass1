/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.sales.servlets;

import com.assignment1.DBUtils.CouldNotOpenDatabaseConnection;
import com.assignment1.account.AccountDTO;
import com.assignment1.sales.OrderDAO;
import com.assignment1.sales.OrderDTO;
import java.io.IOException;
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
public class ViewOrderDetailServlet extends HttpServlet {
    private final String viewOrderDetailsPage = "/views/OrderDetails.jsp";

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
        
        HttpSession session ;
        AccountDTO loginUser;
        try {
            session = request.getSession(false);
            loginUser = (AccountDTO) session.getAttribute("LOGGINUSR");
            
            String orderID = request.getParameter("orderID");
            
            if(orderID == null) {
                response.sendError(404);
                return;
            }
            
            OrderDAO dao = new OrderDAO();
            
            try {
                OrderDTO dto = dao.getOrderByID(orderID, loginUser);
                
                request.setAttribute("DTO", dto);
                RequestDispatcher rd = request
                                    .getRequestDispatcher(viewOrderDetailsPage);
                rd.forward(request, response);
                
            } catch (CouldNotOpenDatabaseConnection | ClassNotFoundException ex) {
                log(ex.getMessage());
                response.sendError(500);
            } catch (SQLException ex) {
                log(ex.getMessage());
                response.sendError(500);
            }
            
        } catch (NullPointerException ex) {
            log("Session time out or occurs error! " + ex.getMessage());
            response.sendRedirect("Controller");
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
