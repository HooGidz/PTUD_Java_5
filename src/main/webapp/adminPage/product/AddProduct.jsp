<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sản phẩm</title>
</head>
<body>
<div class="layout-wrapper layout-content-navbar">
	<div class="layout-container">

		<jsp:include page="/adminPage/header.jsp" />

		<div class="layout-page">
			<div class="p-2">
				<h1>Thêm sản phẩm</h1>
			</div>

			<div style="padding: 0px 30px;">
				<form action="product?action=addsubmit" method="post">
					<div class="pb-3">
						<label class="form-label">Tên sản phẩm</label>
						<input name="name" type="text" class="form-control" required>
					</div>

					<div class="pb-3">
						<label class="form-label">Alias</label>
						<input name="alias" type="text" class="form-control">
					</div>

					<div class="pb-3">
						<label class="form-label">Nhà cung cấp</label>
						<input name="providerId" type="number" class="form-control" required>
					</div>

					<div class="pb-3">
						<label class="form-label">Danh mục</label>
						<input name="categoryId" type="number" class="form-control" required>
					</div>

					<div class="pb-3">
						<label class="form-label">Thương hiệu</label>
						<input name="brands" type="text" class="form-control">
					</div>

					<div class="pb-3">
						<label class="form-label">Chất liệu</label>
						<input name="material" type="text" class="form-control">
					</div>

					<div class="pb-3">
						<label class="form-label">Kích thước</label>
						<input name="dimensions" type="text" class="form-control">
					</div>

					<div class="pb-3">
						<label class="form-label">Mô tả</label>
						<input name="description" type="text" class="form-control">
					</div>

					<div class="pb-3">
						<label class="form-label">Chi tiết</label>
						<input name="detail" type="text" class="form-control">
					</div>

					<div class="pb-3">
						<label class="form-label">Ảnh</label>
						<input name="image" type="text" class="form-control">
					</div>

					<div class="pb-3">
						<label class="form-label">Giá</label>
						<input name="price" type="number" step="0.01" class="form-control" required>
					</div>

					<div class="pb-3">
						<label class="form-label">Giá khuyến mãi</label>
						<input name="priceSale" type="number" step="0.01" class="form-control">
					</div>

					<div class="pb-3">
						<label class="form-label">Số lượng</label>
						<input name="quantity" type="number" class="form-control">
					</div>

					<div class="pb-3">
						<label class="form-label">Sản phẩm mới</label>
						<select name="isNew" class="form-select">
							<option value="true">Đúng</option>
							<option value="false">Sai</option>
						</select>
					</div>

					<div class="pb-3">
						<label class="form-label">Sản phẩm bán chạy</label>
						<select name="isBestSeller" class="form-select">
							<option value="true">Đúng</option>
							<option value="false">Sai</option>
						</select>
					</div>

					<div class="pb-3">
						<label class="form-label">Hiển thị</label>
						<select name="isActive" class="form-select">
							<option value="true">Hoạt động</option>
							<option value="false">Ngừng hoạt động</option>
						</select>
					</div>

					<div class="pb-3">
						<label class="form-label">Sao</label>
						<input name="star" type="number" min="0" max="5" class="form-control">
					</div>

					<button type="submit" class="btn btn-primary mt-3">Thêm sản phẩm</button>
					<button type="button" onclick="history.back()" class="btn btn-secondary mt-3">Quay lại</button>
				</form>
			</div>
		</div>

	</div>
</div>
</body>
</html>
