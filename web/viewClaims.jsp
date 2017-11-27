<%-- 
    Document   : viewClaims
    Created on : 27-Nov-2017, 15:14:51
    Author     : leoed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All Claims</title>
    </head>
    <body>
        <div>
            <%@ page import="java.util.ArrayList"%>
            <%@ page import="com.Claim"%>
            <%
                ArrayList<Claim> claims = (ArrayList<Claim>)request.getAttribute("claims");
            %>
            <%  if(claims.size() > 0) {    %>
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
                    </TABLE>
            <%
                }
                else{
            %>
            <p>There are currently no claims</p>
            <%}%>
          </div>
    </body>
</html>
