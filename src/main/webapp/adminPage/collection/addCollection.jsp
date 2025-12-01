<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Collection mới</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/adminPage/asset/css/style.css" rel="stylesheet">
</head>
<body>

<jsp:include page="/adminPage/header.jsp" />

<div class="container mt-4">
    <div class="row">
        <div class="col-12">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/CollectionController">Quản lý Collection</a>
                    </li>
                    <li class="breadcrumb-item active">Thêm Collection mới</li>
                </ol>
            </nav>
        </div>
    </div>

    <div class="row justify-content-center">
        <div class="col-lg-10">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0">➕ Thêm Collection mới</h4>
                </div>

                <div class="card-body">
                    

                    <!-- Sửa form: action phải khớp với Servlet -->
                    <form action="/CollectionController?action=add" method="post" >
                       <!-- Sửa thành "add" để khớp với doPost -->

                        <!-- Basic Information -->
                        <div class="row">
                            <div class="col-md-8">
                                <label class="form-label required-label">Tên Collection</label>
                                <input type="text" class="form-control" name="name" id="name"
                                       placeholder="Nhập tên collection..." required>
                            </div>

                            <div class="col-md-4">
                                <label class="form-label">Alias (URL)</label>
                                <input type="text" class="form-control" name="alias" id="alias"
                                       placeholder="alias-tu-dong-tao">
                                <div class="form-text">Nếu để trống sẽ tự tạo theo tên.</div>
                            </div>
                        </div>

                        <!-- Designer / Maker -->
                        <div class="row mt-3">
                            <div class="col-md-6">
                                <label class="form-label required-label">Designer</label>
                                <input type="text" class="form-control" name="designer" required>
                            </div>
                            <div class="col-md-6">
                                <label class="form-label required-label">Maker</label>
                                <input type="text" class="form-control" name="maker" required>
                            </div>
                        </div>
						 <!-- Hình ảnh -->
						<div class="mb-3">
						    <label class="form-label">Hình ảnh đại diện</label>
						    <input type="file" class="form-control" name="image" accept="image/*">
						    <div class="form-text">Chọn hình ảnh đại diện (JPG, PNG, GIF - Tối đa 5MB)</div>
						</div>
                        <div class="mb-3">
                            <label class="form-label">Mô tả</label>
                            <textarea class="form-control" name="description" rows="3" placeholder="Nhập mô tả ngắn về collection..."></textarea>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Chi tiết</label>
                            <textarea class="form-control" name="detail" rows="5" placeholder="Nhập chi tiết về collection..."></textarea>
                        </div>

                        <!-- Checkboxes -->
                        <div class="row mt-3">
                            <div class="col-md-4">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="isNew" value="on">
                                    <label class="form-check-label">Hàng mới</label>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="isBestSeller" value="on">
                                    <label class="form-check-label">Bán chạy</label>
                                </div>
                            </div>
                        </div>

                        <!-- Hidden field for image (tạm thời để trống) -->
                        <input type="hidden" name="image" value="">

                        <!-- Active Status -->
                        <div class="card mb-4 mt-3">
                            <div class="card-header bg-light">
                                <h6 class="mb-0">Trạng thái</h6>
                            </div>
                            <div class="card-body">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" checked type="radio" name="isActive" value="1" id="activeYes">
                                    <label class="form-check-label" for="activeYes">Hiển thị</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="isActive" value="0" id="activeNo">
                                    <label class="form-check-label" for="activeNo">Ẩn</label>
                                </div>
                            </div>
                        </div>

                        <!-- Buttons -->
                        <div class="d-flex justify-content-between border-top pt-3">
                            <a href="${pageContext.request.contextPath}/CollectionController"
                               class="btn btn-secondary">
                                ⬅ Quay lại danh sách
                            </a>
                            <div>
                                <button type="reset" class="btn btn-warning me-2">
                                    🔄 Làm mới
                                </button>
                                <button type="submit" class="btn btn-success">
                                    ✔ Lưu Collection
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<script>
// Tự động tạo alias từ tên collection
document.getElementById('name').addEventListener('input', function() {
    const name = this.value;
    const aliasField = document.getElementById('alias');
    
    // Chỉ tạo alias nếu alias field đang trống hoặc chưa được sửa thủ công
    if (!aliasField.manualEdit) {
        const alias = name.toLowerCase()
            .replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g, 'a')
            .replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g, 'e')
            .replace(/ì|í|ị|ỉ|ĩ/g, 'i')
            .replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g, 'o')
            .replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g, 'u')
            .replace(/ỳ|ý|ỵ|ỷ|ỹ/g, 'y')
            .replace(/đ/g, 'd')
            .replace(/[^a-z0-9]/g, '-')
            .replace(/-+/g, '-')
            .replace(/^-|-$/g, '');
        aliasField.value = alias;
    }
});

// Đánh dấu khi người dùng sửa alias thủ công
document.getElementById('alias').addEventListener('input', function() {
    this.manualEdit = true;
});
</script>

</body>
</html>