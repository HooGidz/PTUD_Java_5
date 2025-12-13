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
                    <h1>Sửa thông tin bộ sưu tập</h1>
                </div>

                <div style="padding: 0px 30px;">

                    <form action="${pageContext.request.contextPath}/AdminCollectionController?action=edit" method="post">

                        <!-- ID ẩn -->
                        <input type="hidden" name="collectionId" value="${collectionDetail.collectionId}">

                        <div class="pb-3">
                            <label class="form-label">Tên</label>
                            <input value="${collectionDetail.name}" name="name" type="text" 
                                   class="form-control" placeholder="Tên bộ sưu tập">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Bí danh</label>
                            <input value="${collectionDetail.alias}" name="alias" type="text" 
                                   class="form-control" placeholder="Bí danh">
                        </div>
                        <div class="pb-3">
                            <label class="form-label">Nhà thiết kế</label>
                            <input value="${collectionDetail.designer}" name="designer" type="text" 
                                   class="form-control" placeholder="Nhà thiết">
                        </div>
                        
                        <div class="pb-3">
                            <label class="form-label">Người tạo</label>
                            <input value="${collectionDetail.maker}" name="maker" type="text" 
                                   class="form-control" placeholder="Người tạo">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Mô tả</label>
                            <textarea name="description" class="form-control" rows="2">${collectionDetail.description}</textarea>
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Chi tiết</label>
                            <textarea name="detail" class="form-control" rows="3">${collectionDetail.detail}</textarea>
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Ảnh</label>
                            <input value="${collectionDetail.image}" name="image" type="text" 
                                   class="form-control" placeholder="Link ảnh">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Bán chạy</label>
                            <select name="isBestSeller" class="form-select">
                                <c:choose>
                                    <c:when test="${collectionDetail.bestSeller}">
                                        <option value="1">Có</option>
                                        <option value="0">Không</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="0">Không</option>
                                        <option value="1">Có</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Ngày tạo</label>
                            <input value="${collectionDetail.createdDate}" name="createdDate" type="date" 
                                   class="form-control">
                        </div>

                        <!-- isActive -->
                        <div class="pb-3">
                            <label class="form-label">Trạng thái</label>
                            <select name="isActive" class="form-select">
                                <c:choose>
                                    <c:when test="${collectionDetail.active}">
                                        <option value="1" selected>Hiện</option>
                                        <option value="0">Ẩn</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="1">Hiện</option>
                                        <option value="0" selected>Ẩn</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </div>
                        
                        <button type="submit" class="btn btn-primary mt-3">Cập nhật bộ sưu tập</button>
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