<%-- 
    Document   : makeClaim
    Created on : 27-Nov-2017, 22:49:32
    Author     : Jake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make Claim</title>
    </head>
    <body>
        <a href="./MainController">Dash</a>
        <a href="./Logout">Logout</a>
        <h1>Make Claim</h1>
        <form action="MakeClaim" method="post">  
            Amount:<input type="text" name="amount"><br>  
            Rationale:<input type="text" name="rationale"><br>   
        <input type="submit" value="Submit"><br> 
        </form>
        <%  String message = (String)request.getAttribute("message");
            if(message != null)out.print(message);%>
    </body>
</html>
