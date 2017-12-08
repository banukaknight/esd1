<%-- 
    Document   : userDashboard
    Created on : 27-Nov-2017, 17:11:11
    Author     : leoed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>User Dash</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <a href="./Logout">Logout</a>
        <h1>User Dash</h1>
        <%@ page import="com.Member"%>
        <%Member member = (Member)request.getAttribute("member");%>
        <p>Your balance: <% out.print(String.format("£%.2f", member.balance));    %></p>
        <a href="./MakePayment">Make a Payment<br></a>
        <a href="./MakeClaim">Make a Claim<br></a>
        <a href="./ViewClaimsAndPayments">View Your Claims and Payments<br></a>
        <a href="./ChangePWs">Change Password<br></a>
            </body>
</html>
