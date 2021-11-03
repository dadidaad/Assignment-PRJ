package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProductWithMaterial;

/**
 *
 * @author Admin
 */
public class LoadDataController extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String idProduct = request.getParameter("idProduct");
        ProductDAO db = new ProductDAO();
        ProductWithMaterial x = db.getProductMaterialByID(idProduct);
        out.println("<form action=\"DashboardController\" method=\"post\"> <input type=\"hidden\" value=\"edit\" name=\"editProduct\">\n"
                + "                                    <table>\n"
                + "                                        <tr>\n"
                + "                                            <td>\n"
                + "                                                Mô tả\n"
                + "                                            </td>\n"
                + "                                            <td><input type=\"text\" value = \"" + x.getDescription() + "\" name=\"DescEdit\" required></td>\n"
                + "                                    </tr>\n"
                + "                                    <tr>\n"
                + "                                        <td>\n"
                + "                                            Đường dẫn ảnh\n"
                + "                                        </td>\n"
                + "                                        <td>\n"
                + "                                            <input type=\"text\" value=\"" + x.getImgSrc() + "\" name=\"ImgEdit\" required>\n"
                + "                                        </td>\n"
                + "                                    </tr>\n"
                + "                                    <tr>\n"
                + "                                        <td>Giá sản phẩm</td>\n"
                + "                                        <td><input type=\"number\" value=\"" + x.getProductPrice() + "\" name=\"priceEdit\"></td>\n"
                + "                                </table>\n"
                + "                                <tr>\n"
                + "                                    <td><input type=\"hidden\" value=\"" + x.getProductWithMaterialID() + "\" name = \"productWithMaterialIDedit\">" + "<input type=\"hidden\" value=\"" + x.getProductID() + "\" name = \"productIDedit\">"
                + "                                          <input type=\"submit\" value=\"Chỉnh sửa\"></td>\n"
                + "                                </tr>\n"
                + "                            </form>");
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
