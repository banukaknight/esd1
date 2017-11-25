<%-- 
    Document   : ApproveMembers
    Created on : 25-Nov-2017, 06:32:53
    Author     : leoed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Approve Memberships</title>
    </head>
    <body>
        <div id="checkboxes">
            <%@ page import="java.util.ArrayList"%>
            <%@ page import="com.Member"%>
            <%
                ArrayList<Member> members = (ArrayList<Member>)request.getAttribute("members");
                boolean[] fees = (boolean[])request.getAttribute("fees");
            %>
            <%  if(members.size() > 0) {    %>
                <form action="ApproveMemberships" method="post"> 
                    <TABLE id="memberTable" BORDER=1 CELLPADDING=2 CELLSPACING=0>
                        <td></td>
                        <td><b>ID</b></td>
                        <td><b>Name</b></td>
                        <td><b>Address</b></td>
                        <td><b>Date of Birth</b></td>
                        <td><b>Date of Registration</b></td>
                        <td><b>Balance</b></td>
                        <td><b>Fee Paid</b></td>
                        <%  for(int x = 0; x < members.size(); x++){
                            Member m = members.get(x);  %>
                            <TR>
                                <td>
                                    <input type="checkbox" name="checkedMembers" value="<%out.print(m.id);%>" />
                                </td>
                                <td><%out.print(m.id);%></td>
                                <td><%out.print(m.name);%></td>
                                <td><%out.print(m.address);%></td>
                                <td><%out.print(m.dob);%></td>
                                <td><%out.print(m.dor);%></td>
                                <td><%out.print(m.balance);%></td>
                                <td><%out.print(fees[x] ? "Yes" : "No");%></td>
                            </TR>
                        <%}%>
                    </TABLE>
                    <input type="submit" value="Approve">
                </form>
            <%
                }
                else{
            %>
            <p>There are currently no un-approved members</p>
            <%}%>
          </div>
    </body>
</html>
