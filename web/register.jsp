<%-- 
    Document   : Register
    Created on : 26-Nov-2017, 20:49:54
    Author     : Jake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <a href="./Login">Go Back</a>

        <h1>Registration</h1>
        <form action="RegisterServlet" method="post">  
            <table>
                <tr><td> Name:</td><td><input type="text" name="name"></td></tr>
                <tr><td>Address:</td><td><input type="text" name = "address"></td></tr>
                <tr><td>Date of birth:</td><td><input type="date" name = "dob" value="2017-01-01"></td></tr>
                <tr><td></td><td><input type="submit" value="Register"></td></tr>
                </form>
            </table>
            <br>
            <h5>Note: New members are expected to pay a registration fee of £10</h5> 
             <h5> and must wait 6 months after registration to apply for a claim.</h5>
            <h5> A member can apply for maximum of 2 claims per year.</h5>
            <%
                String err = (String) request.getAttribute("error");
                if (err != null) {
                    out.print(err);
                }
            %>
            </body>
            </html>
