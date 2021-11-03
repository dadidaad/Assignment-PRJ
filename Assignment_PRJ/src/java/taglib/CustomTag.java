package taglib;

import dao.BrandDAO;
import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Admin
 */
public class CustomTag extends SimpleTagSupport {

    private String value;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        if (value.contains("&")) {
            value = value.substring(0, value.indexOf("&"));
        }
        BrandDAO db = new BrandDAO();
        if (value.contains("Category")) {
            String idCategory = value.substring(value.indexOf("=") + 1);
            value = db.getNameCategoryByID(idCategory);
            out.println("<li class=\"breadcrumb-item active\" aria-current=\"#\"><a href=\"Store?Category=" + idCategory + "\">" + value + "</a></li>");
        }
        if (value.contains("Brand")) {
            String idBrand = value.substring(value.indexOf("=") + 1);
            value = db.getNameBrandAndCategoryByID(idBrand);
            String[] splitValue = value.split("/");
            out.println("<li class=\"breadcrumb-item active\" aria-current=\"#\"><a href=\"Store?Category=" + splitValue[2] 
                    + "\">" + splitValue[1] + "</a></li><li class=\"breadcrumb-item active\" aria-current=\"#\"><a href=\"Store?Brand=" 
                    + idBrand + "\">" + splitValue[0] + "</a></li>");
        }

    }

    public void setValue(String value) {
        this.value = value;
    }

}
