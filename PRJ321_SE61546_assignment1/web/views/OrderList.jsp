
<%@page import="com.assignment1.sales.OrderDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
List<OrderDTO> orderList = (List<OrderDTO>) request.getAttribute("ORDERLIST");
String fromDate = request.getParameter("txtFromDate");
String toDate = request.getParameter("txtToDate");

if(fromDate==null || toDate==null) {
    return;
}

if(orderList!=null) {  
    %>
    <h1>Order List</h1>

    <div id="date" style="width:100%">
        <div  id="from" style="float:left;margin-right:5px">
            From: <%= fromDate %>
        </div>
        <div style="float:left;" id="to">
            To: <%= toDate %>
        </div>
    </div>
    <br />
    <h4>Result:</h4>
    <%
    if(orderList.size()>0) {
%>
        

        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>OrderID</th>
                    <th>Date</th>
                    <th>Customer</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                int count = 1;
                String urlRewriting = "Controller?btAction=view_detail&orderID=";
                String urlRwPart2 = "&txtFromDate=" + fromDate 
                        + "&txtToDate=" + toDate;
                for(OrderDTO dto : orderList) {
                    String detailUrl = urlRewriting + dto.getOrderID() 
                            + urlRwPart2;
                    %>
                    <tr>
                        <td>
                            <%= count++ %>
                        .</td>
                        <td>
                            <%= dto.getOrderID() %>
                        </td>
                        <td>
                            <%= dto.getOrderDate().toString() %>
                        </td>
                        <td>
                            <%= dto.getCustomer().getCustomerName() %>
                        </td>
                        <td>
                            <%= dto.getTotal() %>
                        </td>
                        <td>
                            <a href="<%= detailUrl %>">Detail</a>
                        </td>
                    </tr>
                    
                    <%
                
                }
        
                %>
                
                
            </tbody>
        </table>

<%
    } else {
        %>
        <h3>No result matched.</h3>
        <%
    }
}  
%>

