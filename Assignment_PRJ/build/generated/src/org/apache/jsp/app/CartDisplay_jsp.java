package org.apache.jsp.app;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.ProductToCart;
import java.util.ArrayList;

public final class CartDisplay_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_url_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
    _jspx_tagPool_c_url_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"./assets/img/favicon.png\" rel=\"icon\" />\n");
      out.write("        <link href=\"./assets/img/apple-touch-icon.png\" rel=\"apple-touch-icon\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.15.4/css/all.css\" integrity=\"sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- Google Fonts -->\n");
      out.write("        <link\n");
      out.write("            href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i\"\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            />\n");
      out.write("\n");
      out.write("        <!-- Vendor CSS Files -->\n");
      out.write("        <link href=\"./assets/vendor/aos/aos.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./assets/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./assets/vendor/bootstrap-icons/bootstrap-icons.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./assets/vendor/boxicons/css/boxicons.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./assets/vendor/glightbox/css/glightbox.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./assets/vendor/remixicon/remixicon.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./assets/vendor/swiper/swiper-bundle.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Template Main CSS File -->\n");
      out.write("        <link rel=\"stylesheet\" charset='utf-8' type=\"text/css\" href=\"\n");
      out.write("              ");
      if (_jspx_meth_c_url_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                  \" />\n");
      out.write("        ");
      dao.ProductDAO db = null;
      synchronized (request) {
        db = (dao.ProductDAO) _jspx_page_context.getAttribute("db", PageContext.REQUEST_SCOPE);
        if (db == null){
          db = new dao.ProductDAO();
          _jspx_page_context.setAttribute("db", db, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("        ");
ArrayList<ProductToCart> cartList = (ArrayList<ProductToCart>)request.getSession().getAttribute("cart");
      out.write("\n");
      out.write("            <div class=\"cart_section\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-10 offset-lg-1\">\n");
      out.write("                            <div class=\"cart_container\">\n");
      out.write("                                <div class=\"cart_title\">Giỏ hàng <small>Có ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.cartSize}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" trong giỏ hàng của bạn</small></div>\n");
      out.write("                            <div class=\"cart_items\">\n");
      out.write("                                <ul class=\"cart_list\">\n");
      out.write("                                    <li class=\"cart_item clearfix\">\n");
      out.write("                                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"order_total\">\n");
      out.write("                                <div class=\"order_total_content text-md-right\">\n");
      out.write("                                    <div class=\"order_total_title\">Order Total:</div>\n");
      out.write("                                    <div class=\"order_total_amount\">₹22000</div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"cart_buttons\"> <button type=\"button\" class=\"button cart_button_clear\">Continue Shopping</button> <button type=\"button\" class=\"button cart_button_checkout\">Add to Cart</button> </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Vendor JS Files -->\n");
      out.write("        <script src=\"./assets/vendor/aos/aos.js\"></script>\n");
      out.write("        <script src=\"./assets/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <script src=\"./assets/vendor/glightbox/js/glightbox.min.js\"></script>\n");
      out.write("        <script src=\"./assets/vendor/isotope-layout/isotope.pkgd.min.js\"></script>\n");
      out.write("        <script src=\"./assets/vendor/php-email-form/validate.js\"></script>\n");
      out.write("        <script src=\"./assets/vendor/purecounter/purecounter.js\"></script>\n");
      out.write("        <script src=\"./assets/vendor/swiper/swiper-bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Template Main JS File -->\n");
      out.write("        <script src=\"./assets/js/main.js\"></script>\n");
      out.write("        <script>\n");
      out.write("              function increaseValue(index) {\n");
      out.write("                var value = parseInt(document.getElementById('number' +index).value, 10);\n");
      out.write("                value = isNaN(value) ? 0 : value;\n");
      out.write("                value++;\n");
      out.write("                document.getElementById('number'+index).value = value;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function decreaseValue(index) {\n");
      out.write("                var value = parseInt(document.getElementById('number' +index).value, 10);\n");
      out.write("                value = isNaN(value) ? 0 : value;\n");
      out.write("                value < 1 ? value = 1 : '';\n");
      out.write("                value--;\n");
      out.write("                document.getElementById('number' +index).value = value;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_url_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(_jspx_page_context);
    _jspx_th_c_url_0.setParent(null);
    _jspx_th_c_url_0.setValue("./assets/css/style.css");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems(new String("cartList"));
    _jspx_th_c_forEach_0.setVar("item");
    _jspx_th_c_forEach_0.setVarStatus("myIndex");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                            <div class=\"cart_item_image\"><img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.getProductWithMaterial().getImgSrc()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\"></div>\n");
          out.write("                                            <div class=\"cart_item_info d-flex flex-md-row flex-column justify-content-between\">\n");
          out.write("                                                <div class=\"cart_item_name cart_info_col\">\n");
          out.write("                                                    <div class=\"cart_item_title\">Tên</div>\n");
          out.write("                                                    <div class=\"cart_item_text\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${db.getProductNamefromProductMaterial(item.getProductWithMaterial().getProductWithMaterialID())}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</div>\n");
          out.write("                                                </div>\n");
          out.write("                                                <div class=\"cart_item_color cart_info_col\">\n");
          out.write("                                                    <div class=\"cart_item_title\">Chất liệu</div>\n");
          out.write("                                                    <div class=\"cart_item_text\"><span style=\"background-color:#999999;\"></span>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${db.getProductMaterialByID(item.getProductWithMaterial().getProductWithMaterialID()).getMaterial().getMaterialName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</div>\n");
          out.write("                                                </div>\n");
          out.write("                                                <div class=\"cart_item_quantity cart_info_col\">\n");
          out.write("                                                    <div class=\"cart_item_title\">Số lượng</div>\n");
          out.write("                                                    <div class=\"cart_item_text\">\n");
          out.write("                                                        <form action=\"Cart\" class=\"addToCart-form\" method=\"post\">\n");
          out.write("                                                            <div class=\"setQuantity\">\n");
          out.write("                                                                <div class=\"value-button decrease\" onclick=\"decreaseValue('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${myIndex.index}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("')\" value=\"Decrease Value\">-</div>\n");
          out.write("                                                                <input type=\"number\" class=\"number\" id=\"number");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${myIndex.index}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.getQuantity()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" name =\"quantity\"/>\n");
          out.write("                                                                <div class=\"value-button increase\" onclick=\"increaseValue('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${myIndex.index}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("')\" value=\"Increase Value\">+</div>\n");
          out.write("                                                            </div>\n");
          out.write("                                                            <div class=\"submit-btn\">\n");
          out.write("                                                                <input type=\"hidden\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.getProductWithMaterial().getProductWithMaterialID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" name=\"idProductMaterial\"/>\n");
          out.write("                                                                <input type=\"submit\" value=\"Cập nhật\">\n");
          out.write("                                                            </div>\n");
          out.write("                                                        </form>\n");
          out.write("                                                    </div>\n");
          out.write("                                                </div>\n");
          out.write("                                                <div class=\"cart_item_price cart_info_col\">\n");
          out.write("                                                    <div class=\"cart_item_title\">Giá</div>\n");
          out.write("                                                    <div class=\"cart_item_text\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.getProductWithMaterial().getProductPrice()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</div>\n");
          out.write("                                                </div>\n");
          out.write("                                                <div class=\"cart_item_total cart_info_col\">\n");
          out.write("                                                    <div class=\"cart_item_title\">Tổng giá</div>\n");
          out.write("                                                    <div class=\"cart_item_text\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.getSubTotal()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</div>\n");
          out.write("                                                </div>\n");
          out.write("                                            </div>\n");
          out.write("                                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
