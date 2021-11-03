<%-- Document : header Created on : Oct 19, 2021, 9:31:17 PM Author : Admin --%>

<%@page import="model.Account" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!-- Template Main CSS File -->
        <jsp:useBean id="brand" class="dao.BrandDAO" scope="request"></jsp:useBean>
        </head>

        <body>
            <header id="header" class="fixed-top header-inner-pages">
                <div class="container d-flex align-items-center justify-content-lg-between">
                    <nav id="navbar" class="navbar order-last order-lg-0">
                        <ul>
                            <li><a class="nav-link scrollto" href="${pageContext.request.contextPath}">Trang
                                chủ</a></li>
                        <li class="dropdown"><a href="${pageContext.request.contextPath}/Store"><span>Sản phẩm</span> <i
                                    class="bi bi-chevron-down"></i></a>
                            <ul>
                                <li class="dropdown"><a href="Store?Category=1"><span>Xe ga</span> <i
                                            class="bi bi-chevron-right"></i></a>
                                    <ul>
                                        <c:forEach items="${brand.getBrandByCategory('1')}" var="br">
                                            <li><a href ="Store?Brand=${br.getBrandID()}">${br.getBrandName()}</a></li>
                                            </c:forEach>
                                    </ul>
                                </li>
                                <li class="dropdown"><a href="Store?Category=2"><span>Xe số</span> <i
                                            class="bi bi-chevron-right"></i></a>
                                    <ul>
                                        <c:forEach items="${brand.getBrandByCategory('2')}" var="br">
                                            <li><a href ="Store?Brand=${br.getBrandID()}">${br.getBrandName()}</a></li>
                                            </c:forEach>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li><a class="nav-link scrollto" href="${pageContext.request.contextPath}#about">Về
                                chúng tôi</a></li>
                        <li><a class="nav-link scrollto" href="${pageContext.request.contextPath}#services">Dịch
                                vụ</a></li>
                        <li><a class="nav-link scrollto" href="${pageContext.request.contextPath}#contact">Liên
                                hệ</a></li>
                    </ul>
                    <i class="bi bi-list mobile-nav-toggle"></i>
                </nav><!-- .navbar -->

                <div class="container d-flex align-items-center justify-content-end">
                    <% Account user = (Account) request.getSession().getAttribute("user");
                        if (user == null) {%>
                    <a href="#" class="get-started-btn scrollto"
                       onclick="document.getElementById('id01').style.display = 'block'"
                       style="margin-right:10px; ">Đăng nhập</a>
                    <a href="#" class="get-started-btn scrollto"
                       onclick="document.getElementById('id02').style.display = 'block'">Đăng ký</a>
                    <% } else {%>

                    <p class="text-success" style="font-size: 20px;font-weight: 500; padding-top: 15px; padding-right: 10px;"> Xin chào
                        <%=user.getUsername()%>
                    </p>
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Lựa chọn
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <% if(user.getRole().equalsIgnoreCase("customer")){%>
                                <a class="dropdown-item" href="History">Lịch sử mua hàng</a>
                            <%}%>
                            <% if(user.getRole().equalsIgnoreCase("admin")){%>
                                <a class="dropdown-item" href="Dashboard">Chỉnh sửa sản phẩm</a>
                            <%}%>
                            <a class="dropdown-item" href="Logout">Đăng xuất</a>
                        </div>
                    </div>
                    <%}%>
                </div>
                <div id="id01" class="modal">
                    <form class="modal-content animate" action="Login" method="post">
                        <div class="imgcontainer">
                            <span onclick="document.getElementById('id01').style.display = 'none'" class="close"
                                  title="Close Modal">&times;</span>
                        </div>

                        <div class="container">
                            <h3 class="modal-title">Đăng nhập</h3>
                            <label for="uname"><b>Tên đăng nhập</b></label>
                            <input type="text" placeholder="Nhập tên người dùng" name="uname" value="${requestScope.username}">
                            <label for="psw"><b>Mật khẩu</b></label>
                            <input type="password" placeholder="Nhập mật khẩu" name="psw" value="${requestScope.password}">
                            <input type="hidden" value="<%=request.getRequestURI()%>" name="currentUrl">
                            <button type="submit">Đăng nhập</button>
                            <label>
                                <input type="checkbox" name="remember"> Lưu đăng nhập
                            </label>
                            <p class="text-danger">${sessionScope.loginInvalid}</p>
                            <c:if test="${not empty loginInvalid}">
                                <script>document.getElementById('id01').style.display = 'block';</script>
                            </c:if>
                            <c:remove var="loginInvalid" scope="session" />
                        </div>
                        <div class="container" style="background-color:#f1f1f1">
                            <button type="button"
                                    onclick="document.getElementById('id01').style.display = 'none'"
                                    class="cancelbtn">Huỷ</button>
                        </div>
                    </form>
                </div>
                <div id="id02" class="modal">
                    <form class="modal-content animate" action="Register" method="post">
                        <div class="imgcontainer">
                            <span onclick="document.getElementById('id02').style.display = 'none'" class="close"
                                  title="Close Modal">&times;</span>
                        </div>

                        <div class="container">
                            <h3 class="modal-title">Đăng Ký</h3>
                            <p class="text-danger">${sessionScope.notiRegister}</p>
                            <c:if test="${not empty notiRegister}">
                                <script>document.getElementById('id02').style.display = 'block';</script>
                            </c:if>
                            <c:remove var="notiRegister" scope="session" />
                            <label for="uname"><b>Tên đăng nhập</b></label>
                            <input type="text" placeholder="Nhập tên người dùng" name="uname" required>
                            <label for="psw"><b>Mật khẩu</b></label>
                            <input type="password" id="password" placeholder="Nhập mật khẩu" name="password"
                                   onkeyup='check();' required>
                            <label for="psw"><b>Nhập lại Mật khẩu</b></label>
                            <input type="password" id="confirm_password" placeholder="Nhập lại mật khẩu"
                                   name="confirm_password" onkeyup='check();' required>
                            <span id='message'></span>
                            <button type="submit">Đăng ký</button>
                        </div>
                        <div class="container" style="background-color:#f1f1f1">
                            <button type="button"
                                    onclick="document.getElementById('id02').style.display = 'none'"
                                    class="cancelbtn">Huỷ</button>
                        </div>
                    </form>
                </div>
                <div class="modal" id="id03">
                    <div class="modal-content animate">
                        <div class="imgcontainer">
                            <span onclick="document.getElementById('id03').style.display = 'none'" class="close"
                                  title="Close Modal">&times;</span>
                        </div>
                        <div class="container">
                            <h3 class="text-capitalize text-center text-success">${sessionScope.setNotiRegister}</h3>
                        </div>
                    </div>
                </div>
                <c:if test="${not empty setNotiRegister}">
                    <script>document.getElementById('id03').style.display = 'block';</script>
                </c:if>
                <c:remove var="setNotiRegister" scope="session" />
            </div>
        </header>
        <!-- Vendor JS Files -->
        <!-- Template Main JS File -->
        <script src="../assets/js/main.js"></script>
        <script>
                        // Get the modal
                        var modalLogin = document.getElementById('id01');
                        var modelRegister = document.getElementById('id02');
                        // When the user clicks anywhere outside of the modal, close it
                        window.onclick = function (event) {
                            if (event.target == modalLogin) {
                                modalLogin.style.display = "none";
                            }
                        }
                        window.onclick = function (event) {
                            if (event.target == modelRegister) {
                                modalRegister.style.display = "none";
                            }
                        }

                        var check = function () {
                            if (document.getElementById('password').value ==
                                    document.getElementById('confirm_password').value) {
                                document.getElementById('message').style.color = 'green';
                                document.getElementById('message').innerHTML = 'matching';
                            } else {
                                document.getElementById('message').style.color = 'red';
                                document.getElementById('message').innerHTML = 'not matching';
                            }
                        }
        </script>
    </body>

</html>