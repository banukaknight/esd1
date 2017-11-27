
package com;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
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
        //Requests everything from each table on the database and stores in an arraylist
        //DBBean b = new DBBean("databse", "username", "password");
        
        //Array lists to store records returned
        //ArrayList<Claim> claims = b.getClaims();
        //ArrayList<Payment> payments = b.getPayments();
        //ArrayList<Member> members = b.getMembers();
        //ArrayList<User> users = b.getUsers();
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"http://localhost:8080/ESDAssignment/MakePayment\">Make Payment</a>");
            
            //EXAMPLE CODE TO ADD NEW RECORDS

            //b.addUser(new User("id", "pw", "status"));
            //b.addClaim(new Claim(34334, "id", new Date(1,1,1), "rat", "stat", 324.2 ));
            //b.addMember(new Member("id", "name", "add", new Date(1,2,3), new Date(3,2,1), "stat", 123.1));
            //b.addPayment(new Payment(3453, "id", "payment", 234.22, new Date(12,3,4), new Time(1,2,3)));
            
            //EXAMPLE CODE TO UPDATE RECORDS
            
            //b.updateUser(new User("id", "id", "id"));
            //b.updateClaim(new Claim(34334, "id", new Date(1,2,3), "rat", "stat", 3123.2 ));
            //b.updateMember(new Member("id", "name", "add", new Date(1,12,3), new Date(3,12,1), "stat", 1123123.1));
            //b.updatePayment(new Payment(3453, "id", "pa112312", 234.22, new Date(12,3,4), new Time(1,2,3)));
            
            //EXAMPLE CODE TO VIEW EACH TABLE
            
            //for(Claim c : claims)
            //    out.println("<p>" + c.toString() + "</p>");
            //out.println("<br><h1>Users</h1>");
            //for(User u : users)
            //    out.println("<p>" + u.toString() + "</p>");
            //out.println("<br><h1>Member</h1>");
            //for(Member m : members)
            //    out.println("<p>" + m.toString() + "</p>");
            //out.println("<br><h1>Payments</h1>");
            //for(Payment p : payments)
            //    out.println("<p>" + p.toString() + "</p>");

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
