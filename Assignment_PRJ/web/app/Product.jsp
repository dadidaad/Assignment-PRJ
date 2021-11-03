<%-- 
    Document   : Product
    Created on : Oct 26, 2021, 8:24:49 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:useBean id="product" class="dao.ProductDAO" scope="request"></jsp:useBean>
        </head>
        <body>
        <c:set var="perPage" value ="${3}"/>
        <c:if test="${param.page eq null or param.page le 0}">
            <c:set var="currentPage" value ="${1}"/>
        </c:if>
        <c:if test="${param.page ne null}">
            <c:set var="currentPage" value = "${param.page}"/>
        </c:if>
        <c:choose>
            <c:when test ="${not empty param.Brand }">
                <c:set var="listProduct" value="${product.getProductByBrand(currentPage, perPage, param.Brand)}"/>
                <c:set var="totalRecord" value="${product.getNoOfRecordProductbyBrand(param.Brand)}"/>
                <c:set var="BrandID" value="${param.Brand}"/>
            </c:when>
            <c:when test ="${not empty param.Category}">
                <c:set var="listProduct" value="${product.getProductByCategory(currentPage, perPage, param.Category)}"/>
                <c:set var="totalRecord" value="${product.getNoOfRecordProductbyCategory(param.Category)}"/>
                <c:set var="CategoryID" value="${param.Category}"/>
            </c:when>
            <c:otherwise>
                <c:set var="listProduct" value="${product.getAllProducts(currentPage, perPage)}"/>
                <c:set var="totalRecord" value="${product.noOfRecordProduct}"/>
            </c:otherwise>
        </c:choose>
        <fmt:formatNumber value="${totalRecord / perPage + ((totalRecord / perPage) % 1 == 0 ? 0 : 0.5)}" 
                          type="number" pattern="#" var="ceilTotalPage"/>
        <c:set var="pageSize" value="${ceilTotalPage}"/>
        <div class="product-list">
            <c:forEach items="${listProduct}" var="productItem" varStatus="myIndex">
                <div class="product-item">
                    <div class="product-content">
                        <div class="product-top">
                            <a href="">${productItem.getProductName()}</a>
                        </div>
                        <div class="product-bottom">
                            <p class="product-description">${productItem.getDescription()}</p>
                            <div class="product-option">
                                <select name="select-option" class="selectItem" onchange="update(this.options[this.selectedIndex].value, '${myIndex.index}')">
                                    <c:forEach items="${product.getProductWithMaterial(productItem)}" var="productWithMaterial" varStatus="loop">
                                        <option value = "${productWithMaterial.getProductPrice()},${productWithMaterial.getImgSrc()},${productWithMaterial.getProductWithMaterialID()}">${productWithMaterial.getMaterial().getMaterialName()}</option>
                                    </c:forEach>
                                </select>
                                <p id="ProductPrice${myIndex.index}" class="product-price">${product.getProductWithMaterial(productItem)[0].productPrice}</p>
                            </div>
                            <div class ="addToCart-btn" id="addtoCart${myIndex.index}" onclick="insertQuantity('${myIndex.index}')" >Thêm vào giỏ hàng</div>
                            <div id ="insertForm${myIndex.index}" style="display:none;">
                                <form action="Cart" class="addToCart-form" method="post">
                                    <div class="setQuantity">
                                        <div class="value-button decrease" onclick="decreaseValue('${myIndex.index}')" value="Decrease Value">-</div>
                                        <input type="number" class="number" id="number${myIndex.index}" value="0" name ="quantity"/>
                                        <div class="value-button increase" onclick="increaseValue('${myIndex.index}')" value="Increase Value">+</div>
                                    </div>
                                    <div class="submit-btn">
                                        <input type="hidden" value="${product.getProductWithMaterial(productItem)[0].productWithMaterialID}" id="addToCartProduct${myIndex.index}" name="idProductMaterial"/>
                                        <input type="hidden" value="<%=request.getRequestURI()%>" name="currentUrl">
                                        <input type="submit" value="Đặt hàng">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="product-img">
                        <img id ="img${myIndex.index}" src="${product.getProductWithMaterial(productItem)[0].imgSrc}" alt="">
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="pagination">
            <c:if test="${currentPage ne 1}">
                <c:choose>
                    <c:when test="${not empty BrandID}">
                        <a href="?Brand=${BrandID}&page=${currentPage - 1}">Previous</a>
                    </c:when>
                    <c:when test="${not empty CategoryID}">
                        <a href="?Category=${CategoryID}&page=${currentPage - 1}">Previous</a>
                    </c:when>
                    <c:otherwise>
                        <a href="?page=${currentPage - 1}">Previous</a>
                    </c:otherwise>
                </c:choose>
            </c:if>
            <c:forEach begin="1" end="${pageSize}" varStatus="loop">
                <c:choose>
                    <c:when test="${currentPage eq loop.count}">
                        <c:choose>
                            <c:when test="${not empty BrandID}">
                                <a href="?Brand=${BrandID}&page=${loop.count}">${loop.count}</a>
                            </c:when>
                            <c:when test="${not empty CategoryID}">
                                <a href="?Category=${CategoryID}&page=${loop.count}">${loop.count}</a>
                            </c:when>
                            <c:otherwise>
                                <a href = "?page=${loop.count}">${loop.count}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${not empty BrandID}">
                                <a href="?Brand=${BrandID}&page=${loop.count}">${loop.count}</a>
                            </c:when>
                            <c:when test="${not empty CategoryID}">
                                <a href="?Category=${CategoryID}&page=${loop.count}">${loop.count}</a>
                            </c:when>
                            <c:otherwise>
                                <a href = "?page=${loop.count}">${loop.count}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage lt pageSize}">
                <c:choose>
                    <c:when test="${not empty BrandID}">
                        <a href="?Brand=${BrandID}&page=${currentPage + 1}">Next</a>
                    </c:when>
                    <c:when test="${not empty CategoryID}">
                        <a href="?Category=${CategoryID}&page=${currentPage + 1}">Next</a>
                    </c:when>
                    <c:otherwise>
                        <a href="?page=${currentPage + 1}">Next</a>
                    </c:otherwise>
                </c:choose>
            </c:if>
        </div>
        <script>
            function update(value, index) {
                var splitValue = value.split(',');
                var productPrice = document.getElementById('ProductPrice' + index);
                productPrice.innerHTML = splitValue[0];
                document.getElementById('img' + index).src = splitValue[1];
                document.getElementById('addToCartProduct' + index).value = splitValue[2];
            }
            function insertQuantity(indexValue) {
                var addToCartBtn = document.getElementById('addtoCart' + indexValue);
                if (addToCartBtn.style.display !== "none") {
                    addToCartBtn.style.display = "none";
                    document.getElementById('insertForm' + indexValue).style.display = "flex";
                    document.getElementById('inserForm' + indexValue).style.justifyContent = "space-around";
                } else {
                    addToCartBtn.style.display = "inline-block";
                    document.getElementById('insertForm' + indexValue).style.display = "none";
                }
            }
            function increaseValue(index) {
                var value = parseInt(document.getElementById('number' +index).value, 10);
                value = isNaN(value) ? 0 : value;
                value++;
                document.getElementById('number'+index).value = value;
            }

            function decreaseValue(index) {
                var value = parseInt(document.getElementById('number' +index).value, 10);
                value = isNaN(value) ? 0 : value;
                value < 1 ? value = 1 : '';
                value--;
                document.getElementById('number' +index).value = value;
            }
            update();
        </script>
    </body>
</html>
