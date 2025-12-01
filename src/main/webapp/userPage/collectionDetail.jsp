<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zxx">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Nội thất</title>
<link rel="icon" href="img/favicon.png">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- animate CSS -->
<link rel="stylesheet" href="css/animate.css">
<!-- owl carousel CSS -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/lightslider.min.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="css/all.css">
<!-- flaticon CSS -->
<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/themify-icons.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="css/magnific-popup.css">
<!-- style CSS -->
<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<!--::header part start::-->
	<jsp:include page="header.jsp" />
	<!-- Header part end-->

	<!-- breadcrumb start-->
	<section class="breadcrumb breadcrumb_bg">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="breadcrumb_iner">
						<div class="breadcrumb_iner_item">
							<h2>Chi tiết bộ sưu tập</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- breadcrumb start-->
	<!--================End Home Banner Area =================-->

	<!--================Single Product Area =================-->
	<div class="product_image_area section_padding">
		<div class="container">
			<div class="row s_product_inner justify-content-between">
				<div class="col-lg-7 col-xl-7">
					<div class="product_slider_img">
						<div id="vertical">
							<div data-thumb="img/product/single-product/product_1.png">
								<img src="img/product/single-product/product_1.png" />
							</div>
							
						</div>
					</div>
				</div>
				<div class="col-lg-5 col-xl-4">
					<div class="s_product_text">
						<h3>${collection.name}</h3>
						<ul class="list">
							<li><a class="active" href="#"> <span>Nhà thiết
										kế</span> : ${collection.designer}
							</a></li>
							<li><a href="#"> <span>Maker</span> :
									${collection.maker}
							</a></li>
						</ul>
						<p>${collection.description}</p>

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
				<li class="nav-item"><a class="nav-link active" id="home-tab"
					data-toggle="tab" href="#home" role="tab" aria-controls="home"
					aria-selected="true">Mô tả</a></li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="home" role="tabpanel"
					aria-labelledby="home-tab">
					<p>${collection.detail}</p>
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
							Sản phẩm trong bộ sưu tập 
						</h2>
					</div>
				</div>
			</div>
			<div class="row align-items-center justify-content-between">
				<div class="col-lg-12">
					<div class="best_product_slider owl-carousel">
						<c:forEach items="${products}" var="o">
							<div class="single_product_item">
								<img src="img/product/product_1.png" alt="">
								<div class="single_product_text">
									<h4>${o.name}</h4>
									<h3>
											<fmt:formatNumber value="${o.price}" type="number"
												groupingUsed="true" />
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

	<!--::footer_part start::-->
	<jsp:include page="footer.jsp" />
</body>

</html>