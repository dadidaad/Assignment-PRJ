package controller;

import dao.ProductDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.ProductWithMaterial;
import utils.DataHandle;

/**
 *
 * @author Admin
 */
@MultipartConfig
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
    String savePath = "C:\\Users\\Admin\\Documents\\Assignment_PRJ\\temp";
    File fileSaveDir = new File(savePath);
    DataHandle dh = new DataHandle();

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
        String idproductMaterialEdit = dh.getValue(request.getPart("productWithMaterialIDedit"));
        String productPriceEdit = dh.getValue(request.getPart("priceEdit"));
        Part productImgEdit = request.getPart("ImgEdit");
        String idProductEdit = dh.getValue(request.getPart("productIDedit"));
        String descEdit = dh.getValue(request.getPart("DescEdit"));
        ProductDAO db = new ProductDAO();
        String fileName = Paths.get(productImgEdit.getSubmittedFileName()).getFileName().toString();
        String filePath = savePath + File.separator + fileName;
        dh.copyFile(fileName, productImgEdit, savePath);
        int result = db.updateProductWithMaterial(idproductMaterialEdit, productPriceEdit, filePath);
        result = db.updateProduct(idProductEdit, descEdit);
        HttpSession session = request.getSession();
        session.setAttribute("notiUpdate", "Sửa sản phẩm thành công");
        response.sendRedirect("Dashboard#edit");
    }

    protected void doPost_Add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productNameAdd = dh.getValue(request.getPart("productName"));
        String productDescAdd = dh.getValue(request.getPart("descriptionProduct"));
        String productBrandAdd = dh.getValue(request.getPart("brandName"));
        Part productImgAdd = request.getPart("ProductImg");
        String productPriceAdd = dh.getValue(request.getPart("productPrice"));
        String productMaterialAdd = dh.getValue(request.getPart("materialProduct"));
        ProductDAO db = new ProductDAO();
        String fileName = Paths.get(productImgAdd.getSubmittedFileName()).getFileName().toString();
        String filePath = savePath + File.separator + fileName;
        dh.copyFile(fileName, productImgAdd, savePath);
        int result = db.insertProduct(productNameAdd, productDescAdd, Integer.parseInt(productBrandAdd));
        result = db.insertProductWithMaterial(db.getIDProductFromName(productNameAdd), filePath, productPriceAdd, Integer.parseInt(productMaterialAdd));
        HttpSession session = request.getSession();
        session.setAttribute("notiAdd", "Thêm sản phẩm thành công");
        response.sendRedirect("Dashboard#add");
    }

    protected void doPost_Remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String idProductWithMaterial = dh.getValue(request.getPart("idProductWithMaterialDelete"));
        String idProductDelete = dh.getValue(request.getPart("idProductDelete"));
        ProductDAO db = new ProductDAO();
        int result = db.deleteProductWithMaterial(idProductDelete, idProductWithMaterial);
        HttpSession session = request.getSession();
        session.setAttribute("notiDelete", "Xoá sản phẩm thành công");
        response.sendRedirect("Dashboard#remove");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String choice = dh.getValue(request.getPart("choice"));
        if (choice.equalsIgnoreCase("add")) {
            doPost_Add(request, response);
            return;
        }
        if (choice.equalsIgnoreCase("edit")) {
            doPost_Edit(request, response);
            return;
        }
        if (choice.equalsIgnoreCase("delete")) {
            doPost_Remove(request, response);
            return;
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
