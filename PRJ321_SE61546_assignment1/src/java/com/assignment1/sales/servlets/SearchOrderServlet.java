/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.sales.servlets;

import com.assignment1.sales.OrderDAO;
import com.assignment1.sales.OrderDTO;
import com.assignment1.sales.OrderSearchError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hau
 */
public class SearchOrderServlet extends HttpServlet {
    private final String searchPage = "/views/search.jsp";

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
            String txtFromDate = request.getParameter("txtFromDate");
            String txtToDate = request.getParameter("txtToDate");
            
            Date fromDate = null, toDate = null;
            OrderSearchError errorObj = new OrderSearchError();
            
            try {
                fromDate = Date.valueOf(txtFromDate);
            } catch (IllegalArgumentException ex) {
                log("User input invalid date format to search orders: " 
                        + ex.getMessage());
                errorObj.setInvalidFromDateFormatErr("Invalid F");
            }
            
            try {
                toDate = Date.valueOf(txtToDate);
            } catch (IllegalArgumentException ex) {
                log("User input invalid date format to search orders: " 
                        + ex.getMessage());
                errorObj.setInvalidToDateFormatErr("Invalid F");
            }
            
            if(errorObj.isRaisedErrors()) {
                request.setAttribute("SEARCHERROBJ", errorObj);
                RequestDispatcher dr = request.getRequestDispatcher(searchPage);
                dr.forward(request, response);
                return;
            }
            
            OrderDAO dao = new OrderDAO();
            List<OrderDTO> dto;
            try {
                dto = dao.searchOrdersByDate(fromDate, toDate);
                request.setAttribute("ORDERLIST", dto);
                RequestDispatcher dr = request.getRequestDispatcher(searchPage);
                dr.forward(request, response);
                
            } catch (ClassNotFoundException | SQLException ex) {
                log("SQL DB RAISED ERROR: " + ex.getMessage());
                response.sendError(500);
            }  catch (NullPointerException ex) {
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
