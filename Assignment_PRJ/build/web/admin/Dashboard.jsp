<%-- 
    Document   : Dashboard
    Created on : Nov 1, 2021, 9:40:05 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
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
        <link rel="stylesheet" type="text/css" href="./assets/css/style.css"/>
        <jsp:useBean id="bDAO" class="dao.BrandDAO"></jsp:useBean>
        <jsp:useBean id="pDAO" class="dao.ProductDAO"></jsp:useBean>
        <jsp:useBean id="hbDAO" class="dao.HistoryBuyDAO"></jsp:useBean>
            <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        </head>
        <body>
            <script>
                jQuery(document).ready(function ($) {
                    $('.content-dashboard').hide();
                    $('a[href^="#"]').on('click', function (event) {
                        $('.content-dashboard').hide();
                        var target = $(this).attr('href');
                        $('.content-dashboard' + target).toggle();
                    });
                    if (window.location.hash) {
                        var hash = window.location.hash;
                        $('.content-dashboard').hide();
                        $(hash).show();
                    }

                    $(window).on('hashchange', function () {
                        var hash = window.location.hash;
                        $('.content-dashboard').hide();
                        $(hash).show();
                    });
                });
            </script>
        <jsp:include page="./app/header.jsp"></jsp:include>
            <div id="Dashboard-content" class="container">
                <div class="row">
                    <div class="col-xl-2 sidenav-dashboard">
                        <a href="#add">Th??m s???n ph???m</a>
                        <a href="#edit">S???a s???n ph???m</a>
                        <a href="#remove">Xo?? s???n ph???m</a>
                        <a href="#history">L???ch s??? giao d???ch</a>
                    </div>
                    <div class="col-xl-10 container" id ="content">
                        <div class="content-dashboard container" id="add">
                            <h3> Th??m s???n ph???m</h3>
                            <p class="text-success"><c:out value="${sessionScope.notiAdd}"></c:out></p>
                        <c:remove scope="session" var="notiAdd"></c:remove>
                        <form action="DashboardController" method="post" enctype="multipart/form-data">
                                <input type="hidden" value="add" name="choice">
                                <table>
                                    <tr>
                                        <td>T??n s???n ph???m</td>
                                        <td><input type="text" name="productName" required></td>
                                    </tr>
                                    <tr>
                                        <td>M?? t??? s???n ph???m</td>
                                        <td><input type="text" name="descriptionProduct" required</td>
                                    </tr>
                                    <tr>
                                        <td>H??ng</td>
                                        <td>
                                            <div id="brandOption">
                                                <select name="brandName">
                                                <option value="">L???a ch???n h??ng</option>
                                            <c:forEach items="${bDAO.allBrand}" var="item">
                                                <option value="${item.getBrandID()}">${item.getBrandName()}</option>
                                            </c:forEach>
                                                </select>   
                                            </div>
                                        </td>
                                        <td>
                                            <button type="button" class="btn btn-dark" onclick="loadAddBrand('addBrand')" id="btn-add">Th??m h??ng xe</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Ch???n ???nh</td>
                                        <td>
                                            <label for="imgAdd" class="btn btn-light">???????ng d???n ???nh</label>
                                            <input type="file" name="ProductImg" id="imgAdd" style="display: none;">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Gi?? ti???n</td>
                                        <td><input type="number" name="productPrice" required></td>
                                    </tr>
                                    <tr>
                                        <td>Ch???t li???u</td>
                                        <td>
                                            <select name="materialProduct">
                                                <option value="">L???a ch???n ch???t li???u</option>
                                                <c:forEach items="${bDAO.allMaterial}" var="item">
                                                    <option value="${item.getMaterialID()}">${item.getMaterialName()}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><input type="submit" value="X??c nh???n th??m"></td>
                                    </tr>
                                </table>
                            </form>
                    </div>
                    <div class="content-dashboard container"  id="edit">
                        <h3>S???a s???n ph???m</h3>
                        <p class="text-success"><c:out value="${sessionScope.notiUpdate}"></c:out></p>
                        <c:remove scope="session" var="notiUpdate"></c:remove>
                            <select name="choice" id="editChoice" onchange="loadEditTable(this.options[this.selectedIndex].value)">
                                <option value="">L???a ch???n s???n ph???m</option>
                            <c:forEach items="${pDAO.allProductWithMaterial}" var="product">
                                <option value="${product.getProductWithMaterialID()}">${product.getProductName()} ${product.getMaterial().getMaterialName()}</option>
                            </c:forEach>
                        </select>
                        <div id="editSuccess"></div>
                    </div>
                    <div id="remove" class="content-dashboard container" >
                        <h3>Xo?? s???n ph???m</h3>
                        <p class="text-success"><c:out value="${sessionScope.notiDelete}"></c:out></p>
                        <c:remove scope="session" var="notiDelete"></c:remove>
                            <table class="table-dashboard">
                                <tr>
                                    <td>T??n s???n ph???m</td>
                                    <td>H??nh ???nh</td>
                                    <td>Ch???t li???u</td>
                                    <td>Gi??</td>
                                    <td></td>
                                </tr>
                            <c:forEach items="${pDAO.allProductWithMaterial}" var="item">
                                <tr>
                                    <td>${item.getProductName()}</td>
                                    <td><img src="file?path=${item.getImageProduct()}" style="height:200px; width: 100px; object-fit: cover; object-position: center;"</td>
                                    <td>${item.getMaterial().getMaterialName()}</td>
                                    <td>${item.getProductPrice()}</td>
                                    <td>
                                        <form id="deleteForm" action="DashboardController" method="post" enctype="multipart/form-data">
                                            <input type="hidden" value="delete" name="choice">
                                            <input type="hidden" value="${item.getProductWithMaterialID()}" name="idProductWithMaterialDelete">
                                            <input type="hidden" value ="${item.getProductID()}" name ="idProductDelete">
                                            <input type="submit" value="Xo?? s???n ph???m" onclick="return deleteConfirm()">
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div class="content-dashboard container" id="history">
                        <h3>L???ch s??? mua h??ng</h3>
                        <c:if test="${hbDAO.recordOfItems eq 0}">
                            <p class="text-dark">Kh??ng c?? l???ch s??? mua h??ng</p>
                        </c:if>
                        <c:if test="${hbDAO.recordOfItems ne 0}">
                            <table class="table-dashboard">
                                <tr>
                                    <td>T??n ng?????i mua</td>
                                    <td>T??n s???n ph???m</td>
                                    <td>Ch???t li???u</td>
                                    <td>S??? l?????ng mua</td>
                                    <td>Th???i gian mua</td>
                                </tr>
                                <c:forEach items="${hbDAO.allItem}" var="item">
                                    <tr>
                                        <td>${item.getUsername()}</td>
                                        <td>${pDAO.getProductMaterialByID(item.getProductWithMaterialID()).getProductName()}</td>
                                        <td>${pDAO.getProductMaterialByID(item.getProductWithMaterialID()).getMaterial().getMaterialName()}</td>
                                        <td>${item.getQuantity()}</td>
                                        <td>${item.getDateBuy()}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <script src="./assets/vendor/aos/aos.js"></script>
        <script src="./assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="./assets/vendor/glightbox/js/glightbox.min.js"></script>
        <script src="./assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
        <script src="./assets/vendor/php-email-form/validate.js"></script>
        <script src="./assets/vendor/purecounter/purecounter.js"></script>
        <script src="./assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <!-- Template Main JS File -->
        <script src="./assets/js/main.js"></script>
        <script>
                                                function loadAddBrand(value) {
                                                    $.ajax({
                                                        url: "${pageContext.request.contextPath}/LoadData",
                                                        type: "get",
                                                        data: {"addBrand": value},
                                                        success: function (data) {
                                                            if ($('#brandOption').is(':empty')) {
                                                                $('#brandOption').append(data);
                                                                $('#btn-add').hide();
                                                            } else {
                                                                $('#brandOption').empty();
                                                                $('#brandOption').append(data);
                                                                $('#btn-add').hide();
                                                            }
                                                        },
                                                        error: function (xhr) {

                                                        }
                                                    });
                                                }
                                                 function loadEditTable(value) {
                                                    $.ajax({
                                                        url: "${pageContext.request.contextPath}/LoadData",
                                                        type: "get",
                                                        data: {"idProduct": value},
                                                        success: function (data) {
                                                            if ($('#editSuccess').is(':empty')) {
                                                                $('#editSuccess').append(data);
                                                            } else {
                                                                $('#editSuccess').empty();
                                                                $('#editSuccess').append(data);
                                                            }
                                                        },
                                                        error: function (xhr) {

                                                        }
                                                    });
                                                }
                                                function deleteConfirm() {
                                                    let result = confirm("B???n c?? mu???n xo?? s???n ph???m n??y?");
                                                    var formDelete = document.getElementById("deleteForm");
                                                    if (result) {
                                                        return formDelete.submit();
                                                    } else {
                                                        return false;
                                                    }
                                                }

        </script>
    </body>
</html>
