<%-- 
    Document   : TotalIncome
    Created on : 28-Nov-2017, 15:55:53
    Author     : Jake
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Total income and expenditure</title>
    </head>
    <body>
        <%
            String claimamount = "";
            String chargeamount = "";
            String message = "";
            Calendar cal = Calendar.getInstance();
            try{
                claimamount = (String)request.getAttribute("claimamount");
                chargeamount = (String)request.getAttribute("chargeamount");
                cal = (Calendar)request.getAttribute("date");
            }catch(Exception e){message = "Unable to load values"; System.out.println(e);}
         %>
        <a href="./MainController">Dash</a>
        <a href="./Logout">Logout</a>
        <h1>Total income and expenditure</h1>

        <p>From <%out.print(cal.getTime());%> to today.</p>

        <p>Total amount claimed: <%out.print("£"+claimamount);%></p>
        <p>Total amount to charge each member: <%out.print("£"+chargeamount);%></p>   
        <form action="TotalIncome" method="post">  
        <input type="submit" value="Charge Members">  
        <%if(!message.equals("")) out.println(message); %>
    </body>
</html>
