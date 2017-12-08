package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bv2-paniyanduw
 */
@WebServlet(name = "changePW", urlPatterns = {"/changePW"})
public class ChangePW extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher view = request.getRequestDispatcher("changePW.jsp");
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
        processRequest(request, response);
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

            String oldpw = request.getParameter("oldpw").trim();
            String newpw1 = request.getParameter("newpw1").trim();
            String newpw2 = request.getParameter("newpw2").trim();

            //check if password entered matches
            if (oldpw.equals(u.password)) {
                //ensure new PW is not null
                if (newpw1.equals(newpw2) && !newpw1.equalsIgnoreCase("")) {
                    u.password = newpw1;
                    b.updateUser(u);
                    request.setAttribute("message", " Password changed successfully.");
                } else {
                    request.setAttribute("message", " New password didn't match. Please try again.");
                }
            } else {
                request.setAttribute("message", " Password incorrect. Please try again.");
            }
            
            processRequest(request, response);

        } catch (Exception e) {
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
