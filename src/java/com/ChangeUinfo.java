/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bv2-paniyanduw
 */
@WebServlet(name = "changeUinfo", urlPatterns = {"/changeUinfo"})
public class ChangeUinfo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        DBBean b = (DBBean) session.getAttribute("bean");
        if (u == null) {
            RequestDispatcher view = request.getRequestDispatcher("login.jsp");
            view.forward(request, response);
        }
        if (b == null) {
            b = new DBBean("esddb", "server", "123");
            session.setAttribute("bean", b);
        }
        ArrayList<Member> members = b.getMembers();
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).id.equals(u.id)) {
                session.setAttribute("member", members.get(i));
            }
        }

        request.setAttribute("member", Members.getMemberById(u.id, (DBBean) session.getAttribute("bean")));

        RequestDispatcher view = request.getRequestDispatcher("changeUinfo.jsp");
        view.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ChangeUinfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // check entered password against one on database,
        // if matched, submit the changes
        try {
            HttpSession session = request.getSession();
            User u = (User) session.getAttribute("user");
            DBBean b = (DBBean) session.getAttribute("bean");
            Member m = (Member) session.getAttribute("member");

            String myname = request.getParameter("myname").trim();
            String myadr = request.getParameter("myadr").trim();
            Date mydob = Date.valueOf(request.getParameter("mydob"));
            String mypw = request.getParameter("mypw").trim();

            //check if password entered matches & no fields are left null
            if (!mypw.equals(u.password)) {

                request.setAttribute("message", " Password incorrect. Please try again.");
            } else if (myname.trim().equals("") || myadr.trim().equals("") || mydob.toString().equals("")) {
                request.setAttribute("message", " Please fill all fields and Try again.");
            } else {
                try {

                    m.name = myname;
                    m.address = myadr;
                    m.dob = mydob;

                    b.updateMember(m);

                    request.setAttribute("message", " Changes made successfully.");
                } catch (Exception e) {
                    request.setAttribute("message", " Something went wrong can you find what.");
                }

            }

            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
