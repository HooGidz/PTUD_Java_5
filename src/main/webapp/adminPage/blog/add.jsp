<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm bài viết mới</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/adminPage/asset/css/style.css" rel="stylesheet">
    <script src="https://cdn.ckeditor.com/4.16.2/standard/ckeditor.js"></script>
    <style>
        .required-label::after {
            content: " *";
            color: red;
        }
        .image-preview {
            max-width: 300px;
            max-height: 200px;
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 5px;
            margin-top: 10px;
            display: none;
        }
        .card {
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>

<jsp:include page="/adminPage/header.jsp" />

<div class="container mt-4">
    <div class="row">
        <div class="col-12">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/BlogControllers">Quản lý Blog</a></li>
                    <li class="breadcrumb-item active">Thêm bài viết mới</li>
                </ol>
            </nav>
        </div>
    </div>

    <div class="row justify-content-center">
        <div class="col-lg-10">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0"><i class="fas fa-plus-circle"></i> Thêm bài viết mới</h4>
                </div>
                <div class="card-body">
                    
                    <!-- Thông báo lỗi -->
                    <c:if test="${not empty sessionScope.error}">
                        <div class="alert alert-danger alert-dismissible fade show">
                            ${sessionScope.error}
                            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                        </div>
                        <c:remove var="error" scope="session"/>
                    </c:if>

                    <form action="${pageContext.request.contextPath}/BlogControllers" method="post" enctype="multipart/form-data" id="blogForm">
                        <input type="hidden" name="action" value="add">
                        
                        <!-- Thông tin cơ bản -->
                        <div class="row">
                            <div class="col-md-8">
                                <div class="mb-3">
                                    <label class="form-label required-label">Tiêu đề bài viết</label>
                                    <input type="text" class="form-control" name="title" id="title" 
                                           placeholder="Nhập tiêu đề bài viết" required
                                           onkeyup="generateAlias()">
                                    <div class="form-text">Tiêu đề sẽ hiển thị trên trang web và kết quả tìm kiếm.</div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="mb-3">
                                    <label class="form-label">Alias (URL)</label>
                                    <input type="text" class="form-control" name="alias" id="alias" 
                                           placeholder="alias-tu-dong-tao">
                                    <div class="form-text">Để trống để tự động tạo từ tiêu đề.</div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <div class="mb-3">
                                    <label class="form-label required-label">Danh mục</label>
                                    <select class="form-select" name="categoryId" required>
                                        <option value="">-- Chọn danh mục --</option>
                                        <option value="1">Tin tức</option>
                                        <option value="2">Khuyến mãi</option>
                                        <option value="3">Sự kiện</option>
                                        <option value="4">Hướng dẫn</option>
                                        <option value="5">Review</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="mb-3">
                                    <label class="form-label">Account ID</label>
                                    <input type="text" class="form-control" name="accountId" value="1" readonly>
                                    <div class="form-text">ID tài khoản tạo bài viết.</div>
                                </div>
                            </div>
                        </div>

                        <!-- Mô tả ngắn -->
                        <div class="mb-3">
                            <label class="form-label">Mô tả ngắn</label>
                            <textarea class="form-control" name="description" id="description" 
                                      rows="3" placeholder="Mô tả ngắn về bài viết..."></textarea>
                            <div class="form-text">Mô tả ngắn sẽ hiển thị trong danh sách bài viết và meta description.</div>
                        </div>

                        <!-- Nội dung chi tiết -->
                        <div class="mb-3">
                            <label class="form-label required-label">Nội dung chi tiết</label>
                            <textarea class="form-control" name="detail" id="detail" 
                                      rows="10" placeholder="Nhập nội dung chi tiết..." required></textarea>
                            <div class="form-text">Nội dung chính của bài viết.</div>
                        </div>

                        <!-- Hình ảnh -->
						<div class="mb-3">
						    <label class="form-label">Hình ảnh đại diện</label>
						    <input type="file" class="form-control" name="image" accept="image/*">
						    <div class="form-text">Chọn hình ảnh đại diện (JPG, PNG, GIF - Tối đa 5MB)</div>
						</div>

                        <!-- SEO Settings -->
                        <div class="card mb-4">
                            <div class="card-header bg-light">
                                <h6 class="mb-0"><i class="fas fa-search"></i> Cài đặt SEO</h6>
                            </div>
                            <div class="card-body">
                                <div class="mb-3">
                                    <label class="form-label">SEO Title</label>
                                    <input type="text" class="form-control" name="seoTitle" id="seoTitle"
                                           placeholder="Tiêu đề SEO (nếu khác với tiêu đề chính)">
                                    <div class="form-text">Để trống sẽ sử dụng tiêu đề bài viết.</div>
                                </div>
                                
                                <div class="mb-3">
                                    <label class="form-label">SEO Description</label>
                                    <textarea class="form-control" name="seoDescription" id="seoDescription" 
                                              rows="2" placeholder="Mô tả SEO..."></textarea>
                                    <div class="form-text">Mô tả hiển thị trên kết quả tìm kiếm (tối đa 160 ký tự).</div>
                                </div>
                                
                                <div class="mb-3">
                                    <label class="form-label">SEO Keywords</label>
                                    <input type="text" class="form-control" name="seoKeywords" 
                                           placeholder="keyword1, keyword2, keyword3">
                                    <div class="form-text">Các từ khóa phân cách bằng dấu phẩy.</div>
                                </div>
                            </div>
                        </div>

                        <!-- Cài đặt hiển thị -->
                        <div class="card mb-4">
                            <div class="card-header bg-light">
                                <h6 class="mb-0"><i class="fas fa-cog"></i> Cài đặt hiển thị</h6>
                            </div>
                            <div class="card-body">
                                <div class="mb-3">
                                    <label class="form-label">Trạng thái</label>
                                    <div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="isActive" 
                                                   id="active1" value="1" checked>
                                            <label class="form-check-label" for="active1">
                                                Hiển thị
                                            </label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="isActive" 
                                                   id="active0" value="0">
                                            <label class="form-check-label" for="active0">
                                                Ẩn
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Nút hành động -->
                        <div class="d-flex justify-content-between align-items-center border-top pt-3">
                            <div>
                                <a href="${pageContext.request.contextPath}/BlogControllers" 
                                   class="btn btn-secondary">
                                    <i class="fas fa-arrow-left"></i> Quay lại
                                </a>
                            </div>
                            <div class="btn-group">
                                <button type="submit" class="btn btn-success">
                                    <i class="fas fa-save"></i> Lưu bài viết
                                </button>
                                <button type="button" class="btn btn-primary" onclick="previewContent()">
                                    <i class="fas fa-eye"></i> Xem trước
                                </button>
                                <button type="reset" class="btn btn-warning">
                                    <i class="fas fa-redo"></i> Làm mới
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal Xem trước -->
<div class="modal fade" id="previewModal" tabindex="-1">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Xem trước bài viết</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <div id="previewContent"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://kit.fontawesome.com/your-fontawesome-kit.js"></script>
<script>
    
    // Tạo alias tự động từ title
    function generateAlias() {
        const title = document.getElementById('title').value;
        const aliasField = document.getElementById('alias');
        
        if (title && (!aliasField.value || aliasField.value.startsWith('alias-'))) {
            let alias = title.toLowerCase()
                .replace(/[àáạảãâầấậẩẫăằắặẳẵ]/g, 'a')
                .replace(/[èéẹẻẽêềếệểễ]/g, 'e')
                .replace(/[ìíịỉĩ]/g, 'i')
                .replace(/[òóọỏõôồốộổỗơờớợởỡ]/g, 'o')
                .replace(/[ùúụủũưừứựửữ]/g, 'u')
                .replace(/[ỳýỵỷỹ]/g, 'y')
                .replace(/đ/g, 'd')
                .replace(/[^a-z0-9\s-]/g, '')
                .replace(/\s+/g, '-')
                .replace(/-+/g, '-')
                .trim();
            
            aliasField.value = alias;
        }

        // Đồng bộ SEO Title nếu chưa có
        const seoTitle = document.getElementById('seoTitle');
        if (title && !seoTitle.value) {
            seoTitle.value = title;
        }

        // Đồng bộ SEO Description nếu chưa có
        const description = document.getElementById('description').value;
        const seoDescription = document.getElementById('seoDescription');
        if (description && !seoDescription.value) {
            seoDescription.value = description.substring(0, 160);
        }
    }

    // Xem trước ảnh
    function previewImage(input) {
        const preview = document.getElementById('imagePreview');
        if (input.files && input.files[0]) {
            const reader = new FileReader();
            reader.onload = function(e) {
                preview.src = e.target.result;
                preview.style.display = 'block';
            }
            reader.readAsDataURL(input.files[0]);
        } else {
            preview.style.display = 'none';
        }
    }

    // Xem trước nội dung
    function previewContent() {
        const title = document.getElementById('title').value || 'Tiêu đề bài viết';
        const content = CKEDITOR.instances.detail.getData() || '<p>Nội dung bài viết...</p>';
        
        const previewHTML = `
            <article>
                <h2>${title}</h2>
                <div class="content">
                    ${content}
                </div>
            </article>
        `;
        
        document.getElementById('previewContent').innerHTML = previewHTML;
        new bootstrap.Modal(document.getElementById('previewModal')).show();
    }

    // Validate form trước khi submit
    document.getElementById('blogForm').addEventListener('submit', function(e) {
        const title = document.getElementById('title').value.trim();
        if (!title) {
            e.preventDefault();
            alert('Vui lòng nhập tiêu đề bài viết!');
            document.getElementById('title').focus();
            return false;
        }

        // Tự động tạo alias nếu để trống
        const aliasField = document.getElementById('alias');
        if (!aliasField.value.trim()) {
            generateAlias();
        }

        // Tự động tạo SEO Title nếu để trống
        const seoTitle = document.getElementById('seoTitle');
        if (!seoTitle.value.trim()) {
            seoTitle.value = title;
        }

        return true;
    });

    // Focus vào ô tiêu đề khi trang load
    document.addEventListener('DOMContentLoaded', function() {
        document.getElementById('title').focus();
    });
</script>

</body>
</html>