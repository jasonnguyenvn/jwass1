<%-- 
    Document   : search
    Created on : Sep 22, 2015, 12:30:29 PM
    Author     : Hau
--%>

<%@page import="com.assignment1.sales.OrderDetailDeleteError"%>
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
            String txtFromDate = request.getParameter("txtFromDate");
            String txtToDate = request.getParameter("txtToDate");
        %>
        
        
        <form action="Controller" method="GET">
            <table>
                <tr>
                    <td width="80px">From Date:</td>
                    <td width="200px">
                        <input style="width:200px;" type="text" 
                               name="txtFromDate" value="<%
                               if(txtFromDate!=null) {
                                   out.print(txtFromDate);
                               }
                               %>" />
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
                               name="txtToDate" value="<% 
                               if(txtToDate!=null) {
                                   out.print(txtToDate);
                               }
                               %>" />
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
            if (errorObj != null) {
                if (errorObj.getToDateEalierThanFromDateErr() != null) {
                    %>
                    <h3>
                    <font color="red">
                        Warning: <%= errorObj.getToDateEalierThanFromDateErr() %>
                    </font>
                    </h3>
                    <%
                    out.print("</body></html>");
                    return;
                }
            }

        %>
        
        <%@include file="OrderList.jsp" %>
    </body>
</html>
