<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý Collection</title>
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
        <h2 class="text-primary">Quản lý Collection</h2>
        <a href="${pageContext.request.contextPath}/CollectionController?action=add" class="btn btn-primary btn-lg">
            + Thêm Collection
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
            <h5 class="mb-0">Danh sách Collection (${listP.size()} collection)</h5>
        </div>
        <div class="card-body">
            <c:choose>
                <c:when test="${empty listP}">
                    <div class="text-center py-5">
                        <p class="text-muted fs-4">Chưa có collection nào</p>
                        <a href="${pageContext.request.contextPath}/CollectionController?action=add" class="btn btn-primary btn-lg">
                            Thêm collection đầu tiên
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
                                    <th>Tên</th>
                                    <th>Designer</th>
                                    <th>Maker</th>
                                    <th width="12%">Ngày tạo</th>
                                    <th width="10%">Trạng thái</th>
                                    <th width="20%">Hành động</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="c" items="${listP}" varStatus="stt">
                                    <tr>
                                        <td>${stt.index + 1}</td>
                                        <td>
                                            <c:if test="${not empty c.image}">
                                                <img src="${c.image}" alt="img" class="img-thumbnail">
                                            </c:if>
                                            <c:if test="${empty c.image}">
                                                <span class="text-muted">Không có ảnh</span>
                                            </c:if>
                                        </td>
                                        <td>
                                            <strong>${c.name}</strong>
                                            <br><small class="text-muted">Alias: ${c.alias}</small>
                                        </td>
                                        <td>${c.designer}</td>
                                        <td>${c.maker}</td>
                                        <td>
                                            <fmt:formatDate value="${c.createDate}" pattern="dd/MM/yyyy"/>
                                        </td>
                                        <td>
                                            <span class="badge ${c.active ? 'badge-active' : 'badge-inactive'}">
                                                ${c.active ? 'Hiển thị' : 'Đã ẩn'}
                                            </span>
                                        </td>
                                        <td>
                                            <div class="btn-group" role="group">
                                                <a href="${pageContext.request.contextPath}/CollectionController?action=edit&id=${c.collectionId}" 
                                                   class="btn btn-warning btn-sm">Sửa</a>
                                                <a href="${pageContext.request.contextPath}/CollectionController?action=toggle&id=${c.collectionId}" 
                                                   class="btn btn-info btn-sm text-white">
                                                    ${c.active ? 'Ẩn' : 'Hiện'}
                                                </a>
                                                <a href="${pageContext.request.contextPath}/CollectionController?action=delete&id=${c.collectionId}" 
                                                   class="btn btn-danger btn-sm"
                                                   onclick="return confirm('Xóa vĩnh viễn collection này?')">Xóa</a>
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
