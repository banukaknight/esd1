package com;

import java.io.IOException;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
        TotalIncomeCalculator calc = new TotalIncomeCalculator();
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -1);
        Double claimamount = Double.parseDouble(df.format(calc.getClaimsTotal(b)));
        Double chargeamount = Double.parseDouble(df.format(calc.getChargeTotal(b)));
        request.setAttribute("claimamount", Double.toString(claimamount));
        request.setAttribute("chargeamount", Double.toString(chargeamount));
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
            HttpSession session = request.getSession();
            DBBean b = (DBBean)session.getAttribute("bean");
            if(b == null)
            {
                b = new DBBean("esddb", "server", "123");
                session.setAttribute("bean", b);
            }
            TotalIncomeCalculator calc = new TotalIncomeCalculator();
            calc.updateMembers(b);
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
