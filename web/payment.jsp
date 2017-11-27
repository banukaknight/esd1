<%-- 
    Document   : Payment
    Created on : 20-Nov-2017, 01:34:21
    Author     : Jake
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make Payment</title>
    </head>
    <body>
        <a href="./MainController">Dash</a>
        <a href="./Logout">Logout</a>
        <h1>Make a new payment</h1>
        <% 
           String err = "";
           double balance = 0.00; 
           try{balance = Double.parseDouble(request.getAttribute("balance").toString());}catch(Exception e){err = "Member doesn't exist, please log in and try again.";}%>
        Your balance is: <%= balance %>
        <br><%= err %>
        <form action="PaymentServlet" method="post">  
        Amount:<input type="text" name="amount"><br>  
        Bank no.:<input type="text"><br>  
        Sort code:<input type="text"><br>  
        <input type="submit" value="Pay">  
    </form>
        
    </body>
</html>
