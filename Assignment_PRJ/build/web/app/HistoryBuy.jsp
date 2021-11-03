<%-- 
    Document   : HistoryBuy
    Created on : Oct 31, 2021, 11:11:19 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Account"%>
<%@page import="model.ItemHistoryBuy"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDAO"%>
<%@page import="dao.HistoryBuyDAO"%>
<%@page import="model.ProductToCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./assets/img/favicon.png" rel="icon" />
        <link href="./assets/img/apple-touch-icon.png" rel="apple-touch-icon" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">

        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet"
            />

        <!-- Vendor CSS Files -->
        <link href="./assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="./assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="./assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="./assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="./assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="./assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="./assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
        <!-- Template Main CSS File -->
        <link rel="stylesheet" charset='utf-8' type="text/css" href="
              <c:url value="./assets/css/style.css"></c:url>
                  " />
        </head>
        <body>
        <% HistoryBuyDAO hbDAO = new HistoryBuyDAO();
            ProductDAO pDAO = new ProductDAO();
            Account user = (Account) request.getSession().getAttribute("user");
            ArrayList<ItemHistoryBuy> listItem = hbDAO.getItemByUsername(user.getUsername());
        %>
        <jsp:include page="app/header.jsp"></jsp:include>
            <div class="container-fluid">
                <section
                    id="Store_hero"
                    class="d-flex align-items-center justify-content-center"
                    >
                    <div class="container" data-aos="fade-up">
                        <div
                            class="row justify-content-center"
                            data-aos="fade-up"
                            data-aos-delay="150"
                            >
                            <div class="col-xl-10 col-lg-12">
                                <h1 class="text-light text-center">
                                    Lịch sử mua hàng
                                </h1>
                            </div>
                        </div>
                    </div>
                </section>
                <div class="container">
                    <table id="customers">
                        <tr>
                            <td>Tên sản phẩm</td>
                            <td>Chất liệu</td>
                            <td>Số lượng mua</td>
                            <td>Thời gian mua</td>
                        </tr>
                    <%for (ItemHistoryBuy x : listItem) {%>
                    <tr>
                        <td><%=pDAO.getProductNamefromProductMaterial(x.getProductWithMaterialID())%></td>
                        <td><%=pDAO.getProductMaterialByID(x.getProductWithMaterialID()).getMaterial().getMaterialName()%></td>
                        <td><%=x.getQuantity()%></td>
                        <td><%=x.getDateBuy()%></td>
                    </tr>
                    <%}%>
                </table>
            </div>
        </div>
        <script src="./assets/vendor/aos/aos.js"></script>
        <script src="./assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="./assets/vendor/glightbox/js/glightbox.min.js"></script>
        <script src="./assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
        <script src="./assets/vendor/php-email-form/validate.js"></script>
        <script src="./assets/vendor/purecounter/purecounter.js"></script>
        <script src="./assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <!-- Template Main JS File -->
        <script src="./assets/js/main.js"></script>
    </body>
</html>
