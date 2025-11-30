<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
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
	<!--::header part start::-->
	<jsp:include page="header.jsp" />
	<!--================Home Banner Area =================-->
	<!-- breadcrumb start-->
	<section class="breadcrumb breadcrumb_bg">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="breadcrumb_iner">
						<div class="breadcrumb_iner_item">
							<h2>Sản phẩm</h2>
							<p>
								Trang chủ <span>/</span> Sản phẩm
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- breadcrumb start-->

	<!--================Category Product Area =================-->
	<section class="cat_product_area section_padding">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="left_sidebar_area">
						<aside class="left_widgets p_filter_widgets">
							<div class="l_w_title">
								<h3>Danh mục sản phẩm</h3>
							</div>
							<div class="widgets_inner">
								<ul class="list">

									<c:forEach items="${listCategory}" var="o">
										<li class="${tag == o.categoryId ? 'active' : ''}"><a
											href="${pageContext.request.contextPath}/ProductController?cid=${o.categoryId}">
												${o.name} </a></li>
									</c:forEach>

									<li class="btn btn-primary"><a href="ProductController"
										class="text-white">Tất cả sản phẩm</a></li>


								</ul>
							</div>
						</aside>
						<!-- 
                        <aside class="left_widgets p_filter_widgets">
                            <div class="l_w_title">
                                <h3>Product filters</h3>
                            </div>
                            <div class="widgets_inner">
                                <ul class="list">
                                    <li>
                                        <a href="#">Apple</a>
                                    </li>
                                    <li>
                                        <a href="#">Asus</a>
                                    </li>
                                    <li class="active">
                                        <a href="#">Gionee</a>
                                    </li>
                                    <li>
                                        <a href="#">Micromax</a>
                                    </li>
                                    <li>
                                        <a href="#">Samsung</a>
                                    </li>
                                </ul>
                                <ul class="list">
                                    <li>
                                        <a href="#">Apple</a>
                                    </li>
                                    <li>
                                        <a href="#">Asus</a>
                                    </li>
                                    <li class="active">
                                        <a href="#">Gionee</a>
                                    </li>
                                    <li>
                                        <a href="#">Micromax</a>
                                    </li>
                                    <li>
                                        <a href="#">Samsung</a>
                                    </li>
                                </ul>
                            </div>
                        </aside>

                        <aside class="left_widgets p_filter_widgets">
                            <div class="l_w_title">
                                <h3>Color Filter</h3>
                            </div>
                            <div class="widgets_inner">
                                <ul class="list">
                                    <li>
                                        <a href="#">Black</a>
                                    </li>
                                    <li>
                                        <a href="#">Black Leather</a>
                                    </li>
                                    <li class="active">
                                        <a href="#">Black with red</a>
                                    </li>
                                    <li>
                                        <a href="#">Gold</a>
                                    </li>
                                    <li>
                                        <a href="#">Spacegrey</a>
                                    </li>
                                </ul>
                            </div>
                        </aside>

                        <aside class="left_widgets p_filter_widgets price_rangs_aside">
                            <div class="l_w_title">
                                <h3>Price Filter</h3>
                            </div>
                            <div class="widgets_inner">
                                <div class="range_item">
                                    <div id="slider-range"></div>
                                    <input type="text" class="js-range-slider" value="" />
                                    <div class="d-flex">
                                        <div class="price_text">
                                            <p>Price :</p>
                                        </div>
                                        <div class="price_value d-flex justify-content-center">
                                            <input type="text" class="js-input-from" id="amount" readonly />
                                            <span>to</span>
                                            <input type="text" class="js-input-to" id="amount" readonly />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </aside>
                     -->
					</div>
				</div>
				<div class="col-lg-9">
					<div class="row">
						<div class="col-lg-12">
							<div
								class="product_top_bar d-flex justify-content-between align-items-center">
								<div class="single_product_menu">
									<p>
										<span>10000 </span> Prodict Found
									</p>
								</div>
								<div class="single_product_menu d-flex">
									<h5>short by :</h5>
									<select>
										<option data-display="Select">name</option>
										<option value="1">price</option>
										<option value="2">product</option>
									</select>
								</div>
								<div class="single_product_menu d-flex">
									<h5>show :</h5>
									<div class="top_pageniation">
										<ul>
											<li>1</li>
											<li>2</li>
											<li>3</li>
										</ul>
									</div>
								</div>
								<div class="single_product_menu d-flex">
									<div class="input-group">
										<input type="text" class="form-control" placeholder="search"
											aria-describedby="inputGroupPrepend">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroupPrepend"><i
												class="ti-search"></i></span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row align-items-center latest_product_inner">
						<c:forEach items="${listProduct}" var="o">
							<div class="col-lg-4 col-sm-6">
								<div class="single_product_item">
									<img src="img/product/product_4.png" alt="">
									<div class="single_product_text">
										<h4>${o.name}</h4>
										<h3>
											<fmt:formatNumber value="${o.price}" type="number"
												groupingUsed="true" />
											VNĐ
										</h3>
										<a href="#" class="add_cart">+ Thêm giỏ hàng<i
											class="ti-heart"></i></a>
									</div>
								</div>
							</div>
						</c:forEach>

						<div class="col-lg-12">
							<div class="pageination">
								<nav aria-label="Page navigation example">
									<ul class="pagination justify-content-center">

										<!-- Previous -->
										<li class="page-item ${page == 1 ? 'disabled' : ''}"><c:url
												var="prevUrl" value="ProductController">
												<c:param name="index" value="${page - 1}" />
												<c:if test="${not empty tag}">
													<c:param name="cid" value="${tag}" />
												</c:if>
											</c:url> <a class="page-link" href="${prevUrl}"> <i
												class="ti-angle-double-left"></i>
										</a></li>

										<!-- Page numbers -->
										<c:forEach begin="1" end="${totalPage}" var="i">
											<li class="page-item ${i == page ? 'active' : ''}"><c:url
													var="pageUrl" value="ProductController">
													<c:param name="index" value="${i}" />
													<c:if test="${not empty tag}">
														<c:param name="cid" value="${tag}" />
													</c:if>
												</c:url> <a class="page-link" href="${pageUrl}">${i}</a></li>
										</c:forEach>

										<!-- Next -->
										<li class="page-item ${page == totalPage ? 'disabled' : ''}">
											<c:url var="nextUrl" value="ProductController">
												<c:param name="index" value="${page + 1}" />
												<c:if test="${not empty tag}">
													<c:param name="cid" value="${tag}" />
												</c:if>
											</c:url> <a class="page-link" href="${nextUrl}"> <i
												class="ti-angle-double-right"></i>
										</a>
										</li>

									</ul>

								</nav>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Category Product Area =================-->

	<!-- product_list part start-->
	<section class="product_list best_seller">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-12">
					<div class="section_tittle text-center">
						<h2>
							Sản phẩm bán chạy <span>shop</span>
						</h2>
					</div>
				</div>
			</div>
			<div class="row align-items-center justify-content-between">
				<div class="col-lg-12">
					<div class="best_product_slider owl-carousel">
						<c:forEach items="${listBestSeller}" var="o">
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