/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
@WebServlet(name = "TotalIncome", urlPatterns = {"/TotalIncome"})
public class TotalIncome extends HttpServlet {

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
        ArrayList<Claim> claims = b.getClaims();
        ArrayList<Payment> payments = b.getPayments();
        double claimamount = 0;
        double paymentamount = 0;
        double totalamount = 0;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -1);
        java.util.Date d = cal.getTime();
        for(Claim c : claims)
            if(d.before(c.date))
                claimamount +=  c.amount;
        for(Payment p : payments)
            if(d.before(p.date))
                paymentamount += p.amount;
        totalamount = paymentamount - claimamount;
        request.setAttribute("claimamount", Double.toString(claimamount));
        request.setAttribute("paymentamount", Double.toString(paymentamount));
        request.setAttribute("totalamount", Double.toString(totalamount));
        request.setAttribute("date", cal);
        RequestDispatcher view = request.getRequestDispatcher("totalIncome.jsp"); 
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
            Logger.getLogger(TotalIncome.class.getName()).log(Level.SEVERE, null, ex);
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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(TotalIncome.class.getName()).log(Level.SEVERE, null, ex);
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
