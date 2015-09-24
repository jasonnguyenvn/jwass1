<%-- 
    Document   : signUp
    Created on : Sep 24, 2015, 9:02:08 PM
    Author     : Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sign Up a new account</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <h1>Sign Up a new account</h1>
        
        <form action="Controller" method="POST">
            <table>
                <tr>
                    <td width="80px">Username:</td>
                    <td width="200px">
                        <input style="width:200px;" type="text" 
                               name="accountID" value="" />
                        (3 - 10 characters)
                    </td>
                </tr>
                <tr>
                    <td width="80px">Full name:</td>
                    <td width="200px">
                        <input style="width:200px;" type="text" 
                               name="customerName" value="" />
                        (3 - 50 characters)
                    </td>
                </tr>
                <tr>
                    <td width="80px">Password:</td>
                    <td width="200px">
                        <input style="width:200px;" type="password" 
                               name="password" value="" />
                        (6 - 20 characters)
                    </td>
                </tr>
                <tr>
                    <td width="80px">Confirm:</td>
                    <td width="200px">
                        <input style="width:200px;" type="password"
                               name="txtConfirm" value="" />
                    </td>
                </tr>
                <tr>
                    <td width="80px">Email:</td>
                    <td width="200px">
                        <input style="width:200px;" type="text"
                               name="email" value="" />
                        (max 50 characters)
                    </td>
                </tr>
                
                <tr>
                    <td width="80px" ></td>
                    <td>
                        <input type="submit" style="width:49%;" 
                               value="Sign Up!" name="btAction" />
                        <input type="reset" style="width:49%;" value="Reset" />
                    </td>
                </tr>
                
            </table>
        </form>
    </body>
</html>

