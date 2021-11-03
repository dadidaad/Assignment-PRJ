package org.apache.jsp.app;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Store_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/./tlds/customtag_library.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_m_customTagUrl_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_url_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_m_customTagUrl_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_url_value_nobody.release();
    _jspx_tagPool_m_customTagUrl_nobody.release();
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
      out.write("  \n");
      out.write("    <!DOCTYPE html>\n");
      out.write("    <html>\n");
      out.write("        <head>\n");
      out.write("            <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("            <title>Store</title>\n");
      out.write("            <link href=\"./assets/img/favicon.png\" rel=\"icon\" />\n");
      out.write("            <link href=\"./assets/img/apple-touch-icon.png\" rel=\"apple-touch-icon\" />\n");
      out.write("\n");
      out.write("            <!-- Google Fonts -->\n");
      out.write("            <link\n");
      out.write("                href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i\"\n");
      out.write("                rel=\"stylesheet\"\n");
      out.write("                />\n");
      out.write("\n");
      out.write("            <!-- Vendor CSS Files -->\n");
      out.write("            <link href=\"assets/vendor/aos/aos.css\" rel=\"stylesheet\" />\n");
      out.write("            <link\n");
      out.write("                href=\"assets/vendor/bootstrap/css/bootstrap.min.css\"\n");
      out.write("                rel=\"stylesheet\"\n");
      out.write("                />\n");
      out.write("            <link\n");
      out.write("                href=\"assets/vendor/bootstrap-icons/bootstrap-icons.css\"\n");
      out.write("                rel=\"stylesheet\"\n");
      out.write("                />\n");
      out.write("            <link href=\"assets/vendor/boxicons/css/boxicons.min.css\" rel=\"stylesheet\" />\n");
      out.write("            <link\n");
      out.write("                href=\"assets/vendor/glightbox/css/glightbox.min.css\"\n");
      out.write("                rel=\"stylesheet\"\n");
      out.write("                />\n");
      out.write("            <link href=\"assets/vendor/remixicon/remixicon.css\" rel=\"stylesheet\" />\n");
      out.write("            <link href=\"assets/vendor/swiper/swiper-bundle.min.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("            <!-- Template Main CSS File -->\n");
      out.write("            <link rel=\"stylesheet\" charset='utf-8' type=\"text/css\" href=\"\n");
      out.write("                  ");
      if (_jspx_meth_c_url_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                      \" />\n");
      out.write("            ");
      dao.BrandDAO brand = null;
      synchronized (request) {
        brand = (dao.BrandDAO) _jspx_page_context.getAttribute("brand", PageContext.REQUEST_SCOPE);
        if (brand == null){
          brand = new dao.BrandDAO();
          _jspx_page_context.setAttribute("brand", brand, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("            </head>\n");
      out.write("\n");
      out.write("            <body>\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "app/header.jsp", out, false);
      out.write("\n");
      out.write("                <section\n");
      out.write("                    id=\"Store_hero\"\n");
      out.write("                    class=\"d-flex align-items-center justify-content-center\"\n");
      out.write("                    >\n");
      out.write("                    <div class=\"container\" data-aos=\"fade-up\">\n");
      out.write("                        <div\n");
      out.write("                            class=\"row justify-content-center\"\n");
      out.write("                            data-aos=\"fade-up\"\n");
      out.write("                            data-aos-delay=\"150\"\n");
      out.write("                            >\n");
      out.write("                            <div class=\"col-xl-10 col-lg-12\">\n");
      out.write("                                <h1 class=\"text-light text-center\">\n");
      out.write("                                    Các sản phẩm hiện có tại xưởng\n");
      out.write("                                </h1>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </section>\n");
      out.write("                <div class=\"Store-breadcrumb\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <nav aria-label=\"breadcrumb\">\n");
      out.write("                            <ol class=\"breadcrumb\">\n");
      out.write("                                <li class=\"breadcrumb-item\">\n");
      out.write("                                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Trang chủ</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"breadcrumb-item\"><a href=\"Store\">Sản phẩm</a></li>\n");
      out.write("                            <li class=\"breadcrumb-item active\" aria-current=\"#\">\n");
      out.write("                                ");
 String url = request.getQueryString();
      out.write("\n");
      out.write("                                ");
      if (_jspx_meth_m_customTagUrl_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            </li>\n");
      out.write("                        </ol>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <section id=\"Store-content\" class=\"container-fluid\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-xl-2 left-side\">\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Store\"\n");
      out.write("                           ><span>Sản phẩm</span> <i class=\"bi bi-chevron-down\"></i\n");
      out.write("                            ></a>\n");
      out.write("                        <button class=\"dropdown-btn\">\n");
      out.write("                            Xe ga\n");
      out.write("                            <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                        </button>\n");
      out.write("                        <div class=\"dropdown-container\">\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <button class=\"dropdown-btn\">\n");
      out.write("                            Xe số\n");
      out.write("                            <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                        </button>\n");
      out.write("                        <div class=\"dropdown-container\">\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xl-10\">\n");
      out.write("                        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Product", out, false);
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("            <!-- Vendor JS Files -->\n");
      out.write("            <script src=\"./assets/vendor/aos/aos.js\"></script>\n");
      out.write("            <script src=\"./assets/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("            <script src=\"./assets/vendor/glightbox/js/glightbox.min.js\"></script>\n");
      out.write("            <script src=\"./assets/vendor/isotope-layout/isotope.pkgd.min.js\"></script>\n");
      out.write("            <script src=\"./assets/vendor/php-email-form/validate.js\"></script>\n");
      out.write("            <script src=\"./assets/vendor/purecounter/purecounter.js\"></script>\n");
      out.write("            <script src=\"./assets/vendor/swiper/swiper-bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("            <!-- Template Main JS File -->\n");
      out.write("            <script src=\"./assets/js/main.js\"></script>\n");
      out.write("            <script>\n");
      out.write("                var dropdown = document.getElementsByClassName(\"dropdown-btn\");\n");
      out.write("                var i;\n");
      out.write("\n");
      out.write("                for (i = 0; i < dropdown.length; i++) {\n");
      out.write("                    dropdown[i].addEventListener(\"click\", function () {\n");
      out.write("                        this.classList.toggle(\"active1\");\n");
      out.write("                        var dropdownContent = this.nextElementSibling;\n");
      out.write("                        if (dropdownContent.style.display === \"flex\") {\n");
      out.write("                            dropdownContent.style.display = \"none\";\n");
      out.write("                        } else {\n");
      out.write("                            dropdownContent.style.display = \"flex\";\n");
      out.write("                            dropdownContent.style.flexDirection = \"column\";\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("        </body>\n");
      out.write("    </html>\n");
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

  private boolean _jspx_meth_m_customTagUrl_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  m:customTagUrl
    taglib.customTagUrl _jspx_th_m_customTagUrl_0 = (taglib.customTagUrl) _jspx_tagPool_m_customTagUrl_nobody.get(taglib.customTagUrl.class);
    _jspx_th_m_customTagUrl_0.setPageContext(_jspx_page_context);
    _jspx_th_m_customTagUrl_0.setParent(null);
    int _jspx_eval_m_customTagUrl_0 = _jspx_th_m_customTagUrl_0.doStartTag();
    if (_jspx_th_m_customTagUrl_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_m_customTagUrl_nobody.reuse(_jspx_th_m_customTagUrl_0);
      return true;
    }
    _jspx_tagPool_m_customTagUrl_nobody.reuse(_jspx_th_m_customTagUrl_0);
    return false;
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
          out.write("                                <a href=\"Store?Brand=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${br.getBrandID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${br.getBrandName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\n");
          out.write("                            ");
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
          out.write("                                <a href=\"Store?Brand=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${br.getBrandID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${br.getBrandName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\n");
          out.write("                            ");
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
}
