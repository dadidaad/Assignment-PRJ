package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ProductWithMaterial;

/**
 *
 * @author Admin
 */
public class DashboardController extends HttpServlet {

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
    protected void doPost_Edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String idproductMaterialEdit = request.getParameter("productWithMaterialIDedit");
        String productPriceEdit = request.getParameter("priceEdit");
        String productImgEdit = request.getParameter("ImgEdit");
        String idProductEdit = request.getParameter("productIDedit");
        String descEdit = request.getParameter("DescEdit");
        ProductDAO db = new ProductDAO();
        int result = db.updateProductWithMaterial(idproductMaterialEdit, productPriceEdit, productImgEdit);
        result = db.updateProduct(idProductEdit, descEdit);
        HttpSession session = request.getSession();
        session.setAttribute("notiUpdate", "Sửa sản phẩm thành công");
        response.sendRedirect("Dashboard#edit");
    }

    protected void doPost_Add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String productNameAdd = request.getParameter("productName");
        String productDescAdd = request.getParameter("descriptionProduct");
        String productBrandAdd = request.getParameter("brandName");
        String productImgAdd = request.getParameter("ProductImg");
        String productPriceAdd = request.getParameter("productPrice");
        String productMaterialAdd = request.getParameter("materialProduct");
        ProductDAO db = new ProductDAO();
        int result = db.insertProduct(productNameAdd, productDescAdd, Integer.parseInt(productBrandAdd));
        result = db.insertProductWithMaterial(db.getIDProductFromName(productNameAdd), productImgAdd, productPriceAdd, Integer.parseInt(productMaterialAdd));
        HttpSession session = request.getSession();
        session.setAttribute("notiAdd", "Thêm sản phẩm thành công");
        response.sendRedirect("Dashboard#add");
    }
    protected void doPost_Remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String idRemove = request.getParameter("idDelete");
        ProductDAO db = new ProductDAO();
        int result = db.deleteProductWithMaterial(idRemove);
        HttpSession session = request.getSession();
        session.setAttribute("notiDelete", "Xoá sản phẩm thành công");
        response.sendRedirect("Dashboard#remove");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("addProduct") != null) {
            doPost_Add(request, response);
        }
        if (request.getParameter("editProduct") != null) {
            doPost_Edit(request, response);
        }
        if (request.getParameter("idDelete") != null) {
            doPost_Remove(request, response);
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
