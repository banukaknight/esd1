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
        <form action="RegisterServlet" method="post">  
        Name:<input type="text" name="name"><br>  
        Address:<input type="text" name = "address"><br>  
        Date of birth:<input type="date" name = "dob"><br>  
        <input type="submit" value="Register">  
        <br>
        <%
        String err = (String)request.getAttribute("error");
        if(err != null) out.print(err);
        %>
    </body>
</html>
