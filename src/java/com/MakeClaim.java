package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
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
@WebServlet(name = "MakeClaim", urlPatterns = {"/MakeClaim"})
public class MakeClaim extends HttpServlet {

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
        RequestDispatcher view = request.getRequestDispatcher("makeClaim.jsp");
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
            Logger.getLogger(MakeClaim.class.getName()).log(Level.SEVERE, null, ex);
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
            User u = (User) session.getAttribute("user");
            DBBean b = (DBBean) session.getAttribute("bean");
            double amount = 0;
            String rationale = "";
            if (u == null) {
                RequestDispatcher view = request.getRequestDispatcher("login.jsp");
                view.forward(request, response);
            }
            if (b == null) {
                b = new DBBean("esddb", "server", "123");
                session.setAttribute("bean", b);
            }
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.YEAR, -1);
            java.util.Date d = cal.getTime();
            //AUTOMATICALLY REJECT CLAIMS
            /*int claimCount = 0;
            for(Claim c : b.getClaims())
                if(c.mem_id.equals(u.id))
                {
                    if(d.before(c.date));
                        claimCount++;
                }
            if(claimCount > 2)
            {
                request.setAttribute("message", "You cannot submit more claims.");
                processRequest(request, response);
                return;
            }*/
            try {
                amount = Double.parseDouble(request.getParameter("amount"));
            } catch (Exception e) {
            }
            try {
                rationale = (String) request.getParameter("rationale");
            } catch (Exception e) {
            }
            Claim c = new Claim(b.getClaims().size() + 1, u.id, new Date(d.getTime()), rationale, "APPLIED", amount);
            request.setAttribute("message", "");
            if (c.rationale == null || c.rationale.equals("")) {
                request.setAttribute("message", request.getAttribute("message") + "A rationale is required.");
                processRequest(request, response);
                return;
            }
            if (c.amount <= 0) {
                request.setAttribute("message", request.getAttribute("message") + "An amount above 0 is required.");
                processRequest(request, response);
                return;
            }
            b.addClaim(c);
            request.setAttribute("message", "Your claim has been submitted.");
            processRequest(request, response);
        } catch (SQLException ex) {
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
