<%-- 
    Document   : OrderDetails
    Created on : Sep 22, 2015, 1:07:50 PM
    Author     : Hau
--%>

<%@page import="com.assignment1.sales.OrderDetailDTO"%>
<%@page import="com.assignment1.sales.OrderDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Details</title>
    </head>
    <body>
        <%
            OrderDTO dto = (OrderDTO) request.getAttribute("DTO");
            if (dto == null) {
                response.sendError(404);
                return;
            }
        %>
        
        <h1>Order Details</h1>
        
        <table  >
            <tr>
                <td>Order ID</td>
                <td>
                    <%= dto.getOrderID() %>
                </td>
                
                <td>Date</td>
                <td>
                    <%= dto.getOrderDate().toString() %>
                </td>
            </tr>
            <tr>
                <td>Customer</td>
                <td>
                    <%= dto.getCustomer().getCustomerName() %>
                </td>
                
                <td>Phone</td>
                <td>
                    <%= dto.getPhone() %>
                </td>
            </tr>
            <tr>
                <td>Address</td>
                <td colspan="3">
                    <%= dto.getAddress() %>
                </td>
            </tr>
        </table>

        
        
        <h4>Detail</h4>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Product</th>
                    <th>Unit</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for(OrderDetailDTO item : dto.getItems()) {
                        %>
                        <tr>
                            <td>
                                <%= count++ %>
                            .</td>
                            <td>
                                <%= item.getProduct().getProductName() %>
                            </td>
                            <td>
                                <%= item.getUnitItem() %>
                            </td>
                            <td>
                                <%= item.getQuantity() %>
                            </td>
                            <td>
                                <%= item.getUnitPrice() %>
                            </td>
                            <td>
                                <%= item.getTotal() %>
                            </td>
                            <td></td>
                            <td></td>
                        </tr>
                        <%
                    }
                
                %>
                
                
            </tbody>
        </table>

        <%
            String fromDate = request.getParameter("txtFromDate");
            String toDate = request.getParameter("txtToDate");
            String urlRewriting = "Controller?btAction=Search"
                    + "&txtFromDate=" + fromDate
                    + "&txtToDate=" + toDate;
        %>
        
        <h4>Total: <%= dto.getTotal() %></h4>
        
        <h3><a href="<%= urlRewriting %>">Click here to return search page</a></h3>

        <!--
            REMEMBER TO ADD LINK HERE
        -->
    </body>
</html>
