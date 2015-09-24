<%-- 
    Document   : welcome
    Created on : Sep 25, 2015, 12:42:49 AM
    Author     : Hau
--%>

<%@page import="com.assignment1.account.AccountDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    AccountDTO loginUser = (AccountDTO) session.getAttribute("LOGGINUSR");

    if(loginUser!=null) {
        %>
        <font color="red">
        Welcome, <%= loginUser.getAccountID() %>
        </font>
        <%
    }
%>
