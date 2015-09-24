<%-- 
    Document   : login
    Created on : Sep 22, 2015, 12:29:56 PM
    Author     : Hau
--%>

<%@page import="com.assignment1.account.accountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Login Page - occurs errors</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <h1>Login Page - occurs errors</h1>
        
        <%
            accountError errorbj = (accountError) request.getAttribute("ERROROBJ");
            if(errorbj!=null) {
                %>
               
                <%
                    if(errorbj.getInvalidUsernamePassword()!=null) {
                        %>
                        <h3> <font color="red">
                            <%= errorbj.getInvalidUsernamePassword() %>
                        </font></h3>
                        <h4>
                            <a href="Controller?btAction=signUp">
                                Click here to Sign up a new account</a>
                            <br/>
                            or Try again:
                        </h4>
                        <%
                    }
                    
                    if(errorbj.getNullPointer()!=null) {
                        %>
                        <h3> <font color="red">
                            <%= errorbj.getNullPointer() %>
                        </font></h3>
                        <h4>
                            <a href="Controller?btAction=signUp">
                                Click here to Sign up a new account</a>
                            <br/>
                            or Try again:
                        </h4>
                        <%
                    }
                %>
                <%
            }
            String accountID = request.getParameter("accountID");
        %>
        
        <form action="Controller" method="POST">
            <table>
                <tr>
                    <td width="80px">Username:</td>
                    <td width="200px">
                        <input style="width:200px;" type="text" name="accountID" 
                               value="<%
                                if(accountID!=null) {
                                    out.print(accountID);
                                }
                               %>" />
                        <font color="red">
                        <%
                            if(errorbj!=null) {
                                if(errorbj.getNullUsername()!=null) {
                                    out.print(errorbj.getNullUsername());
                                }
                            }
                        %>
                        </font>
                    </td>
                </tr>
                <tr>
                    <td width="80px">Password:</td>
                    <td width="200px">
                        <input style="width:200px;" type="password" name="password" value="" />
                        <font color="red">
                        <%
                            if(errorbj!=null) {
                                if(errorbj.getNullPassword()!=null) {
                                    out.print(errorbj.getNullPassword());
                                }
                            }
                        %>
                        </font>
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
