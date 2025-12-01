<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<!-- Layout wrapper -->
	<div class="layout-wrapper layout-content-navbar">
		<div class="layout-container">
			<!-- Menu -->

			<jsp:include page="/adminPage/header.jsp" />

			<!-- Layout container -->
			<div class="layout-page">
				<!-- Navbar -->

				<nav
					class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
					id="layout-navbar">
					<div
						class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
						<a class="nav-item nav-link px-0 me-xl-4"
							href="javascript:void(0)"> <i class="bx bx-menu bx-sm"></i>
						</a>
					</div>

					<div class="navbar-nav-right d-flex align-items-center"
						id="navbar-collapse">
						<!-- Search -->
						<div class="navbar-nav align-items-center">
							<div class="nav-item d-flex align-items-center">
								<i class="bx bx-search fs-4 lh-0"></i> <input type="text"
									class="form-control border-0 shadow-none"
									placeholder="Search..." aria-label="Search..." />
							</div>
						</div>
						<!-- /Search -->

						<ul class="navbar-nav flex-row align-items-center ms-auto">
							<!-- Place this tag where you want the button to render. -->
							<li class="nav-item lh-1 me-3"><a class="github-button"
								href="https://github.com/themeselection/sneat-html-admin-template-free"
								data-icon="octicon-star" data-size="large"
								data-show-count="true"
								aria-label="Star themeselection/sneat-html-admin-template-free on GitHub">Star</a>
							</li>

							<!-- User -->
							<li class="nav-item navbar-dropdown dropdown-user dropdown">
								<a class="nav-link dropdown-toggle hide-arrow"
								href="javascript:void(0);" data-bs-toggle="dropdown">
									<div class="avatar avatar-online">
										<img src="/Java_5/adminPage/asset/img/avatars/1.png" alt
											class="w-px-40 h-auto rounded-circle" />
									</div>
							</a>
								<ul class="dropdown-menu dropdown-menu-end">
									<li><a class="dropdown-item" href="#">
											<div class="d-flex">
												<div class="flex-shrink-0 me-3">
													<div class="avatar avatar-online">
														<img src="/Java_5/adminPage/asset/img/avatars/1.png" alt
															class="w-px-40 h-auto rounded-circle" />
													</div>
												</div>
												<div class="flex-grow-1">
													<span class="fw-semibold d-block">John Doe</span> <small
														class="text-muted">Admin</small>
												</div>
											</div>
									</a></li>
									<li>
										<div class="dropdown-divider"></div>
									</li>
									<li><a class="dropdown-item" href="#"> <i
											class="bx bx-user me-2"></i> <span class="align-middle">My
												Profile</span>
									</a></li>
									<li><a class="dropdown-item" href="#"> <i
											class="bx bx-cog me-2"></i> <span class="align-middle">Settings</span>
									</a></li>
									<li><a class="dropdown-item" href="#"> <span
											class="d-flex align-items-center align-middle"> <i
												class="flex-shrink-0 bx bx-credit-card me-2"></i> <span
												class="flex-grow-1 align-middle">Billing</span> <span
												class="flex-shrink-0 badge badge-center rounded-pill bg-danger w-px-20 h-px-20">4</span>
										</span>
									</a></li>
									<li>
										<div class="dropdown-divider"></div>
									</li>
									<li><a class="dropdown-item" href="auth-login-basic.html">
											<i class="bx bx-power-off me-2"></i> <span
											class="align-middle">Log Out</span>
									</a></li>
								</ul>
							</li>
							<!--/ User -->
						</ul>
					</div>
				</nav>

				<!-- / Navbar -->

				<!-- Content wrapper -->

				<div class="p-2">
					<h1>Sửa thông tin danh mục</h1>
				</div>
				<div style="padding: 0px 30px;">

					<form action="ProductCategory?action=editsubmit" method="post">
						<input type="hidden" name="id" value="${categoryDetail.categoryId }">

						<div class="pb-3">
							<label class="form-label">Tên danh mục</label>
							<input value="${categoryDetail.name }" name="name" type="text" class="form-control" required>
						</div>

						<div class="pb-3">
							<label class="form-label">Alias</label>
							<input value="${categoryDetail.alias }" name="alias" type="text" class="form-control" required>
						</div>

						<div class="pb-3">
							<label class="form-label">Danh mục phòng</label>
							<input value="${categoryDetail.roomCategoryId }" name="roomCategoryId" type="number" class="form-control" required>
						</div>

						<div class="pb-3">
							<label class="form-label">Mô tả</label>
							<textarea name="description" class="form-control" rows="2">${categoryDetail.description }</textarea>
						</div>

						<div class="pb-3">
							<label class="form-label">Trạng thái</label>
							<select name="status" class="form-select">
								<c:choose>
									<c:when test="${categoryDetail.active}">
										<option value="1">Hiển thị</option>
										<option value="0">Ẩn</option>
									</c:when>
									<c:otherwise>
										<option value="0">Ẩn</option>
										<option value="1">Hiển thị</option>
									</c:otherwise>
								</c:choose>
							</select>
						</div>

						<button type="submit" class="btn btn-primary mt-3">Cập nhật danh mục</button>
						<button type="button" onclick="history.back()" class="btn btn-secondary mt-3">Quay lại</button>
					</form>

				</div>
				<!-- Content wrapper -->
			</div>
			<!-- / Layout page -->
		</div>

		<!-- Overlay -->
		<div class="layout-overlay layout-menu-toggle"></div>
	</div>
	<!-- / Layout wrapper -->



	<!-- Core JS -->
	<!-- build:js assets/vendor/js/core.js -->
	<script src="/Java_5/adminPage/asset/vendor/libs/jquery/jquery.js"></script>
	<script src="/Java_5/adminPage/asset/vendor/libs/popper/popper.js"></script>
	<script src="/Java_5/adminPage/asset/vendor/js/bootstrap.js"></script>
	<script
		src="/Java_5/adminPage/asset/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

	<script src="/Java_5/adminPage/asset/vendor/js/menu.js"></script>
	<!-- endbuild -->

	<!-- Vendors JS -->
	<script
		src="/Java_5/adminPage/asset/vendor/libs/apex-charts/apexcharts.js"></script>

	<!-- Main JS -->
	<script src="/Java_5/adminPage/asset/js/main.js"></script>

	<!-- Page JS -->
	<script src="/Java_5/adminPage/asset/js/dashboards-analytics.js"></script>

	<!-- Place this tag in your head or just before your close body tag. -->
	<script async defer src="https://buttons.github.io/buttons.js"></script>
</body>
</html>