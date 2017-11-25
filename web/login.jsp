 <%-- 
    Document   : login
    Created on : 12-Nov-2017, 15:48:18
    Author     : leoed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="LoginServlet" method="post">  
        Name:<input type="text" name="name"><br>  
        Password:<input type="password" name="password"><br>  
        <input type="submit" value="Login">  
    </form>
    <p>
    
    <%
        String s = (String)request.getAttribute("message");
        
        if(s != null)
            out.print(s);
    %>
    
    </body>
</html>
