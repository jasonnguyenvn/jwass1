/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.account.servlets;

import com.assignment1.account.accountDAO;
import com.assignment1.account.accountDTO;
import com.assignment1.account.accountError;
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
public class LoginServlet extends HttpServlet {
    private final String loginPage = "login.jsp";

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
            accountError erroObj = new accountError();
            accountDAO dao = new accountDAO();
            String accountID = request.getParameter("accountID");
            String password = request.getParameter("password");
            
            try {
                if (accountID.equals("")) {
                    erroObj.setNullUsername("Username cannot be null.");
                }

                if (password.equals("")) {
                    erroObj.setNullPassword("Password cannot be null.");
                }
            } catch (NullPointerException ex) {
                log("Someone send bad request: " + ex.getMessage());
                erroObj.setNullPointer("BAD REQUEST");
            } 
            
            if(erroObj.isRaisedErrors()) {
                request.setAttribute("ERROROBJ", erroObj);
                RequestDispatcher dr = request.getRequestDispatcher(loginPage);
                dr.forward(request, response);
                return;
            }
            
            accountDTO dto = null;
            try {
                dto = dao.checkLogin(accountID, password);
                
            } catch (ClassNotFoundException ex) {
                log(ex.getMessage());
                response.sendError(500);
            } catch (SQLException ex) {
                log(ex.getMessage());
            }
            
            
            if (dto!=null) {
                HttpSession session = request.getSession();
                session.setAttribute("LOGGINUSR", dto);
                
                String urlRewriting = "Controller?btAction=searchPage";
                response.sendRedirect(urlRewriting);
                return;
            }
            
            
            erroObj.setInvalidUsernamePassword("INVALID USERNAME OR PASSWORD.");
            
            request.setAttribute("ERROROBJ", erroObj);
            RequestDispatcher dr = request.getRequestDispatcher(loginPage);
            dr.forward(request, response);
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
