<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý Blog Comment</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .badge-active { background-color: #28a745; color: white; }
        .badge-inactive { background-color: #dc3545; color: white; }
    </style>
</head>
<body>

<jsp:include page="/adminPage/header.jsp" />

<div class="container mt-4">

    <h3>📋 Quản lý bình luận (${listP.size()} bình luận)</h3>

    <!-- Form thêm / sửa bình luận -->
    <div class="card mb-4">
        <div class="card-header bg-primary text-white">
            <strong>Thêm / Sửa Bình Luận</strong>
        </div>
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/BlogCommentController" method="post">
                <input type="hidden" name="commentId" value="${editComment != null ? editComment.commentId : ''}" />
                <div class="row mb-2">
                    <div class="col-md-4">
                        <label class="form-label">Tên</label>
                        <input type="text" name="name" class="form-control" required
                               value="${editComment != null ? editComment.name : ''}" />
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Phone</label>
                        <input type="text" name="phone" class="form-control"
                               value="${editComment != null ? editComment.phone : ''}" />
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Email</label>
                        <input type="email" name="email" class="form-control"
                               value="${editComment != null ? editComment.email : ''}" />
                    </div>
                </div>
                <div class="mb-2">
                    <label class="form-label">Nội dung</label>
                    <textarea name="detail" class="form-control" rows="2" required>${editComment != null ? editComment.detail : ''}</textarea>
                </div>
                <div class="mb-2">
                    <label class="form-label">Blog ID</label>
                    <input type="number" name="blogId" class="form-control" required
                           value="${editComment != null ? editComment.blogId : ''}" />
                </div>
                <div class="form-check mb-2">
                    <input class="form-check-input" type="checkbox" name="isactive"
                           id="isactive" ${editComment != null && editComment.isIsactive() ? 'checked' : ''}>
                    <label class="form-check-label" for="isactive">Hiển thị</label>
                </div>
                <button type="submit" class="btn btn-success">
                    ${editComment != null ? 'Cập nhật bình luận' : 'Thêm bình luận'}
                </button>
            </form>
        </div>
    </div>

    <!-- Bảng danh sách bình luận -->
    <table class="table table-bordered table-hover align-middle">
        <thead class="table-light">
            <tr>
                <th>ID</th>
                <th>Tên</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Nội dung</th>
                <th>Ngày tạo</th>
                <th>Blog ID</th>
                <th>Trạng thái</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="comment" items="${listP}">
                <tr>
                    <td>${comment.commentId}</td>
                    <td>${comment.name}</td>
                    <td>${comment.phone}</td>
                    <td>${comment.email}</td>
                    <td>${comment.detail}</td>
                    <td><fmt:formatDate value="${comment.createddate}" pattern="dd/MM/yyyy HH:mm"/></td>
                    <td>${comment.blogId}</td>
                    <td>
                        <span class="badge ${comment.isIsactive() ? 'badge-active' : 'badge-inactive'}">
                            ${comment.isIsactive() ? 'Hiển thị' : 'Ẩn'}
                        </span>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/BlogCommentController?action=edit&id=${comment.commentId}" 
                           class="btn btn-warning btn-sm">✏️ Sửa</a>
                        <a href="${pageContext.request.contextPath}/BlogCommentController?action=toggle&id=${comment.commentId}" 
                           class="btn btn-info btn-sm text-white">🔄 Toggle</a>
                        <a href="${pageContext.request.contextPath}/BlogCommentController?action=delete&id=${comment.commentId}" 
                           class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc muốn xóa bình luận này?');">❌ Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <c:if test="${empty listP}">
        <div class="alert alert-info">Chưa có bình luận nào.</div>
    </c:if>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
