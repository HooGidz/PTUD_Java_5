<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"></jsp:include>

<jsp:include page="header.jsp"></jsp:include>
<section class="breadcrumb breadcrumb_bg">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-8">
				<div class="breadcrumb_iner">
					<div class="breadcrumb_iner_item">
						<h2>Đặt hàng thành công</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<section class="confirmation_part section_padding">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="confirmation_text">
                    <c:if test="${requestScope.orderSuccess}">
                        <h4 class="text-success">${requestScope.message}</h4>
                        <p>Cảm ơn bạn đã đặt hàng! Một email xác nhận đã được gửi đến bạn (nếu có). Chúng tôi sẽ xử lý đơn hàng của bạn trong thời gian sớm nhất.</p>
                        <a href="${pageContext.request.contextPath}/" class="btn_3">Trở về trang chủ</a>
                    </c:if>
                    <c:if test="${not empty requestScope.error}">
                        <h4 class="text-danger">${requestScope.error}</h4>
                        <p>Đã xảy ra lỗi, vui lòng quay lại trang thanh toán để thử lại.</p>
                        <a href="${pageContext.request.contextPath}/Checkout" class="btn_3">Quay lại thanh toán</a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="footer.jsp"></jsp:include>