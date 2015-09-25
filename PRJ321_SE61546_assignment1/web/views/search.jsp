<%-- 
    Document   : search
    Created on : Sep 22, 2015, 12:30:29 PM
    Author     : Hau
--%>

<%@page import="com.assignment1.sales.OrderDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.assignment1.sales.OrderSearchError"%>
<%@page import="com.assignment1.account.AccountDTO"%>
<%@page import="com.assignment1.account.AccountLoginError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Order</title>
    </head>
    <body>
        <%@include file="welcome.jsp" %>
        
        <h1>Search Order</h1>
        
        <%
            OrderSearchError errorObj = (OrderSearchError) request.getAttribute("SEARCHERROBJ");
        %>
        
        
        <form action="Controller" method="POST">
            <table>
                <tr>
                    <td width="80px">From Date:</td>
                    <td width="200px">
                        <input style="width:200px;" type="text" 
                               name="txtFromDate" value="" />
                        <%
                        if(errorObj!=null) {
                            if(errorObj.getInvalidFromDateFormatErr()!=null) {
                                %>
                                <font color="red">
                                <%= errorObj.getInvalidFromDateFormatErr() %>
                                </font>
                                <%
                            }
                        }
                        %>
                    </td>
                </tr>
                <tr>
                    <td width="80px">To Date:</td>
                    <td width="200px">
                        <input style="width:200px;" type="text" 
                               name="txtToDate" value="" />
                        <%
                        if(errorObj!=null) {
                            if(errorObj.getInvalidToDateFormatErr()!=null) {
                                %>
                                <font color="red">
                                <%= errorObj.getInvalidToDateFormatErr() %>
                                </font>
                                <%
                            }
                        }
                        %>
                    </td>
                </tr>
                <tr>
                    <td width="80px" ></td>
                    <td>
                        <input type="submit" style="width:49%;"
                               value="Search" name="btAction" />
                        <input type="reset" style="width:49%;" value="Reset" />
                    </td>
                </tr>
            </table>
        </form>
        
        <%
        List<OrderDTO> orderList = (List<OrderDTO>) request.getAttribute("ORDERLIST");
        String listPage = "OrderList.jsp";
        
        if(orderList!=null) {
            RequestDispatcher dr = request.getRequestDispatcher(listPage);
            dr.forward(request, response);
        }
        
        %>
    </body>
</html>
