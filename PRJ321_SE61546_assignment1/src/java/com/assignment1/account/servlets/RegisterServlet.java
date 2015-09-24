/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.account.servlets;

import com.assignment1.account.AccountDAO;
import com.assignment1.account.AccountInsertError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hau
 */
public class RegisterServlet extends HttpServlet {
    private final String signUpPage = "signUp.jsp";
    private final String loginPage = "login.html";
    
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
            AccountInsertError errorObj = new AccountInsertError();
            
            String accountID = "";
            String customerName = "";
            String password = "";
            String txtConfirm = "";
            String email = "";
            
            try {
                accountID = request.getParameter("accountID").trim();
                customerName = request.getParameter("customerName").trim();
                password = request.getParameter("password").trim();
                txtConfirm = request.getParameter("txtConfirm").trim();
                email = request.getParameter("email").trim();
                
            } catch (NullPointerException ex) {
                log("Someone send bad request: " + ex.getMessage());
                errorObj.setNullPointerErr("BAD REQUEST");
            } 
            
            
            if(accountID.length()<3 || accountID.length()>10) {
                errorObj.setUsernameLengthErr("Username must has 3 - 10 characters");
                
            }
            
            if(customerName.length()<3 || customerName.length()>50) {
                errorObj.setCustomerNameLengthErr("Full name must has 3 - 50 characters");
                
            }
            
            if(password.length()<6 || password.length()>20) {
                errorObj.setPasswordLengthErr("Password must has 6 - 20 characters");
                
            } else if (txtConfirm.equals(password) == false) {
                errorObj.setConfimNotMatchedErr("Confirm and password are not matched");
            }
            
            
            if(email.length()>50) {
                errorObj.setEmailLengthErr("Email cannot has more 50 characters.");
            }
            
            try {
                AccountDAO dao = new AccountDAO();
                boolean result = dao.createAccount(accountID, customerName,
                                                            password, email);
            } catch (ClassNotFoundException ex) {
                log(ex.getMessage());
                response.sendError(500);
            } catch (SQLException ex) {
                log(ex.getMessage());
                errorObj.setUsernameEmailExisted("Username or Email existed");
            }
            
            
            String url = loginPage;
            if(errorObj.isRaisedErrors()) {
                url = signUpPage;
            }

            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
