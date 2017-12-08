<%-- 
    Document   : ApproveMembers
    Created on : 29-Nov-2017, 06:32:53
    Author     : Banuka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Approve or Reject Claims</title>
    </head>
    <body>
        <a href="./MainController">Dash</a>
        <a href="./Logout">Logout</a>
        <a href="./ViewClaims">View Past Claims<br></a>
        
        <h1>Approve or Reject Claims</h1>
        <div id="checkboxes">
            <%@ page import="java.util.ArrayList"%>
            <%@ page import="com.Claim"%>
            <%
                ArrayList<Claim> claims = (ArrayList<Claim>)request.getAttribute("claims");
            %>
            <%  if(claims.size() > 0) {    %>
                <form action="ApproveClaims" method="post"> 
                    <TABLE id="claimTable" BORDER=1 CELLPADDING=2 CELLSPACING=0>
                        <td></td>
                        <td><b>ID</b></td>
                        <td><b>Member ID</b></td>
                        <td><b>Date</b></td>
                        <td><b>Rationale</b></td>
                        <td><b>Status</b></td>
                        <td><b>Amount</b></td>
                        <%  for(int x = 0; x < claims.size(); x++){
                            Claim c = claims.get(x);  %>
                            <TR>
                                <td>
                                    <input type="checkbox" name="checkedClaims" value="<%out.print(c.id);%>" />
                                </td>
                                <td><%out.print(c.id);%></td>
                                <td><%out.print(c.mem_id);%></td>
                                <td><%out.print(c.date);%></td>
                                <td><%out.print(c.rationale);%></td>
                                <td><%out.print(c.status);%></td>
                                <td><%out.print("£"+c.amount);%></td>
                            </TR>
                        <%}%>
                    </TABLE>
                    <input type="submit" value="Approve">
                </form>
            
            <form action="RejectClaims" method="post"> 
                    <TABLE id="claimTable" BORDER=1 CELLPADDING=2 CELLSPACING=0>
                        <td></td>
                        <td><b>ID</b></td>
                        <td><b>Member ID</b></td>
                        <td><b>Date</b></td>
                        <td><b>Rationale</b></td>
                        <td><b>Status</b></td>
                        <td><b>Amount</b></td>
                        <%  for(int x = 0; x < claims.size(); x++){
                            Claim c = claims.get(x);  %>
                            <TR>
                                <td>
                                    <input type="checkbox" name="checkedClaims" value="<%out.print(c.id);%>" />
                                </td>
                                <td><%out.print(c.id);%></td>
                                <td><%out.print(c.mem_id);%></td>
                                <td><%out.print(c.date);%></td>
                                <td><%out.print(c.rationale);%></td>
                                <td><%out.print(c.status);%></td>
                                <td><%out.print("£"+c.amount);%></td>
                            </TR>
                        <%}%>
                    </TABLE>
                    <input type="submit" value="Reject">
                </form>
            
            <%
                }
                else{
            %>
            <p>There are currently no new claims for approval</p>
            <%}%>
          </div>
    </body>
</html>
