<%-- 
    Document   : changePW
    Created on : 26-Nov-2017, 01:35:31
    Author     : bv2-paniyanduw
    
    Give user the chance to change their Name, address and DOB
--%>
<%@page import="java.sql.Date"%>
<%@page import="com.Member"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Member member = (Member) request.getAttribute("member");%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>User Info</title>
    </head>
    <body>
        <a href="./MainController">Dash</a>
        <a href="./Logout">Logout</a> 

        <h1>User Info</h1>

        <form action="ChangeUinfo" method="post">  

            <table>
                <tr>
                    <td>User Name:</td>
                    <td><% out.print(member.name); %></td> 
                </tr>
                <tr>
                    <td>User ID</td>
                    <td><% out.print(member.id); %></td> 
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><% out.print(member.address); %></td> 
                </tr>
                <tr>
                    <td>Date of Birth:</td>
                    <td><% out.print(member.dob); %></td> 
                </tr>
                <tr>
                    <td>Date of Registration:</td>
                    <td><% out.print(member.dor); %></td> 
                </tr>
                <tr>
                    <td>Balance:</td>
                    <td><% out.print(String.format("£%.2f", member.balance));%></td> 
                </tr>

                <tr> </tr><tr> </tr>
            </table> 

            <h3>Edit Info</h3> 
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="myname" value="<% out.print(member.name); %>"></td> 
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="myadr" value="<% out.print(member.address); %>"></td> 
                </tr>
                <tr>
                    <td>Date of Birth:</td>
                    <td>
                        <input type="date" name="mydob" value=<% out.print(member.dob);%>></td> 
                </tr>
                <tr>
                    <td>Enter your password:</td>
                    <td><input type="password" name="mypw"></td> 
                </tr>

                <tr><td> and verify changes</td>
                    <td><input type="submit" value="Submit"></td>
                </tr>
            </table> 
            <br> <br> 
        </form>



    </body>
</html>