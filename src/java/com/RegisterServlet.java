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
 * @author Jake
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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
        DBBean b = (DBBean) session.getAttribute("bean");
        if (b == null) {
            b = new DBBean("esddb", "server", "123");
            session.setAttribute("bean", b);
        }
        String name = request.getParameter("name");
        java.util.Date d = new java.util.Date();
        String[] nameSplit = name.split(" ");
        String id = nameSplit[0].charAt(0) + "-" + nameSplit[nameSplit.length - 1];
        ArrayList<User> userList = b.getUsers();
        User u;
        int tries = 1;
        int idl = id.length();
        while (!userExists(id, userList).equals("")) {
            id = id.substring(0, idl) + tries;
            tries++;
        }
        Member m;
        Date date = Date.valueOf(request.getParameter("dob"));
        String pw = date.toString();
        String password = "" + pw.charAt(8) + pw.charAt(9) + pw.charAt(5) + pw.charAt(6) + pw.charAt(2) + pw.charAt(3);
        m = new Member(id, name, request.getParameter("address"), date, new Date(d.getTime()), "APPLIED", 10);
        u = new User(id, password, "APPROVED");
        b.addUser(u);
        b.addMember(m);

        request.setAttribute("message", "Your New Username: " + id +" ___Password: " + password);
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);

    }

    private String userExists(String id, ArrayList<User> userlist) {
        for (User u : userlist) {
            if (u.id.equals(id)) {
                return u.id;
            }
        }
        return "";
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
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
