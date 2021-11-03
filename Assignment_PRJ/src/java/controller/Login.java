package controller;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Admin
 */
public class Login extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("uname");
        String password = request.getParameter("psw");
        Map<String, String> messages = new HashMap<String, String>();

        if (username == null || username.isEmpty()) {
            messages.put("username", "Vui lòng nhập tài khoản");
        }

        if (password == null || password.isEmpty()) {
            messages.put("password", "Vui lòng nhập mật khẩu");
        }
        HttpSession session = request.getSession();
        if (messages.isEmpty()) {
            AccountDAO db = new AccountDAO();
            ArrayList<Account> listAccount = db.getAll();
            Account customerAccount = null;
            for (Account account : listAccount) {
                if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                    customerAccount = account;
                    break;
                }
            }
            if (customerAccount != null) {
                String remember = request.getParameter("remember");
                if (remember != null) {
                    Cookie c_user = new Cookie("username", username);
                    Cookie c_pass = new Cookie("password", password);
                    c_user.setMaxAge(3600 * 24 * 30);
                    c_pass.setMaxAge(3600 * 24 * 30);
                    response.addCookie(c_pass);
                    response.addCookie(c_user);
                }
                session.setAttribute("user", customerAccount);
                session.setAttribute("remember", remember);
                response.sendRedirect(request.getParameter("currentUrl"));
                return;
            } else {
                messages.put("loginError", "Sai tài khoản hoặc mật khẩu");
            }
        }
        session.setAttribute("loginInvalid", messages.values());
        response.sendRedirect(request.getParameter("currentUrl"));
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
