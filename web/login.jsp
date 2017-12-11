<%-- 
   Document   : login
   Created on : 12-Nov-2017, 15:48:18
   Author     : leoed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>XYZ App Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <style>
            table, th, td {
            }
            table#t01 {
                border-spacing: 15px;
            }

        </style>

    </head>
    <body>

        <h1>"XYZ Drivers Association"</h1>
        <h4>&nbsp&nbsp&nbsp&nbsp The Company you can trust</h4>


        <table id=t01">
            <tr>
                <td>
                    <h2>Login</h2>
                </td>
                <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
                <td><h2>Register</h2></td></tr>
            <tr>
                <td>
                    <form action="Login" method="post">  
                        <table>
                            <tr>
                                <td>User ID:</td>
                                <td><input type="text" name="name"></td></tr>  
                            <tr>
                                <td>Password:</td>
                                <td><input type="password" name="password"></td></tr>  
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Login"></td>  
                            </tr>
                        </table>
                    </form>
                </td>
                <td></td>

                <td>Please <u><a href="./RegisterMember">Register</a></u> your details with us to join as a XYZ member.
                    <br><br><input type="submit" value="Register" onclick="window.location='./RegisterMember';" />  
                </td>
            </tr>
        </table>
        <br><br>
        <%
            String s = (String) request.getAttribute("message");

            if (s != null) {
                out.print(s);
            }
        %>
    </body>
</html>
