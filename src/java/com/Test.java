
package com;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Jake
 */
public class Test extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        //Replace databse with database name
        //Replace username with database username
        //Replace password with database password
        DBBean b = new DBBean("databse", "username", "password");
        //Requests everything from each table on the database and stores in an arraylist
        //Example syntax below on how to cycle through 
        ArrayList<Claim> claims = b.getClaims();
        ArrayList<Payment> payments = b.getPayments();
        ArrayList<Member> members = b.getMembers();
        ArrayList<User> users = b.getUsers();
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Claims</h1>");
            for(Claim c : claims)
                out.println("<p>" + c.toString() + "</p>");
            out.println("<br><h1>Users</h1>");
            for(User u : users)
                out.println("<p>" + u.toString() + "</p>");
            out.println("<br><h1>Member</h1>");
            for(Member m : members)
                out.println("<p>" + m.toString() + "</p>");
            out.println("<br><h1>Payments</h1>");
            for(Payment p : payments)
                out.println("<p>" + p.toString() + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {}
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
