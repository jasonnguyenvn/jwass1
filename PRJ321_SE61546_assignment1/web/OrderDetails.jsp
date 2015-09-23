<%-- 
    Document   : OrderDetails
    Created on : Sep 22, 2015, 1:07:50 PM
    Author     : Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Details</title>
    </head>
    <body>
        <h1>Order Details</h1>
        <div class="info_row">
            <div  class="left" style="width:50%;margin-right:5px">
                Order ID
            </div>
            <div style="width:50%;" class="right">
                Date
            </div>
        </div>
        <br/>
        <div id="date">
            <div  id="from" style="width:50%;margin-right:5px">
                Customer
            </div>
            <div style="width:50%;" id="to">
                Phone
            </div>
        </div>
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
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>

        <!--
            REMEMBER TO ADD LINK HERE
        -->
    </body>
</html>
