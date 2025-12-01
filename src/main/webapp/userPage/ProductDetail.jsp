<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Nội thất</title>
<link rel="icon" href="/Java_5/img/favicon.png">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="/Java_5/css/bootstrap.min.css">
<!-- animate CSS -->
<link rel="stylesheet" href="/Java_5/css/animate.css">
<!-- owl carousel CSS -->
<link rel="stylesheet" href="/Java_5/css/owl.carousel.min.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="/Java_5/css/all.css">
<!-- flaticon CSS -->
<link rel="stylesheet" href="/Java_5/css/flaticon.css">
<link rel="stylesheet" href="/Java_5/css/themify-icons.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="/Java_5/css/magnific-popup.css">
<!-- swiper CSS -->
<link rel="stylesheet" href="/Java_5/css/slick.css">
<!-- style CSS -->
<link rel="stylesheet" href="/Java_5/css/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!--================Single Product Area =================-->
	<div class="product_image_area section_padding">
		<div class="container">
			<div class="row s_product_inner justify-content-between">
				<div class="col-lg-7 col-xl-7">
					<div class="product_slider_img">
						<div id="vertical">
							<div data-thumb="img/product/single-product/product_1.png">
								<img src="/Java_5/${detail.image }" />
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-5 col-xl-4">
					<div class="s_product_text">
						<!-- <h5>previous <span>|</span> next</h5> -->
						<h3>${detail.name}</h3>
						<h2>
							<fmt:formatNumber value="${detail.price}" type="number"
								maxFractionDigits="0" />
							VNĐ
						</h2>
						<ul class="list">
							<li><a class="active" href="#"> <span>Danh mục</span> :
									${detail.categoryId }
							</a></li>
							<c:choose>
								<c:when test="${detail.quantity gt 0}">
									<li><a href="#"> <span>Tình trạng</span> : Còn hàng
									</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="#"> <span>Tình trạng</span> : Hết hàng
									</a></li>
								</c:otherwise>
							</c:choose>

						</ul>
						<p>${detail.description}</p>
						<div
							class="card_area d-flex justify-content-between align-items-center">

							<form action="${pageContext.request.contextPath}/AddToCart"
								method="get"
								class="card_area d-flex justify-content-between align-items-center">
								<input type="hidden" name="id" value="${detail.productId}" /> <input
									type="hidden" name="name" value="${detail.name}" /> <input
									type="hidden" name="price" value="${detail.price}" /> <input
									type="hidden" name="image" value="${detail.image}" />
								<div class="product_count">
									<span class="inumber-decrement"> <i class="ti-minus"></i></span>
									<input class="input-number" type="number" name="quantity"
										value="1" min="1" /> <span class="number-increment"> <i
										class="ti-plus"></i></span>
								</div>
								<button type="submit" class="btn_3">Thêm vào giỏ</button>

							</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--================End Single Product Area =================-->

	<!--================Product Description Area =================-->
	<section class="product_description_area">
		<div class="container">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item"><a class="nav-link" id="home-tab"
					data-toggle="tab" href="#home" role="tab" aria-controls="home"
					aria-selected="true">Chi tiết sản phẩm</a></li>
				<li class="nav-item"><a class="nav-link" id="profile-tab"
					data-toggle="tab" href="#profile" role="tab"
					aria-controls="profile" aria-selected="false">Thông số</a></li>
				<li class="nav-item"><a class="nav-link active" id="review-tab"
					data-toggle="tab" href="#review" role="tab" aria-controls="review"
					aria-selected="false">Đánh giá</a></li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade" id="home" role="tabpanel"
					aria-labelledby="home-tab">
					<p>${detail.detail }</p>
				</div>
				<div class="tab-pane fade" id="profile" role="tabpanel"
					aria-labelledby="profile-tab">
					<div class="table-responsive">
						<table class="table">
							<tbody>
								<tr>
									<td>
										<h5>Thương hiệu</h5>
									</td>
									<td>
										<h5>${detail.brands}</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>Chất liệu</h5>
									</td>
									<td>
										<h5>${detail.material}</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>Kích thước</h5>
									</td>
									<td>
										<h5>${detail.dimensions}</h5>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="tab-pane fade show active" id="review" role="tabpanel"
					aria-labelledby="review-tab">
					<div class="row">
						<div class="col-lg-6">
							<div class="row total_rate">
								<div class="col-6">
									<div class="box_total">
										<h5>Đánh giá</h5>
										<h4>4.0</h4>
										<h6>(${listProReview.size()} Đánh giá)</h6>
									</div>
								</div>
								<div class="col-6">
									<div class="rating_list">
										<h3>Dựa trên đánh giá</h3>
										<ul class="list">
											<li><a href="#">5 sao <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> 01
											</a></li>
											<li><a href="#">4 sao <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> 01
											</a></li>
											<li><a href="#">3 sa0 <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> 01
											</a></li>
											<li><a href="#">2 sao <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> 01
											</a></li>
											<li><a href="#">1 sao <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> 01
											</a></li>
										</ul>
									</div>
								</div>
							</div>
							<c:forEach items="${listProReview }" var="o">
								<div class="review_list">
									<div class="review_item">
										<div class="media">
											<div class="d-flex">
												<img src="img/product/single-product/review-1.png" alt="" />
											</div>
											<div class="media-body">
												<h4>${o.name}</h4>
												<c:forEach begin="1" end="${o.star}" var="i">
													<i class="fa fa-star checked"></i>
												</c:forEach>
											</div>
										</div>
										<p>${o.detail}</p>
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="col-lg-6">
							<div class="review_box">
								<h4>Thêm đánh giá</h4>
								<p>Đánh giá của bạn:</p>
								<ul class="list">
									<li><a href="#"> <i class="fa fa-star"></i>
									</a></li>
									<li><a href="#"> <i class="fa fa-star"></i>
									</a></li>
									<li><a href="#"> <i class="fa fa-star"></i>
									</a></li>
									<li><a href="#"> <i class="fa fa-star"></i>
									</a></li>
									<li><a href="#"> <i class="fa fa-star"></i>
									</a></li>
								</ul>
								<form class="row contact_form" action="ProductDetail?action=addsubmit"
									method="post" novalidate="novalidate">
									<input  value="${detail.productId }" name="productId" type="hidden"		/>
									<div class="col-md-12">
										<div class="form-group">
											<input type="text" class="form-control" name="name"
												placeholder="Họ tên của bạn" />
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<input type="email" class="form-control" name="email"
												placeholder="Địa chỉ email" />
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<input type="text" class="form-control" name="phone"
												placeholder="Số điện thoại" />
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<textarea class="form-control" name="detail" rows="1"
												placeholder="Viết đánh giá của bạn"></textarea>
										</div>
									</div>
									<div class="col-md-12 text-right">
										<button type="submit" value="submit" class="btn_3">
											Gửi đánh giá</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Product Description Area =================-->

	<!-- product_list part start-->
	<section class="product_list best_seller">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-12">
					<div class="section_tittle text-center">
						<h2>
							Sản phẩm bán chạy <span>cửa hàng</span>
						</h2>
					</div>
				</div>
			</div>
			<div class="row align-items-center justify-content-between">
				<div class="col-lg-12">
					<div class="best_product_slider owl-carousel">
						<c:forEach items="${listProBest}" var="o">
							<div class="single_product_item">
								<img src="/Java_5${o.image }" alt="">
								<div class="single_product_text">
									<h4>${o.name}</h4>
									<h3>
										<fmt:formatNumber value="${o.price}" type="number"
											maxFractionDigits="0" />
										VNĐ
									</h3>
								</div>
							</div>
						</c:forEach>

					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- product_list part end-->

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>