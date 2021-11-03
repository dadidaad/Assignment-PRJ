package org.apache.jsp.app;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Account;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_remove_var_scope_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_remove_var_scope_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_remove_var_scope_nobody.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("\n");
      out.write("        <!-- Favicons -->\n");
      out.write("        <link href=\"../assets/img/favicon.png\" rel=\"icon\">\n");
      out.write("        <link href=\"../assets/img/apple-touch-icon.png\" rel=\"apple-touch-icon\">\n");
      out.write("\n");
      out.write("        <!-- Google Fonts -->\n");
      out.write("        <link\n");
      out.write("            href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i\"\n");
      out.write("            rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Vendor CSS Files -->\n");
      out.write("        <link href=\"../assets/vendor/aos/aos.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"../assets/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"../assets/vendor/bootstrap-icons/bootstrap-icons.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"../assets/vendor/boxicons/css/boxicons.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"../assets/vendor/glightbox/css/glightbox.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"../assets/vendor/remixicon/remixicon.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"../assets/vendor/swiper/swiper-bundle.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Template Main CSS File -->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../assets/css/style.css\"/>\n");
      out.write("        <!-- Template Main CSS File -->\n");
      out.write("        ");
      dao.BrandDAO brand = null;
      synchronized (request) {
        brand = (dao.BrandDAO) _jspx_page_context.getAttribute("brand", PageContext.REQUEST_SCOPE);
        if (brand == null){
          brand = new dao.BrandDAO();
          _jspx_page_context.setAttribute("brand", brand, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        </head>\n");
      out.write("\n");
      out.write("        <body>\n");
      out.write("            <header id=\"header\" class=\"fixed-top header-inner-pages\">\n");
      out.write("                <div class=\"container d-flex align-items-center justify-content-lg-between\">\n");
      out.write("                    <nav id=\"navbar\" class=\"navbar order-last order-lg-0\">\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a class=\"nav-link scrollto active\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Trang\n");
      out.write("                                chủ</a></li>\n");
      out.write("                        <li class=\"dropdown\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Store\"><span>Sản phẩm</span> <i\n");
      out.write("                                    class=\"bi bi-chevron-down\"></i></a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li class=\"dropdown\"><a href=\"Store?Category=1\"><span>Xe ga</span> <i\n");
      out.write("                                            class=\"bi bi-chevron-right\"></i></a>\n");
      out.write("                                    <ul>\n");
      out.write("                                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"dropdown\"><a href=\"Store?Category=2\"><span>Xe số</span> <i\n");
      out.write("                                            class=\"bi bi-chevron-right\"></i></a>\n");
      out.write("                                    <ul>\n");
      out.write("                                        ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li><a class=\"nav-link scrollto\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("#about\">Về\n");
      out.write("                                chúng tôi</a></li>\n");
      out.write("                        <li><a class=\"nav-link scrollto\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("#services\">Dịch\n");
      out.write("                                vụ</a></li>\n");
      out.write("                        <li><a class=\"nav-link scrollto\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("#contact\">Liên\n");
      out.write("                                hệ</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <i class=\"bi bi-list mobile-nav-toggle\"></i>\n");
      out.write("                </nav><!-- .navbar -->\n");
      out.write("\n");
      out.write("                <div class=\"container d-flex align-items-center justify-content-end\">\n");
      out.write("                    ");
 Account username = (Account) request.getSession().getAttribute("user");
                        if (username == null) {
      out.write("\n");
      out.write("                    <a href=\"#about\" class=\"get-started-btn scrollto\"\n");
      out.write("                       onclick=\"document.getElementById('id01').style.display = 'block'\"\n");
      out.write("                       style=\"margin-right:10px; \">Đăng nhập</a>\n");
      out.write("                    <a href=\"#about\" class=\"get-started-btn scrollto\"\n");
      out.write("                       onclick=\"document.getElementById('id02').style.display = 'block'\">Đăng ký</a>\n");
      out.write("                    ");
 } else {
      out.write("\n");
      out.write("\n");
      out.write("                    <p class=\"text-success\" style=\"font-size: 20px;font-weight: 500;\"> Xin chào\n");
      out.write("                        ");
      out.print(username.getUsername());
      out.write("<a href=\"Logout\"\n");
      out.write("                           class=\"get-started-btn scrollto\">Đăng xuất</a>\n");
      out.write("                    </p>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div id=\"id01\" class=\"modal\">\n");
      out.write("                    <form class=\"modal-content animate\" action=\"Login\" method=\"post\">\n");
      out.write("                        <div class=\"imgcontainer\">\n");
      out.write("                            <span onclick=\"document.getElementById('id01').style.display = 'none'\" class=\"close\"\n");
      out.write("                                  title=\"Close Modal\">&times;</span>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"container\">\n");
      out.write("                            <h3 class=\"modal-title\">Đăng nhập</h3>\n");
      out.write("                            <label for=\"uname\"><b>Tên đăng nhập</b></label>\n");
      out.write("                            <input type=\"text\" placeholder=\"Nhập tên người dùng\" name=\"uname\">\n");
      out.write("                            <label for=\"psw\"><b>Mật khẩu</b></label>\n");
      out.write("                            <input type=\"password\" placeholder=\"Nhập mật khẩu\" name=\"psw\">\n");
      out.write("                            <button type=\"submit\">Đăng nhập</button>\n");
      out.write("                            <label>\n");
      out.write("                                <input type=\"checkbox\" name=\"remember\"> Lưu đăng nhập\n");
      out.write("                            </label>\n");
      out.write("                            <p class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.loginInvalid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            ");
      if (_jspx_meth_c_remove_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"container\" style=\"background-color:#f1f1f1\">\n");
      out.write("                            <button type=\"button\"\n");
      out.write("                                    onclick=\"document.getElementById('id01').style.display = 'none'\"\n");
      out.write("                                    class=\"cancelbtn\">Huỷ</button>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"id02\" class=\"modal\">\n");
      out.write("                    <form class=\"modal-content animate\" action=\"Register\" method=\"post\">\n");
      out.write("                        <div class=\"imgcontainer\">\n");
      out.write("                            <span onclick=\"document.getElementById('id02').style.display = 'none'\" class=\"close\"\n");
      out.write("                                  title=\"Close Modal\">&times;</span>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"container\">\n");
      out.write("                            <h3 class=\"modal-title\">Đăng Ký</h3>\n");
      out.write("                            <p class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.notiRegister}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                            ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            ");
      if (_jspx_meth_c_remove_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            <label for=\"uname\"><b>Tên đăng nhập</b></label>\n");
      out.write("                            <input type=\"text\" placeholder=\"Nhập tên người dùng\" name=\"uname\" required>\n");
      out.write("                            <label for=\"psw\"><b>Mật khẩu</b></label>\n");
      out.write("                            <input type=\"password\" id=\"password\" placeholder=\"Nhập mật khẩu\" name=\"password\"\n");
      out.write("                                   onkeyup='check();' required>\n");
      out.write("                            <label for=\"psw\"><b>Nhập lại Mật khẩu</b></label>\n");
      out.write("                            <input type=\"password\" id=\"confirm_password\" placeholder=\"Nhập lại mật khẩu\"\n");
      out.write("                                   name=\"confirm_password\" onkeyup='check();' required>\n");
      out.write("                            <span id='message'></span>\n");
      out.write("                            <button type=\"submit\">Đăng ký</button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"container\" style=\"background-color:#f1f1f1\">\n");
      out.write("                            <button type=\"button\"\n");
      out.write("                                    onclick=\"document.getElementById('id02').style.display = 'none'\"\n");
      out.write("                                    class=\"cancelbtn\">Huỷ</button>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal\" id=\"id03\">\n");
      out.write("                    <div class=\"modal-content animate\">\n");
      out.write("                        <div class=\"imgcontainer\">\n");
      out.write("                            <span onclick=\"document.getElementById('id03').style.display = 'none'\" class=\"close\"\n");
      out.write("                                  title=\"Close Modal\">&times;</span>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"container\">\n");
      out.write("                            <h3 class=\"text-capitalize text-center text-success\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.setNotiRegister}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_c_remove_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <!-- Vendor JS Files -->\n");
      out.write("        <script src=\"../assets/vendor/aos/aos.js\"></script>\n");
      out.write("        <script src=\"../assets/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <script src=\"../assets/vendor/glightbox/js/glightbox.min.js\"></script>\n");
      out.write("        <script src=\"../assets/vendor/isotope-layout/isotope.pkgd.min.js\"></script>\n");
      out.write("        <script src=\"../assets/vendor/php-email-form/validate.js\"></script>\n");
      out.write("        <script src=\"../assets/vendor/purecounter/purecounter.js\"></script>\n");
      out.write("        <script src=\"../assets/vendor/swiper/swiper-bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Template Main JS File -->\n");
      out.write("        <script src=\"../assets/js/main.js\"></script>\n");
      out.write("        <script>\n");
      out.write("                        // Get the modal\n");
      out.write("                        var modalLogin = document.getElementById('id01');\n");
      out.write("                        var modelRegister = document.getElementById('id02');\n");
      out.write("                        // When the user clicks anywhere outside of the modal, close it\n");
      out.write("                        window.onclick = function (event) {\n");
      out.write("                            if (event.target == modalLogin) {\n");
      out.write("                                modalLogin.style.display = \"none\";\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                        window.onclick = function (event) {\n");
      out.write("                            if (event.target == modelRegister) {\n");
      out.write("                                modalRegister.style.display = \"none\";\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                        var check = function () {\n");
      out.write("                            if (document.getElementById('password').value ==\n");
      out.write("                                    document.getElementById('confirm_password').value) {\n");
      out.write("                                document.getElementById('message').style.color = 'green';\n");
      out.write("                                document.getElementById('message').innerHTML = 'matching';\n");
      out.write("                            } else {\n");
      out.write("                                document.getElementById('message').style.color = 'red';\n");
      out.write("                                document.getElementById('message').innerHTML = 'not matching';\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${brand.getBrandByCategory('1')}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("br");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                            <li><a href =\"Store?Brand=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${br.getBrandID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${br.getBrandName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></li>\n");
          out.write("                                            ");
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
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${brand.getBrandByCategory('2')}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("br");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                            <li><a href =\"Store?Brand=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${br.getBrandID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${br.getBrandName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></li>\n");
          out.write("                                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty loginInvalid}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                <script>document.getElementById('id01').style.display = 'block';</script>\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_remove_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_remove_0 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _jspx_tagPool_c_remove_var_scope_nobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    _jspx_th_c_remove_0.setPageContext(_jspx_page_context);
    _jspx_th_c_remove_0.setParent(null);
    _jspx_th_c_remove_0.setVar("loginInvalid");
    _jspx_th_c_remove_0.setScope("session");
    int _jspx_eval_c_remove_0 = _jspx_th_c_remove_0.doStartTag();
    if (_jspx_th_c_remove_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_remove_var_scope_nobody.reuse(_jspx_th_c_remove_0);
      return true;
    }
    _jspx_tagPool_c_remove_var_scope_nobody.reuse(_jspx_th_c_remove_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty notiRegister}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                <script>document.getElementById('id02').style.display = 'block';</script>\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_remove_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_remove_1 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _jspx_tagPool_c_remove_var_scope_nobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    _jspx_th_c_remove_1.setPageContext(_jspx_page_context);
    _jspx_th_c_remove_1.setParent(null);
    _jspx_th_c_remove_1.setVar("notiRegister");
    _jspx_th_c_remove_1.setScope("session");
    int _jspx_eval_c_remove_1 = _jspx_th_c_remove_1.doStartTag();
    if (_jspx_th_c_remove_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_remove_var_scope_nobody.reuse(_jspx_th_c_remove_1);
      return true;
    }
    _jspx_tagPool_c_remove_var_scope_nobody.reuse(_jspx_th_c_remove_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty setNotiRegister}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <script>document.getElementById('id03').style.display = 'block';</script>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_remove_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_remove_2 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _jspx_tagPool_c_remove_var_scope_nobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    _jspx_th_c_remove_2.setPageContext(_jspx_page_context);
    _jspx_th_c_remove_2.setParent(null);
    _jspx_th_c_remove_2.setVar("setNotiRegister");
    _jspx_th_c_remove_2.setScope("session");
    int _jspx_eval_c_remove_2 = _jspx_th_c_remove_2.doStartTag();
    if (_jspx_th_c_remove_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_remove_var_scope_nobody.reuse(_jspx_th_c_remove_2);
      return true;
    }
    _jspx_tagPool_c_remove_var_scope_nobody.reuse(_jspx_th_c_remove_2);
    return false;
  }
}
