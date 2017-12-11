<%-- 
    Document   : SuspendReviewMembership
    Created on : 27-Nov-2017, 15:20:23
    Author     : Jake
--%>

<%@page import="com.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Suspend/Resume Membership</title>
    </head>
    <body>
        <a href="./MainController">Dash</a>
        <a href="./Logout">Logout</a>
        <h1>Suspend/Resume Memberships</h1>
        <%ArrayList<Member> members = (ArrayList<Member>)request.getAttribute("members");%>
        <form action="SuspendResumeMembership" method="post"> 
        <TABLE id="membersList" border=1 cellpadding=2 cellspacing=0>
            <TR>
                <td><%out.print("Suspended");%></td>
                <td><%out.print("ID");%></td>
                <td><%out.print("Name");%></td>
                <td><%out.print("Address");%></td>
                <td><%out.print("Date of birth");%></td>
                <td><%out.print("Date of registration");%></td>
            </TR>
           
            <% for(Member m : members){ %>
            <TR>
                <% if(m.status.equals("SUSPENDED")){%>
                <td><input type="checkbox" name="suspended" value="<%out.print(m.id);%>" checked=checked/></td>
                <%}else{%>
                <td><input type="checkbox" name="suspended" value="<%out.print(m.id);%>"/></td>
                <%}%>
                <td><%out.print(m.id);%></td>
                <td><%out.print(m.name);%></td>
                <td><%out.print(m.address);%></td>
                <td><%out.print(m.dob);%></td>
                <td><%out.print(m.dor);%></td>
            </TR>
            <% } %>
            <input type="submit" value="Apply">
            </form>
        </TABLE>
    </body>
</html>
