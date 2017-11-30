package com;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author leoed
 */
public class RejectClaims extends HttpServlet {

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
        DBBean bean = (DBBean) session.getAttribute("bean");
        ArrayList<Claim> unapprovedClaims = Claims.getPendingClaims(bean);
        request.setAttribute("claims", unapprovedClaims);
        RequestDispatcher view = request.getRequestDispatcher("ApproveClaims.jsp");

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
            Logger.getLogger(ApproveClaims.class.getName()).log(Level.SEVERE, null, ex);
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
        String[] checkedClaims = request.getParameterValues("checkedClaims");
        if (checkedClaims != null) {
            ArrayList<Claim> claimsToApprove = new ArrayList<>();
            HttpSession session = request.getSession();
            ArrayList<Claim> unapprovedClaims = new ArrayList<>();
            DBBean bean = (DBBean) session.getAttribute("bean");
            try {
                unapprovedClaims = Claims.getPendingClaims(bean);
            } catch (SQLException ex) {
                Logger.getLogger(ApproveClaims.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (String id : checkedClaims) {
                for (Claim c : unapprovedClaims) {
                    try {
                         if (id.equals(Integer.toString(c.id))&& Fees.initialFeePaid(Members.getMemberById(c.mem_id, bean), bean))
                       
                            claimsToApprove.add(c);
                        } catch (SQLException ex) {
                        Logger.getLogger(ApproveClaims.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

            for (Claim c : claimsToApprove) 
                Claims.rejectClaim(c, bean);
        }

        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ApproveClaims.class.getName()).log(Level.SEVERE, null, ex);
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
