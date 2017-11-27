<%-- 
    Document   : viewUserClaimsAndPayments
    Created on : 27-Nov-2017, 16:42:42
    Author     : leoed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Claims and Payments</title>
    </head>
    <body>
        <div>
            <%@ page import="java.util.ArrayList"%>
            <%@ page import="com.Claim"%>
            <%@ page import="com.Payment"%>
            <%
                ArrayList<Claim> claims = (ArrayList<Claim>)request.getAttribute("claims");
                ArrayList<Payment> payments = (ArrayList<Payment>)request.getAttribute("payments");
            %>
            <%  if(claims.size() > 0) {    %>
            <h1>Your Claims</h1>
                    <TABLE id="claimTable" BORDER=1 CELLPADDING=2 CELLSPACING=0>
                        <td><b>ID</b></td>
                        <td><b>Member ID</b></td>
                        <td><b>Date</b></td>
                        <td><b>Rationale</b></td>
                        <td><b>Status</b></td>
                        <td><b>Amount</b></td>
                        <%  for(int x = 0; x < claims.size(); x++){
                            Claim c = claims.get(x);  %>
                            <TR>
                                <td><%out.print(c.id);%></td>
                                <td><%out.print(c.mem_id);%></td>
                                <td><%out.print(c.date);%></td>
                                <td><%out.print(c.rationale);%></td>
                                <td><%out.print(c.status);%></td>
                                <td><%out.print(c.amount);%></td>
                            </TR>
                        <%}%>
                    </TABLE><br>
            <%
                }
                else{
            %>
            <p><br>You have no claims<br></p>
            <%}%>
            <%  if(payments.size() > 0) {    %>
            <h1>Your Payments</h1>
                    <TABLE id="paymentTable" BORDER=1 CELLPADDING=2 CELLSPACING=0>
                        <td><b>ID</b></td>
                        <td><b>Member ID</b></td>
                        <td><b>Type of Payment</b></td>
                        <td><b>Amount</b></td>
                        <td><b>Date</b></td>
                        <td><b>Time</b></td>
                        <%  for(int x = 0; x < payments.size(); x++){
                            Payment p = payments.get(x);  %>
                            <TR>
                                <td><%out.print(p.id);%></td>
                                <td><%out.print(p.mem_id);%></td>
                                <td><%out.print(p.type_of_payment);%></td>
                                <td><%out.print(p.amount);%></td>
                                <td><%out.print(p.date);%></td>
                                <td><%out.print(p.time);%></td>
                            </TR>
                        <%}%>
                    </TABLE><br>
            <%
                }
                else{
            %>
            <p><br>You have no payments<br></p>
            <%}%>
          </div>
    </body>
</html>
