<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
    <div class="layout-wrapper layout-content-navbar">
        <div class="layout-container">

            <jsp:include page="/adminPage/header.jsp" />

            <div class="layout-page">

                <nav
                    class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
                    id="layout-navbar">
                </nav>

                <div class="p-2">
                    <h1>Sửa thông tin sản phẩm</h1>
                </div>

                <div style="padding: 0px 30px;">

                    <form action="product?action=editsubmit" method="post">

                        <!-- ID ẩn -->
                        <input type="hidden" name="id" value="${product.productId}">

                        <div class="pb-3">
                            <label class="form-label">Nhà cung cấp</label>
                            <input value="${product.providerId}" name="providerId" type="number" 
                                   class="form-control" placeholder="ID nhà cung cấp">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Danh mục</label>
                            <input value="${product.categoryId}" name="categoryId" type="number" 
                                   class="form-control" placeholder="ID danh mục">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Tên sản phẩm</label>
                            <input value="${product.name}" name="name" type="text" class="form-control" 
                                   placeholder="Tên sản phẩm">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Alias</label>
                            <input value="${product.alias}" name="alias" type="text" 
                                   class="form-control" placeholder="Alias">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Thương hiệu</label>
                            <input value="${product.brands}" name="brands" type="text" 
                                   class="form-control" placeholder="Brand">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Chất liệu</label>
                            <input value="${product.material}" name="material" type="text" 
                                   class="form-control" placeholder="Material">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Kích thước</label>
                            <input value="${product.dimensions}" name="dimensions" type="text" 
                                   class="form-control" placeholder="Dimensions">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Mô tả</label>
                            <textarea name="description" class="form-control" rows="2">${product.description}</textarea>
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Chi tiết</label>
                            <textarea name="detail" class="form-control" rows="3">${product.detail}</textarea>
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Ảnh</label>
                            <input value="${product.image}" name="image" type="text" 
                                   class="form-control" placeholder="Link ảnh">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Giá</label>
                            <input value="${product.price}" name="price" type="number" step="0.01" 
                                   class="form-control" placeholder="Giá">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Giá sale</label>
                            <input value="${product.priceSale}" name="priceSale" type="number" step="0.01" 
                                   class="form-control" placeholder="Giá sale">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Số lượng</label>
                            <input value="${product.quantity}" name="quantity" type="number" 
                                   class="form-control">
                        </div>


                        <!-- isBestSeller -->
                        <div class="pb-3">
                            <label class="form-label">Bán chạy</label>
                            <select name="isBestSeller" class="form-select">
                                <c:choose>
                                    <c:when test="${product.bestSeller}">
                                        <option value="true">Có</option>
                                        <option value="false">Không</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="false">Không</option>
                                        <option value="true">Có</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </div>

                        <!-- isActive -->
                        <div class="pb-3">
                            <label class="form-label">Trạng thái</label>
                            <select name="isActive" class="form-select">
                                <c:choose>
                                    <c:when test="${product.active}">
                                        <option value="true">Đang bán</option>
                                        <option value="false">Ngừng bán</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="false">Ngừng bán</option>
                                        <option value="true">Đang bán</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Sao</label>
                            <input value="${product.star}" name="star" type="number" 
                                   class="form-control" min="0" max="5">
                        </div>

                        <button type="submit" class="btn btn-primary mt-3">Cập nhật sản phẩm</button>
                    </form>

                    <button onclick='history.back()' class="btn btn-secondary mt-3">Quay lại</button>
                </div>

            </div>
        </div>

        <div class="layout-overlay layout-menu-toggle"></div>
    </div>

    <script src="/Java_5/adminPage/asset/vendor/libs/jquery/jquery.js"></script>
    <script src="/Java_5/adminPage/asset/vendor/js/bootstrap.js"></script>
</body>
</html>
