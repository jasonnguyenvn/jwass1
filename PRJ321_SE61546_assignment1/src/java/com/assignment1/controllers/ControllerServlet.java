/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.controllers;

import com.assignment1.DBUtils.CouldNotOpenDatabaseConnection;
import com.assignment1.common.CheckLoginObj;
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
public class ControllerServlet extends HttpServlet {
    private final String nullServlet = "Actions/NullServlet";
    private final String loginServlet = "Actions/LoginServlet";
    private final String searchPage = "views/search.jsp";
    private final String signUpPage = "views/signUp.html";
    private final String loginPage = "views/login.html";
    private final String registerServlet = "Actions/RegisterServlet";
    private final String searchOrderServlet = "Actions/SearchOrderServlet";
    private final String viewOrderDetailServlet = "Actions/ViewOrderDetailServlet";
    private final String deleteOrderDetailItemServlet = "Actions/DeleteOrderDetailItemServlet";
    private final String updateOrderQuantityServlet = "Actions/UpdateOrderQuantityServlet";
    
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
        PrintWriter out = response.getWriter();
        try {
            
            String button = request.getParameter("btAction");
            
            if (button==null) {
                RequestDispatcher rd = request.getRequestDispatcher(nullServlet);
                rd.forward(request, response);
                return;
            }
            
            CheckLoginObj checkLogin = new CheckLoginObj();
            boolean isLogin = false;
            try {
                isLogin = checkLogin.checkLogin(request);
            } catch (CouldNotOpenDatabaseConnection | ClassNotFoundException | SQLException ex) {
                log(ex.getMessage());
                response.sendError(500);
            }
            
            String url;
            if(button.equals("Login")) {
                url = loginServlet;
            } else if(button.equals("LoginPage")) {
                if(isLogin) {
                    response.sendRedirect("Controller");
                    return;
                }

                url = loginPage;
            } else if(button.equals("searchPage")) {
                if(isLogin==false) {
                    response.sendRedirect("Controller");
                    return;
                }
                
                url = searchPage;
            } else if(button.equals("signUp")) {
                if(isLogin) {
                    response.sendRedirect("Controller");
                    return;
                }
                url = signUpPage;
            } else if(button.equals("Sign Up!")) {
                if(isLogin==false) {
                    response.sendRedirect("Controller");
                    return;
                }
                
                
                url = registerServlet;
            }  else if(button.equals("Search")) {
                
                if(isLogin==false) {
                    response.sendRedirect("Controller");
                    return;
                }
                
                url = searchOrderServlet;
            } else if(button.equals("view_detail")) {
                if(isLogin==false) {
                    response.sendRedirect("Controller");
                    return;
                }
                
                url = viewOrderDetailServlet;
            } else if(button.equals("del_detail")) {
                
                if(isLogin==false) {
                    response.sendRedirect("Controller");
                    return;
                }
                
                
                url = deleteOrderDetailItemServlet;
            }  else if(button.equals("Update")) {
                
                if(isLogin==false) {
                    response.sendRedirect("Controller");
                    return;
                }
                
                
                url = updateOrderQuantityServlet;
            } else {
                response.sendError(404);
                return;
            }
            
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            
        } finally {
            out.close();
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
