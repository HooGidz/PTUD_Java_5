<%-- File: webapp/viewCart.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Collection"%>
<%@ page import="db.CartItem"%>
<%
@SuppressWarnings("unchecked")
Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
Collection<CartItem> cartItems = (cart == null) ? java.util.Collections.<CartItem>emptyList() : cart.values();

double grandTotal = 0;
for (CartItem item : cartItems) {
	grandTotal += item.getTotalPrice();
}
request.setAttribute("cartItems", cartItems);
request.setAttribute("grandTotal", grandTotal);
%>
<jsp:include page="header.jsp"></jsp:include>
<section class="cart_area padding_top">
	<div class="container">
		<div class="cart_inner">
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Sản phẩm</th>
							<th scope="col">Giá</th>
							<th scope="col">Số lượng</th>
							<th scope="col">Thành tiền</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty cartItems}">
								<c:forEach var="item" items="${cartItems}" varStatus="loop">
									<tr>
										<td>
											<div class="media">
												<div class="d-flex">
													<img src="/Java_5${item.image}" alt="${item.name}" width="80" />
												</div>
												<div class="media-body">
													<p>${item.name}</p>
												</div>
											</div>
										</td>
										<td>
											<h5>
												<fmt:formatNumber value="${item.price}" type="number"
													pattern="#,###" />
												VNĐ
											</h5>
										</td>
										<td>
											<form
												action="${pageContext.request.contextPath}/CartController"
												method="post"
												style="display: flex; align-items: center; gap: 6px;">
												<input type="hidden" name="productID"
													value="${item.productId}" /> <input type="hidden"
													name="action" value="update" /> <input type="number"
													name="quantity" value="${item.quantity}" min="1"
													class="form-control" style="width: 80px;" />
												<button type="submit" class="btn btn-sm btn-primary">Cập
													nhật</button>
											</form>
										</td>
										<td>
											<h5>
												<fmt:formatNumber value="${item.totalPrice}" type="number"
													pattern="#,###" />
												VNĐ
											</h5>
										</td>
										<td>
											<form
												action="${pageContext.request.contextPath}/CartController"
												method="post">
												<input type="hidden" name="productID"
													value="${item.productId}" /> <input type="hidden"
													name="action" value="remove" />
												<button type="submit" class="btn btn-danger btn-sm">Xóa</button>
											</form>
										</td>
									</tr>
								</c:forEach>

								<tr>
									<td colspan="3" class="text-right">
										<h5>Tổng tiền</h5>
									</td>
									<td colspan="2">
										<h5>
											<fmt:formatNumber value="${grandTotal}" type="number"
												pattern="#,###" />
											VNĐ
										</h5>
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="5" class="text-center">Giỏ hàng trống.</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
				<div class="d-flex justify-content-between">
					<div>
						<a class="btn_1"
							href="${pageContext.request.contextPath}/san-pham">Tiếp tục <%-- Sửa: thêm đường dẫn --%>
							mua sắm</a>
					</div>
					<div>
						<a class="btn_1 checkout_btn_1"
							href="${pageContext.request.contextPath}/Checkout">Thanh
							toán</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<jsp:include page="footer.jsp"></jsp:include>
