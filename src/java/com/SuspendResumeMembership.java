/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Jake
 */
@WebServlet(name = "SuspendResumeMembership", urlPatterns = {"/SuspendResumeMembership"})
public class SuspendResumeMembership extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        DBBean b = (DBBean)session.getAttribute("bean");
        if(b == null)
        {
            b = new DBBean("esddb", "server", "123");
            session.setAttribute("bean", b);
        }
        request.setAttribute("members", b.getMembers());
        RequestDispatcher view = request.getRequestDispatcher("SuspendResumeMembership.jsp");
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
            Logger.getLogger(SuspendResumeMembership.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            String[] toSuspend = request.getParameterValues("suspended");
            HttpSession session = request.getSession();
            DBBean b = (DBBean)session.getAttribute("bean");
            if(b == null)
            {
                    b = new DBBean("esddb", "server", "123");
                    session.setAttribute("bean", b);
            }
            ArrayList<Member> members = b.getMembers();
            if(toSuspend != null)
            {
                for(Member m : members)
                    m.status = "APPROVED";
                for(Member m : members)
                {
                    for(String s : toSuspend)
                        if(m.id.equals(s))
                        m.status = "SUSPENDED";
                    b.updateMember(m);
                }
                processRequest(request, response);
            }
            else
                for(Member m : members)
                {
                    m.status = "APPROVED";
                    b.updateMember(m);
                }
            processRequest(request, response);
        } catch (SQLException ex) {}  
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
