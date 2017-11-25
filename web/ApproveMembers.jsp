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
            %>
            <TABLE BORDER=1 CELLPADDING=0 CELLSPACING=0>
                <%  for(Member m : members){    %>
                    <TR>
                        <td>
                            <input type="checkbox" value="unchecked" />
                        </td>
                        <td><%out.print(m.id);%></td>
                        <td><%out.print(m.name);%></td>
                        <td><%out.print(m.address);%></td>
                        <td><%out.print(m.dob);%></td>
                        <td><%out.print(m.dor);%></td>
                    </TR>
                <%}%>
            </TABLE>
          </div>
    </body>
</html>
