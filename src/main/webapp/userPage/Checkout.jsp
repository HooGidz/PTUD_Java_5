<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Collection"%>
<%@ page import="db.CartItem"%>

<jsp:include page="header.jsp"></jsp:include>
<section class="breadcrumb breadcrumb_bg">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-8">
				<div class="breadcrumb_iner">
					<div class="breadcrumb_iner_item">
						<h2>Thanh toán</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<section class="checkout_area padding_top">
	<div class="container">
		<div class="billing_details">
			<div class="row">

				<%-- *** BƯỚC 1: BẮT ĐẦU FORM ĐẶT HÀNG TẠI ĐÂY *** --%>
				<form class="row contact_form"
					action="${pageContext.request.contextPath}/Checkout" method="post"
					id="checkoutForm">

					<div class="col-lg-5">
						<h3>Chi tiết đơn hàng</h3>

						<div class="col-md-12 form-group p_star">
							<input type="text" class="form-control" id="name"
								name="customerName" placeholder="Họ và tên" required>
							<%-- Sửa: Đổi name từ "name" thành "customerName" để khớp với tbl_Order --%>
						</div>
						<div class="col-md-12 form-group p_star">
							<input type="text" class="form-control" id="phone" name="phone"
								placeholder="Số điện thoại" required>
						</div>
						<div class="col-md-12 form-group p_star">
							<input type="text" class="form-control" id="address"
								name="address" placeholder="Địa chỉ" required>
						</div>
						<div class="col-md-12 form-group">
							<textarea class="form-control" name="note" id="note" rows="1"
								placeholder="Ghi chú"></textarea>
						</div>

					</div>
					
					<div class="col-lg-7">
						<div class="order_box">
							<h2>Đơn hàng của bạn</h2>

							<%-- *** CODE HIỂN THỊ GIỎ HÀNG (GIỮ NGUYÊN HOẶC DÙNG CODE BÀI TRƯỚC) *** --%>
							<ul class="list">
								<c:forEach var="item" items="${cartItems}">
									<li><a href="#"> ${item.name} <span class="middle">x
												${item.quantity}</span> <span class="last"> <fmt:formatNumber
													value="${item.totalPrice}" type="number" pattern="#,###" />
												VNĐ
										</span>
									</a></li>
								</c:forEach>
							</ul>
							<ul class="list list_2">
								<li><a href="#">Tổng tiền <span> <fmt:formatNumber
												value="${grandTotal}" type="number" pattern="#,###" /> VNĐ
									</span> <%-- Thêm hidden input cho Tổng tiền (cần cho Servlet) --%> <input
										type="hidden" name="totalAmount" value="${grandTotal}" />
								</a></li>
							</ul>
							<div class="creat_account">
								<input type="checkbox" id="terms" name="terms" required>
								<label for="terms">Tôi đã đọc và chấp nhận </label> <a href="#">điều
									khoản &amp; điều kiện*</a>
							</div>

							<%-- *** BƯỚC 3: SỬA NÚT ĐẶT HÀNG *** --%>
							<button type="submit" class="btn_3">Đặt hàng</button>

						</div>
					</div>

				</form>
				<%-- *** KẾT THÚC FORM ĐẶT HÀNG TẠI ĐÂY *** --%>

			</div>
		</div>
	</div>
</section>
<jsp:include page="footer.jsp"></jsp:include>
