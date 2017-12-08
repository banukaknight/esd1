<%-- 
    Document   : changePW
    Created on : 25-Nov-2017, 01:35:31
    Author     : bv2-paniyanduw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
    </head>
    <body>
        <a href="./MainController">Dash</a>
        <a href="./Logout">Logout</a>
        <h1>Change Password</h1>
        <form action="changePW" method="post">  

            <table>
                <tr>
                    <td>Current Password:</td>
                    <td><input type="password" name="oldpw"></td> 
                </tr>
                <tr>
                    <td>New Password:</td>
                    <td><input type="password" name="newpw1"></td> 
                </tr>
                <tr>
                    <td>Repeat New Password:</td>
                    <td><input type="password" name="newpw2"></td> 
                </tr>
                
                <tr><td></td>
                    <td><input type="submit" value="Submit"></td>
                </tr>
            </table> 


            <br> 
        </form>


        <%  String message = (String) request.getAttribute("message");
            if (message != null) {
                                out.print(message);
                
            }%>
            
            
    </body>
</html>
