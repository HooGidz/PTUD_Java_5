<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa bài viết</title>
    <link rel="stylesheet" href="/Java_5/adminPage/asset/vendor/css/bootstrap.css">
    <script src="https://cdn.ckeditor.com/4.16.2/standard/ckeditor.js"></script>
    <style>
        .image-preview { max-width: 300px; max-height: 200px; border: 2px dashed #ddd; border-radius: 8px; padding: 10px; margin: 10px 0; }
        .current-image { border: 2px solid #28a745; border-radius: 8px; padding: 5px; max-height: 150px; }
        .form-label { font-weight: bold; }
        .card { margin-bottom: 20px; }
    </style>
</head>
<body>
<div class="container-fluid py-3">

    <jsp:include page="/adminPage/header.jsp" />

    <div class="py-2">
        <h2>Chỉnh sửa bài viết</h2>
    </div>

    <c:choose>
        <c:when test="${empty blogDetail}">
            <div class="alert alert-danger">
                <h4>Không tìm thấy bài viết</h4>
                <p>Bài viết bạn đang tìm kiếm không tồn tại hoặc đã bị xóa.</p>
                <a href="${pageContext.request.contextPath}/BlogControllers" class="btn btn-primary">Quay lại danh sách</a>
            </div>
        </c:when>
        <c:otherwise>
            <form  action="${pageContext.request.contextPath}/BlogControllers?action=edit" method="post" enctype="multipart/form-data">
                <input type="hidden" name="blogId" value="${blogDetail.blogId}" />

                <!-- Tiêu đề & Alias -->
                <div class="row">
                    <div class="col-md-8 mb-3">
                        <label class="form-label">Tiêu đề bài viết</label>
                        <input value="${blogDetail.title}" name="title" type="text" class="form-control" placeholder="Nhập tiêu đề bài viết" required onkeyup="generateAlias()">
                    </div>
                    <div class="col-md-4 mb-3">
                        <label class="form-label">Alias (URL)</label>
                        <input value="${blogDetail.alias}" name="alias" type="text" class="form-control" placeholder="alias-tu-dong-tao">
                    </div>
                </div>

                <!-- Danh mục & Account -->
                <div class="row">
                    <div class="col-md-6 mb-3">
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
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Account ID</label>
                        <input value="${blogDetail.accountId}" name="accountId" type="text" class="form-control" readonly>
                    </div>
                </div>

                <!-- Mô tả ngắn -->
                <div class="mb-3">
                    <label class="form-label">Mô tả ngắn</label>
                    <textarea name="description" class="form-control" rows="3" placeholder="Mô tả ngắn về bài viết...">${blogDetail.description}</textarea>
                </div>

                <!-- Nội dung chi tiết -->
                <div class="mb-3">
                    <label class="form-label">Nội dung chi tiết</label>
                    <textarea name="detail" class="form-control" id="detail" rows="10" required>${blogDetail.detail}</textarea>
                </div>

                <!-- Hình ảnh -->
                <div class="mb-3">
                    <label class="form-label">Hình ảnh đại diện</label>
                    <c:if test="${not empty blogDetail.image}">
                        <div class="mb-2">
                            <p class="text-success mb-1">Ảnh hiện tại:</p>
                            <img src="${blogDetail.image}" alt="Ảnh hiện tại" class="current-image">
                            <div class="form-text">Đường dẫn: ${blogDetail.image}</div>
                        </div>
                    </c:if>
                    <input type="file" class="form-control" name="image" id="imageInput" accept="image/*" onchange="handleImageSelect(this)">
                    <div id="fileInfo" class="form-text">Chọn ảnh mới để thay thế ảnh hiện tại</div>
                    <div id="imagePreviewContainer" style="display:none;" class="mt-2 text-center">
                        <p class="text-primary">Ảnh mới:</p>
                        <img id="imagePreview" src="" class="image-preview">
                    </div>
                </div>

                <!-- SEO -->
                <div class="card">
                    <div class="card-header bg-light"><strong>Cài đặt SEO</strong></div>
                    <div class="card-body">
                        <div class="mb-3">
                            <label class="form-label">SEO Title</label>
                            <input value="${blogDetail.seoTitle}" name="seoTitle" type="text" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">SEO Description</label>
                            <textarea name="seoDescription" class="form-control" rows="2">${blogDetail.seoDescription}</textarea>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">SEO Keywords</label>
                            <input value="${blogDetail.seoKeywords}" name="seoKeywords" type="text" class="form-control" placeholder="keyword1, keyword2">
                        </div>
                    </div>
                </div>

                <!-- Trạng thái hiển thị -->
                <div class="card">
                    <div class="card-header bg-light"><strong>Cài đặt hiển thị</strong></div>
                    <div class="card-body">
                        <div class="mb-3">
                            <label class="form-label">Trạng thái</label>
                            <select name="isActive" class="form-select">
                                <option value="1" ${blogDetail.active ? 'selected' : ''}>Hiển thị</option>
                                <option value="0" ${not blogDetail.active ? 'selected' : ''}>Ẩn</option>
                            </select>
                        </div>
                        <div class="text-muted small">
                            <p>Người tạo: ${blogDetail.createBy} | Ngày tạo: <fmt:formatDate value="${blogDetail.createDate}" pattern="dd/MM/yyyy HH:mm"/></p>
                            <c:if test="${not empty blogDetail.modifiedBy}">
                                <p>Người sửa: ${blogDetail.modifiedBy} | Lần sửa cuối: <fmt:formatDate value="${blogDetail.modifiedDate}" pattern="dd/MM/yyyy HH:mm"/></p>
                            </c:if>
                        </div>
                    </div>
                </div>

                <!-- Nút hành động -->
                <div class="d-flex justify-content-between mt-3">
                    <div>
                        <button type="button" class="btn btn-secondary" onclick="history.back()">Quay lại</button>
                        <a href="${pageContext.request.contextPath}/BlogControllers?action=delete&id=${blogDetail.blogId}" class="btn btn-outline-danger ms-2" onclick="return confirm('Bạn có chắc muốn xóa bài viết này?')">Xóa bài viết</a>
                    </div>
                    <div>
                        <button type="reset" class="btn btn-warning">Đặt lại</button>
                        <button type="submit" class="btn btn-success">Cập nhật bài viết</button>
                    </div>
                </div>
            </form>
        </c:otherwise>
    </c:choose>
</div>


<script src="/Java_5/adminPage/asset/vendor/js/bootstrap.js"></script>
</body>
</html>
