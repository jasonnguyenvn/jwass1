<%-- 
    Document   : search
    Created on : Sep 22, 2015, 12:30:29 PM
    Author     : Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Order</title>
    </head>
    <body>
        <h1>Search Order</h1>
        
        <form action="ControllerServlet" method="POST">
            <table>
                <tr>
                    <td width="80px">From Date:</td>
                    <td width="200px">
                        <input style="width:200px;" type="text" name="txtFromDate" value="" />
                    </td>
                </tr>
                <tr>
                    <td width="80px">To Date:</td>
                    <td width="200px">
                        <input style="width:200px;" type="text" name="txtToDate" value="" />
                    </td>
                </tr>
                <tr>
                    <td width="80px" ></td>
                    <td>
                        <input type="submit" style="width:49%;" value="Search" name="btAction" />
                        <input type="reset" style="width:49%;" value="Reset" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
