<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="layout-wrapper layout-content-navbar">
		<div class="layout-container">
			<jsp:include page="/adminPage/header.jsp" />

			<div class="layout-page">
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
						<div class="navbar-nav align-items-center">
							<div class="nav-item d-flex align-items-center">
								<i class="bx bx-search fs-4 lh-0"></i> <input type="text"
									class="form-control border-0 shadow-none"
									placeholder="Search..." aria-label="Search..." />
							</div>
						</div>
						<ul class="navbar-nav flex-row align-items-center ms-auto">
							<li class="nav-item lh-1 me-3"><a class="github-button"
								href="https://github.com/themeselection/sneat-html-admin-template-free"
								data-icon="octicon-star" data-size="large"
								data-show-count="true"
								aria-label="Star themeselection/sneat-html-admin-template-free on GitHub">Star</a>
							</li>

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
						</ul>
					</div>
				</nav>

				<div class="p-2">
					<h1>Sửa thông tin đơn hàng</h1>
				</div>
				<div style="padding: 0px 30px;">
					<form action="Order?action=editsubmit" method="post">
						<input type="hidden" name="id" value="${orderDetail.orderId }">
						<div class="pb-3">
							<label for="defaultFormControlInput" class="form-label">Tên
								khách hàng</label> <input value="${orderDetail.customerName }"
								name="customerName" type="text" class="form-control"
								id="defaultFormControlInput" placeholder=""
								aria-describedby="defaultFormControlHelp">
						</div>
						<div class="pb-3">
							<label for="defaultFormControlInput" class="form-label">Số
								điện thoại</label> <input value="${orderDetail.phone }" name="phone"
								type="text" class="form-control" id="defaultFormControlInput"
								placeholder="" aria-describedby="defaultFormControlHelp">
						</div>
						<div class="pb-3">
							<label for="defaultFormControlInput" class="form-label">Địa
								chỉ</label> <input value="${orderDetail.address }" name="address"
								type="text" class="form-control" id="defaultFormControlInput"
								placeholder="" aria-describedby="defaultFormControlHelp">
						</div>
						<div class="pb-3">
							<label for="defaultFormControlInput" class="form-label">Số
								tiền hoá đơn</label> <input value="${orderDetail.totalAmount }"
								name="totalAmount" type="text" class="form-control"
								id="defaultFormControlInput" placeholder=""
								aria-describedby="defaultFormControlHelp">
						</div>
						<div class="pb-3">
							<label for="defaultFormControlInput" class="form-label">Số
								lượng sản phẩm</label> <input value="${orderDetail.quantity }"
								name="quantity" type="text" class="form-control"
								id="defaultFormControlInput" placeholder=""
								aria-describedby="defaultFormControlHelp">
						</div>
						<div class="pb-3">
							<label for="defaultFormControlInput" class="form-label">Ghi
								chú</label> <input value="${orderDetail.note }" name="note" type="text"
								class="form-control" id="defaultFormControlInput" placeholder=""
								aria-describedby="defaultFormControlHelp">
						</div>
						<div class="pb-3">
							<label for="defaultFormControlInput" class="form-label">Phương
								thức thanh toán</label> <input value="${orderDetail.paymentMethod }"
								name="paymentMethod" type="text" class="form-control"
								id="defaultFormControlInput" placeholder=""
								aria-describedby="defaultFormControlHelp">
						</div>
						<div class="pb-3">
							<label for="orderStatus" class="form-label">Trạng thái
								đơn hàng</label> <select name="orderStatus" id="orderStatus"
								class="form-control">
								<option value="">-- Chọn trạng thái --</option>
								<option value="Chờ xác nhận"
									<c:if test="${orderStatus != null and orderStatus.name eq 'Chờ xác nhận'}">selected</c:if>>Chờ
									xác nhận</option>
								<option value="Đã xác nhận"
									<c:if test="${orderStatus != null and orderStatus.name eq 'Đã xác nhận'}">selected</c:if>>Đã
									xác nhận</option>
								<option value="Đang giao"
									<c:if test="${orderStatus != null and orderStatus.name eq 'Đang giao'}">selected</c:if>>Đang
									giao</option>
								<option value="Đã giao"
									<c:if test="${orderStatus != null and orderStatus.name eq 'Đã giao'}">selected</c:if>>Đã
									giao</option>
								<option value="Đã huỷ"
									<c:if test="${orderStatus != null and orderStatus.name eq 'Đã huỷ'}">selected</c:if>>Đã
									huỷ</option>
							</select>
						</div>
						<div class="pb-3">
							<label for="descriptionStatusInput" class="form-label">Mô
								tả trạng thái </label> <input name="descriptionStatus" type="text"
								class="form-control" id="descriptionStatusInput" placeholder=""
								aria-describedby="defaultFormControlHelp"
								value="${orderStatus != null ? orderStatus.description : ''}">
						</div>

						<div class="pb-3">
							<label class="form-label">Sản phẩm trong đơn hàng</label>
							<table class="table table-bordered" id="productsTable">
								<thead>
									<tr>
										<th>Sản phẩm</th>
										<th>Giá gốc</th>
										<th>Giá</th>
										<th>Số lượng</th>
										<th>Hành động</th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${not empty orderDetails}">
											<c:forEach items="${orderDetails}" var="od">
												<tr class="product-row">
													<td><select name="productId"
														class="form-control product-select">
															<option value="">-- Chọn sản phẩm --</option>
															<c:forEach items="${products}" var="p">
																<option value="${p.productId}" data-price="${p.price}"
																	data-pricesale="${p.priceSale}"
																	<c:if test="${p.productId == od.productId}">selected</c:if>>${p.name}
																	(ID:${p.productId})</option>
															</c:forEach>
													</select></td>
													<td><input type="text"
														class="form-control product-original-price" readonly
														value="<fmt:formatNumber value='${od.price}' type='number' groupingUsed='true'/>" />

														<input type="hidden" name="productOriginalPrice"
														value="${od.price}" /></td>

													<td><input type="text"
														class="form-control product-sale-price" readonly
														value="<fmt:formatNumber value='${od.price}' type='number' groupingUsed='true'/>" />

														<input type="hidden" name="productPrice"
														value="${od.price}" /></td>


													<td><input name="productQuantity" type="text"
														class="form-control" placeholder="VD: 2"
														value="${od.quantity}" /></td>
													<td><button type="button"
															class="btn btn-danger btn-sm" onclick="removeRow(this)">Xóa</button></td>
												</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<tr class="product-row">
												<td><select name="productId"
													class="form-control product-select">
														<option value="">-- Chọn sản phẩm --</option>
														<c:forEach items="${products}" var="p">
															<option value="${p.productId}" data-price="${p.price}"
																data-pricesale="${p.priceSale}">${p.name}
																(ID:${p.productId})</option>
														</c:forEach>
												</select></td>
												<td><input type="number"
													class="form-control product-original-price" readonly /></td>
												<td><input name="productPrice" type="number"
													class="form-control product-sale-price" readonly /></td>
												<td><input name="productQuantity" type="text"
													class="form-control" placeholder="VD: 2" /></td>
												<td><button type="button" class="btn btn-danger btn-sm"
														onclick="removeRow(this)">Xóa</button></td>
											</tr>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
							<button type="button" class="btn btn-secondary"
								id="addProductBtn">Thêm sản phẩm</button>
						</div>


						<button type="submit" class="btn btn-primary mt-3">Cập
							nhật</button>
					</form>
					<button onclick='history.back()' class="btn btn-secondary mt-3">Quay
						lại</button>
				</div>
			</div>
		</div>

		<div class="layout-overlay layout-menu-toggle"></div>
	</div>

	<jsp:include page="/adminPage/footer.jsp" />
</body>
</html>