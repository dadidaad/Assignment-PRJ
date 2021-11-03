package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ProductToCart;
import model.ProductWithMaterial;

/**
 *
 * @author Admin
 */
public class CartController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("idItem") != null) {
            doGet_Remove(request, response);
        } else {
            if (request.getSession().getAttribute("cart") != null) {
                request.getRequestDispatcher("CartDisplay").forward(request, response);
            } else {
                response.sendRedirect("Store");
            }
        }
    }

    protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<ProductToCart> cart = (ArrayList<ProductToCart>) session.getAttribute("cart");
        int index = Integer.parseInt(request.getParameter("idItem"));
        cart.remove(index);
        session.setAttribute("cart", cart);
        session.setAttribute("cartSize", cart.size());
        session.setAttribute("totalPrice", totalPrice(cart));
        response.sendRedirect("Cart");
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
        doPost_Buy(request, response);
    }

    protected void doPost_Buy(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String productWithMaterialID = request.getParameter("idProductMaterial");
        String quantityProduct = request.getParameter("quantity");
        String currentUrl = request.getParameter("currentUrl");
        ProductDAO db = new ProductDAO();
        HttpSession session = request.getSession();
        ProductWithMaterial x = db.getProductMaterialByID(productWithMaterialID);
        ProductToCart newItem = new ProductToCart();
        newItem.setProductWithMaterial(x);
        newItem.setQuantity(Integer.parseInt(quantityProduct));
        if (session.getAttribute("cart") == null) {
            ArrayList<ProductToCart> listItemCart = new ArrayList<>();
            listItemCart.add(newItem);
            session.setAttribute("cart", listItemCart);
            session.setAttribute("cartSize", listItemCart.size());
            session.setAttribute("totalPrice", totalPrice(listItemCart));
        } else {
            ArrayList<ProductToCart> listItemCart = (ArrayList<ProductToCart>) session.getAttribute("cart");
            int index = isExisting(productWithMaterialID, listItemCart);
            if (index == -1) {
                listItemCart.add(newItem);
            } else {
                if (!currentUrl.contains("Cart")) {
                    int quantity = listItemCart.get(index).getQuantity() + Integer.parseInt(quantityProduct);
                    listItemCart.get(index).setQuantity(quantity);
                } else {
                    int quatity = Integer.parseInt(quantityProduct);
                    listItemCart.get(index).setQuantity(quatity);
                }
            }
            session.setAttribute("cart", listItemCart);
            session.setAttribute("cartSize", listItemCart.size());
            session.setAttribute("totalPrice", totalPrice(listItemCart));
        }
        if (currentUrl.contains("Cart")) {
            response.sendRedirect("Cart");
        } else {
            response.sendRedirect("Store");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    private int isExisting(String id, ArrayList<ProductToCart> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProductWithMaterial().getProductWithMaterialID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    private String totalPrice(ArrayList<ProductToCart> listCart) {
        BigInteger total = BigInteger.ZERO;
        for (ProductToCart x : listCart) {
            BigInteger productPrice = new BigInteger(x.getSubTotal());
            total = total.add(productPrice);
        }
        return total.toString();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
