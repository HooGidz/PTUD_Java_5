<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý Blog</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/adminPage/asset/css/style.css" rel="stylesheet">
    <style>
        .table img { width: 80px; height: 50px; object-fit: cover; border-radius: 6px; }
        .badge-active { background: #28a745; color: white; }
        .badge-inactive { background: #dc3545; color: white; }
    </style>
</head>
<body>

<jsp:include page="/adminPage/header.jsp" />

<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="text-primary">Quản lý Blog</h2>
        <a href="/Java_5/BlogControllers?action=add" class="btn btn-primary btn-lg">
            + Thêm bài viết
        </a>
    </div>

    <!-- Thông báo thành công -->
    <c:if test="${not empty sessionScope.successMsg}">
        <div class="alert alert-success alert-dismissible fade show">
            ${sessionScope.successMsg}
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
        <c:remove var="successMsg" scope="session"/>
    </c:if>

    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">Danh sách bài viết (${listP.size()} bài)</h5>
        </div>
        <div class="card-body">
            <c:choose>
                <c:when test="${empty listP}">
                    <div class="text-center py-5">
                        <p class="text-muted fs-4">Chưa có bài viết nào</p>
                        <a href="BlogControllers?action=add" class="btn btn-primary btn-lg">
                            Viết bài đầu tiên
                        </a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="table-responsive">
                        <table class="table table-hover align-middle">
                            <thead class="table-light">
                                <tr>
                                    <th width="5%">#</th>
                                    <th width="12%">Hình ảnh</th>
                                    <th>Tiêu đề</th>
                                    <th width="15%">Danh mục</th>
                                    <th width="12%">Ngày tạo</th>
                                    <th width="10%">Trạng thái</th>
                                    <th width="15%">Hành động</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="b" items="${listP}" varStatus="stt">
                                    <tr>
                                        <td>${stt.index + 1}</td>
                                        <td>
                                            <c:if test="${not empty b.image}">
                                                <img src="${b.image}" 
                                                     alt="img" class="img-thumbnail">
                                            </c:if>
                                            <c:if test="${empty b.image}">
                                                <span class="text-muted">Không có ảnh</span>
                                            </c:if>
                                        </td>
                                        <td>
                                            <strong>${b.title}</strong>
                                            <br><small class="text-muted">Alias: ${b.alias}</small>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${b.categoryId == 0 || empty b.categoryId}">
                                                    <span class="text-danger">Chưa chọn</span>
                                                </c:when>
                                                <c:otherwise>
                                                    DM #${b.categoryId}
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <fmt:formatDate value="${b.createDate}" pattern="dd/MM/yyyy"/>
                                        </td>
                                        <td>
                                            <span class="badge ${b.active ? 'badge-active' : 'badge-inactive'}">
                                                ${b.active ? 'Hiển thị' : 'Đã ẩn'}
                                            </span>
                                        </td>
                                        <td>
                                            <div class="btn-group" role="group">
                                                <a href="${pageContext.request.contextPath}/BlogControllers?action=edit&id=${b.blogId}" 
                                                   class="${pageContext.request.contextPath}/btn btn-warning btn-sm">Sửa</a>
                                                <a href="BlogControllers?action=toggle&id=${b.blogId}" 
                                                   class="btn btn-info btn-sm text-white">
                                                    ${b.active ? 'Ẩn' : 'Hiện'}
                                                </a>
                                                <a href="BlogControllers?action=delete&id=${b.blogId}" 
                                                   class="btn btn-danger btn-sm"
                                                   onclick="return confirm('Xóa vĩnh viễn bài này?')">Xóa</a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

