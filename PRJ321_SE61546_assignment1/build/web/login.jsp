<%-- 
    Document   : login
    Created on : Sep 22, 2015, 12:29:56 PM
    Author     : Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <h1>Login Page</h1>
        <form action="ControllerServlet" method="POST">
            <table>
                <tr>
                    <td width="80px">Username:</td>
                    <td width="200px">
                        <input style="width:200px;" type="text" name="txtUsername" value="" />
                    </td>
                </tr>
                <tr>
                    <td width="80px">Password:</td>
                    <td width="200px">
                        <input style="width:200px;" type="password" name="txtPassword" value="" />
                    </td>
                </tr>
                <tr>
                    <td width="80px" ></td>
                    <td>
                        <input type="submit" style="width:49%;" value="Login" name="btAction" />
                        <input type="reset" style="width:49%;" value="Reset" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
