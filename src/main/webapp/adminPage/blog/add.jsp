<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm bài viết</title>
</head>
<body>
<div class="layout-wrapper layout-content-navbar">
	<div class="layout-container">

		<jsp:include page="/adminPage/header.jsp" />

		<div class="layout-page">
			<div class="p-2">
				<h1>Thêm bài viết</h1>
			</div>

			<div style="padding: 0px 30px;">
				<form action="${pageContext.request.contextPath}/BlogControllers?action=add" method="post">
					<div class="pb-3">
						<label class="form-label">Tiêu đề</label>
						<input name="title" type="text" class="form-control" required>
					</div>

					<div class="pb-3">
						<label class="form-label">Bí danh</label>
						<input name="alias" type="text" class="form-control">
					</div>

					<div class="pb-3">
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

					<div class="pb-3">
						<label class="form-label">Mô tả</label>
						<input name="description" type="text" class="form-control" required>
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
						<label class="form-label">Tiêu đề SEO</label>
						<input name="seoTitle" type="text" class="form-control">
					</div>

					<div class="pb-3">
						<label class="form-label">Mô tả SEO</label>
						<input name="seoDescription" type="text" class="form-control">
					</div>

					<div class="pb-3">
						<label class="form-label">Từ khóa SEO</label>
						<input name="seoKeywords" type="text" class="form-control">
					</div>
				
					<div class="pb-3">
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
						<button type="submit" class="btn btn-primary mt-3">Thêm bài viết</button>
						<button type="button" onclick="history.back()" class="btn btn-secondary mt-3">Quay lại</button>
					</form>
				</div>
			</div>

		</div>
</div>
</body>
</html>