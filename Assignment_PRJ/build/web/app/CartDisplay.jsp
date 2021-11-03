<%-- 
    Document   : CartDispaly
    Created on : Oct 31, 2021, 5:08:08 PM
    Author     : Admin
--%>

<%@page import="dao.ProductDAO"%>
<%@page import="model.ProductToCart"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <jsp:include page="app/header.jsp" ></jsp:include>
        <%ArrayList<ProductToCart> cartList = (ArrayList<ProductToCart>) request.getSession().getAttribute("cart");
            ProductDAO db = new ProductDAO();%>
        <div class="cart_section">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-10 offset-lg-1">
                        <div class="cart_container">
                            <div class="cart_title">Giỏ hàng <small>Có ${sessionScope.cartSize} sản phẩm trong giỏ hàng của bạn</small></div>
                            <div class="cart_items">
                                <ul class="cart_list">
                                    <li class="cart_item clearfix">
                                        <% for (ProductToCart x : cartList) {%>
                                        <div class="cart_item_image"><img src="<%=x.getProductWithMaterial().getImgSrc()%>" alt=""></div>
                                        <div class="cart_item_info d-flex flex-md-row flex-column justify-content-between">
                                            <div class="cart_item_name cart_info_col">
                                                <div class="cart_item_title">Tên</div>
                                                <div class="cart_item_text"><%=db.getProductNamefromProductMaterial(x.getProductWithMaterial().getProductWithMaterialID())%></div>
                                            </div>
                                            <div class="cart_item_color cart_info_col">
                                                <div class="cart_item_title">Chất liệu</div>
                                                <div class="cart_item_text"><%=db.getProductMaterialByID(x.getProductWithMaterial().getProductWithMaterialID()).getMaterial().getMaterialName()%></div>
                                            </div>
                                            <div class="cart_item_quantity cart_info_col">
                                                <div class="cart_item_title">Số lượng</div>
                                                <div class="cart_item_text">
                                                    <form action="Cart" class="addToCart-form" method="post">
                                                        <div class="setQuantity">
                                                            <div class="value-button decrease" onclick="decreaseValue('<%=cartList.indexOf(x)%>')" value="Decrease Value">-</div>
                                                            <input type="number" class="number" id="number<%=cartList.indexOf(x)%>" value="<%=x.getQuantity()%>" name ="quantity"/>
                                                            <div class="value-button increase" onclick="increaseValue('<%=cartList.indexOf(x)%>')" value="Increase Value">+</div>
                                                        </div>
                                                        <div class="submit-btn">
                                                            <input type="hidden" value="<%=x.getProductWithMaterial().getProductWithMaterialID()%>" name="idProductMaterial"/>
                                                            <input type="hidden" value="<%=request.getRequestURI()%>" name="currentUrl">
                                                            <input type="submit" value="Cập nhật">
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                            <div class="cart_item_price cart_info_col">
                                                <div class="cart_item_title">Giá</div>
                                                <div class="cart_item_text"><%=x.getProductWithMaterial().getProductPrice()%>VNĐ</div>
                                            </div>
                                            <div class="cart_item_total cart_info_col">
                                                <div class="cart_item_title">Tổng giá</div>
                                                <div class="cart_item_text"><%=x.getSubTotal()%>VNĐ</div>
                                            </div>
                                            <div class="cart_info_col cart_item_remove">
                                                <div class="cart_item_title"></div>
                                                <div class="cart_item_text"><a href="Cart?idItem=<%=cartList.indexOf(x)%>">Remove</a></div>
                                            </div>
                                        </div>
                                        <%}%>
                                    </li>
                                </ul>
                            </div>
                            <div class="order_total">
                                <div class="order_total_content text-md-right">
                                    <div class="order_total_title">Tổng giá:</div>
                                    <div class="order_total_amount">${sessionScope.totalPrice}VNĐ</div>
                                </div>
                            </div>
                            <div class="cart_buttons"> <button type="button" class="button cart_button_clear"><a href="Store">Tiếp tục mua sắm</a></button> <button type="button" class="button cart_button_checkout"><a href="BuyProduct">Xác nhận mua</a></button> </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Vendor JS Files -->
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
        <script>
            function increaseValue(index) {
                var value = parseInt(document.getElementById('number' + index).value, 10);
                value = isNaN(value) ? 0 : value;
                value++;
                document.getElementById('number' + index).value = value;
            }

            function decreaseValue(index) {
                var value = parseInt(document.getElementById('number' + index).value, 10);
                value = isNaN(value) ? 0 : value;
                value < 1 ? value = 1 : '';
                value--;
                document.getElementById('number' + index).value = value;
            }
        </script>
    </body>
</html>
