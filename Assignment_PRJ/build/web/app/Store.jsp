<%-- Document : Store Created on : Oct 19, 2021, 9:27:24 PM Author : Admin --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/tlds/custom_tag" prefix="m" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Store</title>
        <link href="./assets/img/favicon.png" rel="icon" />
        <link href="./assets/img/apple-touch-icon.png" rel="apple-touch-icon" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
              integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
              crossorigin="anonymous">

        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet" />

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
              <c:url value=" ./assets/css/style.css">
              </c:url>"/>
        <jsp:useBean id="brand" class="dao.BrandDAO" scope="request"></jsp:useBean>
        <jsp:useBean id="product" class="dao.ProductDAO" scope="request"></jsp:useBean>
        </head>

        <body>
        <jsp:include page="app/header.jsp"></jsp:include>
            <section id="Store_hero" class="d-flex align-items-center justify-content-center">
                <div class="container" data-aos="fade-up">
                    <div class="row justify-content-center" data-aos="fade-up" data-aos-delay="150">
                        <div class="col-xl-10 col-lg-12">
                            <h1 class="text-light text-center">
                                Các sản phẩm hiện có tại xưởng
                            </h1>
                        </div>
                    </div>
                </div>
            </section>
            <div class="Store-breadcrumb">
                <div class="container">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">
                                <a href="${pageContext.request.contextPath}">Trang chủ</a>
                        </li>
                        <li class="breadcrumb-item"><a href="Store">Sản phẩm</a></li>
                            <% String url = request.getQueryString();%>
                            <% if (url != null) {%>
                            <m:CustomTag value="<%=url%>"></m:CustomTag>
                            <%}%>
                    </ol>
                </nav>
            </div>
        </div>
        <section id="Store-content" class="container-fluid">
            <div class="row">
                <div class="col-xl-2 left-side">
                    <div class="left-side-top">
                        <a href="${pageContext.request.contextPath}/Store"><span>Sản phẩm</span> <i
                                class="bi bi-chevron-down"></i></a>
                        <button class="dropdown-btn">
                            Xe ga
                            <i class="fa fa-caret-down"></i>
                        </button>
                        <div class="dropdown-container">
                            <c:forEach items="${brand.getBrandByCategory('1')}" var="br">
                                <a href="Store?Brand=${br.getBrandID()}">${br.getBrandName()}</a>
                            </c:forEach>
                        </div>
                        <button class="dropdown-btn">
                            Xe số
                            <i class="fa fa-caret-down"></i>
                        </button>
                        <div class="dropdown-container">
                            <c:forEach items="${brand.getBrandByCategory('2')}" var="br">
                                <a href="Store?Brand=${br.getBrandID()}">${br.getBrandName()}</a>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="left-side-bottom">
                        <c:set var="productHot" value="${product.hottestProduct}"></c:set>
                            <div class="product-item">
                                <div class="product-content">
                                    <div class="product-top">
                                        <a href="">${productHot.getProductName()}</a>
                                    </div>
                                    <div class="product-bottom">
                                        <p class="product-description">${productHot.getDescription()}</p>
                                        <div class="product-option">
                                            <p>${productHot.getMaterial().getMaterialName()}</p>
                                            <p class="product-price">${productHot.getProductPrice()}</p>
                                        </div>
                                        <div class="addToCart-btn" id="addtoCartHot"
                                             onclick="insertQuantityHot()">Thêm vào giỏ hàng
                                        </div>
                                        <div id="insertFormHot" style="display:none;">
                                            <form action="Cart" class="addToCart-form" method="post">
                                                <div class="setQuantity">
                                                    <div class="value-button decrease" onclick="decreaseValueHot()"
                                                         value="Decrease Value">-</div>
                                                    <input type="number" class="number" id="numberHot" value="0"
                                                           name="quantity" />
                                                    <div class="value-button increase" onclick="increaseValueHot()"
                                                         value="Increase Value">+</div>
                                                </div>
                                                <div class="submit-btn">
                                                    <input type="hidden"
                                                           value="${productHot.getProductWithMaterialID()}"
                                                           id="addToCartProductHot" name="idProductMaterial" />
                                                    <input type="hidden" value="<%=request.getRequestURI()%>"
                                                           name="currentUrl">
                                                    <input type="submit" value="Đặt hàng">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="product-img">
                                    <img src="data:image/jpg;base64,${productHot.getBase64Image()}" alt="">
                                </div>
                                <div class="product-title">
                                    <h3>Sản phẩm hot</h3>
                                </div>
                            </div>
                    </div>
                </div>
                <div class=" col-xl-10">
                    <jsp:include page="Product"></jsp:include>
                </div>
            </div>
            <c:if test="${sessionScope.cart ne null}">
                <a href="Cart" id="cart">
                    <span class="fa-stack fa has-badge" data-count="${sessionScope.cartSize}">
                        <i class="fa fa-circle fa-stack fa-inverse"></i>
                        <i style="" class="fa fa-shopping-cart fa-stack-2x red-cart"></i>
                    </span>
                </a>
            </c:if>
            <div class="modal" id="id04">
                <div class="modal-content animate">
                    <div class="imgcontainer">
                        <span onclick="document.getElementById('id04').style.display = 'none'"
                              class="close" title="Close Modal">&times;</span>
                    </div>
                    <div class="container">
                        <h3 class="text-capitalize text-center text-success">
                            ${sessionScope.notiBuy}</h3>
                    </div>
                </div>
            </div>
            <c:if test="${not empty notiBuy}">
                <script>document.getElementById('id04').style.display = 'block';</script>
            </c:if>
            <c:remove var="notiBuy" scope="session" />
        </section>
        <!-- Vendor JS Files -->
        <script src="./assets/vendor/aos/aos.js"></script>
        <script src="./assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="./assets/vendor/glightbox/js/glightbox.min.js"></script>
        <script src="./assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
        <script src="./assets/vendor/php-email-form/validate.js"></script>
        <script src="./assets/vendor/purecounter/purecounter.js"></script>
        <script src="./assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
                integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
                integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
        <!-- Template Main JS File -->
        <script src="./assets/js/main.js"></script>
        <script>
                    var dropdown = document.getElementsByClassName("dropdown-btn");
                    var i;

                    for (i = 0; i < dropdown.length; i++) {
                        dropdown[i].addEventListener("click", function () {
                            this.classList.toggle("active1");
                            var dropdownContent = this.nextElementSibling;
                            if (dropdownContent.style.display === "flex") {
                                dropdownContent.style.display = "none";
                            } else {
                                dropdownContent.style.display = "flex";
                                dropdownContent.style.flexDirection = "column";
                            }
                        });
                    }
        </script>
        <script>
            function insertQuantityHot() {
                var addToCartBtn = document.getElementById('addtoCartHot');
                if (addToCartBtn.style.display !== "none") {
                    addToCartBtn.style.display = "none";
                    document.getElementById('insertFormHot').style.display = "flex";
                    document.getElementById('inserFormHot').style.justifyContent = "space-around";
                } else {
                    addToCartBtn.style.display = "inline-block";
                    document.getElementById('insertFormHot').style.display = "none";
                }
            }
            function increaseValueHot() {
                var value = parseInt(document.getElementById('numberHot').value, 10);
                value = isNaN(value) ? 0 : value;
                value++;
                document.getElementById('numberHot').value = value;
            }

            function decreaseValueHot() {
                var value = parseInt(document.getElementById('numberHot').value, 10);
                value = isNaN(value) ? 0 : value;
                value < 1 ? value = 1 : '';
                value--;
                document.getElementById('numberHot').value = value;
            }
        </script>
    </body>

</html>