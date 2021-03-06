package controller;

import dao.HistoryBuyDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.ProductToCart;

/**
 *
 * @author Admin
 */
public class BuyController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BuyController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BuyController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        response.setContentType("text/html;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginInvalid", "Kh??ch h??ng vui l??ng ????ng nh???p tr?????c khi ti???n h??nh mua !!");
            response.sendRedirect("Cart");
        } else {
            Account user = (Account) request.getSession().getAttribute("user");
            HttpSession session = request.getSession();
            if (user.getRole().equalsIgnoreCase("admin")) {
                session.setAttribute("notiBuy", "B???n ??ang ????ng nh???p d?????i quy???n Admin! kh??ng th??? ?????t h??ng");
                session.removeAttribute("cart");
                session.removeAttribute("totalPrice");
                session.removeAttribute("cartSize");
                response.sendRedirect("Store");
                return;
            }
            HistoryBuyDAO db = new HistoryBuyDAO();
            Account x = (Account) session.getAttribute("user");
            ArrayList<ProductToCart> listItem = (ArrayList<ProductToCart>) session.getAttribute("cart");
            for (ProductToCart item : listItem) {
                int result = db.insertIntoHistoryBuyTable(x.getUsername(), item.getProductWithMaterial().getProductWithMaterialID(), item.getQuantity());
            }
            session.setAttribute("notiBuy", "?????t h??ng th??nh c??ng!!<br> Qu?? kh??ch c?? th??? ki???m tra l???i ??? m???c l???ch s??? mua h??ng");
            session.removeAttribute("cart");
            session.removeAttribute("totalPrice");
            session.removeAttribute("cartSize");
            response.sendRedirect("Store");
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
        processRequest(request, response);
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
