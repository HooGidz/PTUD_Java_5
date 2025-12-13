<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm bình luận</title>
</head>
<body>
<div class="layout-wrapper layout-content-navbar">
	<div class="layout-container">

		<jsp:include page="/adminPage/header.jsp" />

		<div class="layout-page">
			<div class="p-2">
				<h1>Thêm bình luận</h1>
			</div>

			<div style="padding: 0px 30px;">
				<form action="${pageContext.request.contextPath}/BlogCommentController?action=add" method="post">
					<div class="pb-3">
						<label class="form-label">Tên</label>
						<input name="name" type="text" class="form-control" required>
					</div>

					<div class="pb-3">
						<label class="form-label">Số điện thoại</label>
						<input name="phone" type="text" class="form-control">
					</div>

					<div class="pb-3">
						<label class="form-label">Email</label>
						<input name="email" type="text" class="form-control" required>
					</div>

					<div class="pb-3">
						<label class="form-label">Nội dung</label>
						<input name="detail" type="text" class="form-control">
					</div>

					<div class="pb-3">
						<label class="form-label">Ngày tạo</label>
						<input name="createddate" type="date" class="form-control">
					</div>

					<div class="pb-3">
						<label class="form-label">Mã bài viết</label>
						<input name="blogId" type="number" class="form-control">
					</div>

					<div class="pb-3">
						<label class="form-label">Trạng thái</label>
                                    <div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="isactive" 
                                                   id="active1" value="1" checked>
                                            <label class="form-check-label" for="active1">
                                                Hiển thị
                                            </label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="isactive" 
                                                   id="active0" value="0">
                                            <label class="form-check-label" for="active0">
                                                Ẩn
                                            </label>
								</div>
						</div>
					</div>
						<button type="submit" class="btn btn-primary mt-3">Thêm bình luận</button>
						<button type="button" onclick="history.back()" class="btn btn-secondary mt-3">Quay lại</button>
					</form>
				</div>
			</div>

		</div>
</div>
</body>
</html>