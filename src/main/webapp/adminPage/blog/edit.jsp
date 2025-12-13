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
                    <h1>Sửa thông tin bài viết</h1>
                </div>

                <div style="padding: 0px 30px;">

                    <form action="${pageContext.request.contextPath}/BlogControllers?action=edit" method="post">

                        <!-- ID ẩn -->
                        <input type="hidden" name="blogId" value="${blogDetail.blogId}">

                        <div class="pb-3">
                            <label class="form-label">Tiêu đề</label>
                            <input value="${blogDetail.title}" name="title" type="text" 
                                   class="form-control" placeholder="Tiêu đề">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Bí danh</label>
                            <input value="${blogDetail.alias}" name="alias" type="text" 
                                   class="form-control" placeholder="Bí danh">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Danh mục</label>
                        <select name="categoryId" class="form-select" required>
                            <option value="">-- Chọn danh mục --</option>
                            <option value="1" ${blogDetail.categoryId == 1 ? 'selected' : ''}>Tin tức</option>
                            <option value="2" ${blogDetail.categoryId == 2 ? 'selected' : ''}>Khuyến mãi</option>
                            <option value="3" ${blogDetail.categoryId == 3 ? 'selected' : ''}>Sự kiện</option>
                            <option value="4" ${blogDetail.categoryId == 4 ? 'selected' : ''}>Hướng dẫn</option>
                            <option value="5" ${blogDetail.categoryId == 5 ? 'selected' : ''}>Review</option>
                        </select>

                        </div>

                        <div class="pb-3">
                            <label class="form-label">Mô tả</label>
                            <textarea name="description" class="form-control" rows="2">${blogDetail.description}</textarea>
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Chi tiết</label>
                            <textarea name="detail" class="form-control" rows="3">${blogDetail.detail}</textarea>
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Ảnh</label>
                            <input value="${blogDetail.image}" name="image" type="text" 
                                   class="form-control" placeholder="Link ảnh">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Tiêu đề SEO</label>
                            <input value="${blogDetail.seoTitle}" name="seoTitle" type="text" 
                                   class="form-control" placeholder="Tiêu đề SEO">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Mô tả SEO</label>
                            <input value="${blogDetail.seoDescription}" name="seoDescription" type="text" 
                                   class="form-control" placeholder="Mô tả SEO">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Từ khóa SEO</label>
                            <input value="${blogDetail.seoKeywords}" name="seoKeywords" type="text" 
                                   class="form-control">
                        </div>

                        <!-- isActive -->
                        <div class="pb-3">
                            <label class="form-label">Trạng thái</label>
                            <select name="isActive" class="form-select">
                                <c:choose>
                                    <c:when test="${blogDetail.active}">
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
                        
                        <button type="submit" class="btn btn-primary mt-3">Cập nhật bài viết</button>
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