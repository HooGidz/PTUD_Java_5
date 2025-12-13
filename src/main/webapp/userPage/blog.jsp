<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<!-- font awesome CSS -->
<link rel="stylesheet" href="css/all.css">
<!-- flaticon CSS -->
<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/themify-icons.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="css/magnific-popup.css">
<!-- swiper CSS -->
<link rel="stylesheet" href="css/slick.css">
<!-- style CSS -->
<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<!--::header part start::-->
	<header class="main_menu home_menu">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-12">
					<nav class="navbar navbar-expand-lg navbar-light">
						<a class="navbar-brand" href="index.html"> <img
							src="img/logo.png" alt="logo">
						</a>
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="menu_icon"><i class="fas fa-bars"></i></span>
						</button>

						<div class="collapse navbar-collapse main-menu-item"
							id="navbarSupportedContent">
							<ul class="navbar-nav">
								<li class="nav-item"><a class="nav-link" href="index.html">Trang
										chủ</a></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="blog.html"
									id="navbarDropdown_1" role="button" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"> Sản phẩm </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
										<a class="dropdown-item" href="category.html"> Danh mục
											cửa hàng</a> <a class="dropdown-item" href="single-product.html">Chi
											tiết sản phẩm</a>

									</div></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="blog.html"
									id="navbarDropdown_3" role="button" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false">Trang </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown_2">
										<a class="dropdown-item" href="login.html"> Đăng nhập</a> <a
											class="dropdown-item" href="tracking.html">Theo dõi</a> <a
											class="dropdown-item" href="checkout.html">hoàn tất thanh
											toán sản phẩm</a> <a class="dropdown-item" href="cart.html">giỏ
											hàng mua sắm</a> <a class="dropdown-item"
											href="confirmation.html">xác nhận</a> <a
											class="dropdown-item" href="elements.html">Yếu tố</a>
									</div></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="blog.html"
									id="navbarDropdown_2" role="button" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"> Bài viết </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown_2">
										<a class="dropdown-item" href="blog.html"> Bài viết</a> <a
											class="dropdown-item" href="single-blog.html">Bài viết
											chi tiết</a>
									</div></li>

								<li class="nav-item"><a class="nav-link"
									href="contact.html">Liên hệ</a></li>
							</ul>
						</div>
						<div class="hearer_icon d-flex">
							<a id="search_1" href="javascript:void(0)"><i
								class="ti-search"></i></a> <a href=""><i class="ti-heart"></i></a>
							<div class="dropdown cart">
								<a class="dropdown-toggle" href="#" id="navbarDropdown3"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> <i class="fas fa-cart-plus"></i>
								</a>
								<!-- <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                  <div class="single_product">
  
                                  </div>
                              </div> -->

							</div>
						</div>
					</nav>
				</div>
			</div>
		</div>
		<div class="search_input" id="search_input_box">
			<div class="container ">
				<form class="d-flex justify-content-between search-inner">
					<input type="text" class="form-control" id="search_input"
						placeholder="Search Here">
					<button type="submit" class="btn"></button>
					<span class="ti-close" id="close_search" title="Close Search"></span>
				</form>
			</div>
		</div>
	</header>
	<!--================Home Banner Area =================-->
	<section class="breadcrumb breadcrumb_bg">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="breadcrumb_iner">
						<div class="breadcrumb_iner_item">
							<h2>Tin tức</h2>
							<p>
								Trang chủ <span>-</span> Tin tức
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- breadcrumb start-->

	<!--================Blog Area =================-->
	<section class="blog_area padding_top">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mb-5 mb-lg-0">
					<div class="blog_left_sidebar">

						<!-- Thông tin phân trang -->
						<div class="mb-4">
							<p class="text-muted">Hiển thị ${listP.size()} bài viết -
								Trang ${currentPage}/${totalPages} - Tổng cộng ${totalBlogs} bài
								viết</p>
						</div>

						<c:if test="${empty listP}">
							<div class="alert alert-info text-center">
								<h4>Không có bài viết nào</h4>
								<p>Hiện tại chưa có bài viết nào trong hệ thống.</p>
							</div>
						</c:if>

						<c:forEach items="${listP}" var="o">
							<article class="blog_item">
								<div class="blog_item_img">
									<c:choose>
										<c:when test="${not empty o.image}">
											<img class="card-img rounded-0" src="${o.image}"
												alt="${o.title}" style="height: 400px; object-fit: cover;">
										</c:when>
										<c:otherwise>
											<img class="card-img rounded-0" src="img/default-blog.jpg"
												alt="Default image"
												style="height: 400px; object-fit: cover;">
										</c:otherwise>
									</c:choose>
									<a href="#" class="blog_item_date">
										<h3>
											<fmt:formatDate value="${o.createDate}" pattern="dd" />
										</h3>
										<p>
											<fmt:formatDate value="${o.createDate}" pattern="MMM" />
										</p>
									</a>
								</div>

								<div class="blog_details">
									<a class="d-inline-block"
										href="${pageContext.request.contextPath}/blog-detail?id=${o.blogId}">
										<h2>${o.title}</h2>
									</a>
									<p>${o.description}</p>
									<ul class="blog-info-link">
										<li><i class="far fa-user"></i> ${not empty o.createBy ? o.createBy : 'Admin'}</li>
										<li><i class="far fa-calendar"></i> <fmt:formatDate
												value="${o.createDate}" pattern="dd/MM/yyyy HH:mm" /></li>
									</ul>
								</div>
							</article>
						</c:forEach>

						<!-- Phân trang -->
						<c:if test="${totalPages > 1}">
							<nav class="blog-pagination justify-content-center d-flex">
								<ul class="pagination">
									<!-- Nút Previous -->
									<li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
										<a href="BlogController?page=${currentPage - 1}"
										class="page-link"> <i class="ti-angle-left"></i>
									</a>
									</li>

									<!-- Các số trang -->
									<c:forEach begin="1" end="${totalPages}" var="i">
										<li class="page-item ${i == currentPage ? 'active' : ''}">
											<a href="BlogController?page=${i}" class="page-link">${i}</a>
										</li>
									</c:forEach>

									<!-- Nút Next -->
									<li
										class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
										<a href="BlogController?page=${currentPage + 1}"
										class="page-link"> <i class="ti-angle-right"></i>
									</a>
									</li>
								</ul>
							</nav>
						</c:if>
					</div>
				</div>

				<!-- Sidebar -->
				<div class="col-lg-4">
					<div class="blog_right_sidebar">
						<!-- Search Widget -->
						<aside class="single_sidebar_widget search_widget">
							<form action="#">
								<div class="form-group">
									<div class="input-group mb-3">
										<input type="text" class="form-control"
											placeholder='Tìm kiếm...' onfocus="this.placeholder = ''"
											onblur="this.placeholder = 'Tìm kiếm...'">
										<div class="input-group-append">
											<button class="btn" type="button">
												<i class="ti-search"></i>
											</button>
										</div>
									</div>
								</div>
							</form>
						</aside>

						<!-- Danh mục -->
						<aside class="single_sidebar_widget post_category_widget">
							<h4 class="widget_title">Danh mục</h4>
							<ul class="list cat-list">
								<c:if test="${empty listCategory}">
									<li><p class="text-muted">Chưa có danh mục nào</p></li>
								</c:if>
								<c:forEach items="${listCategory}" var="cat">
									<li><a href="BlogController?cate=${cat.categoryId}"
										class="d-flex justify-content-between">
											<p>${cat.name}</p>
											<p>(${cat.blogCount})</p>
									</a></li>
								</c:forEach>
							</ul>
						</aside>

						<!-- Bài viết gần nhất -->
						<aside class="single_sidebar_widget popular_post_widget">
							<h3 class="widget_title">Tin tức gần nhất</h3>
							<c:if test="${empty recentPosts}">
								<p class="text-muted">Chưa có bài viết nào</p>
							</c:if>
							<c:forEach items="${recentPosts}" var="p">
								<div class="media post_item mb-3">
									<img src="${p.image}" alt="${p.title}"
										style="width: 80px; height: 80px; object-fit: cover; border-radius: 8px;">
									<div class="media-body ml-3">
										<a href="blog-detail?id=${p.blogId}">
											<h3 style="font-size: 15px; line-height: 1.4; margin: 0;">${p.title}</h3>
										</a>
										<p style="font-size: 12px; color: #777; margin: 5px 0 0;">
											<fmt:formatDate value="${p.createDate}" pattern="dd/MM/yyyy" />
										</p>
									</div>
								</div>
							</c:forEach>
						</aside>

						<!-- Tag Clouds -->
						<aside class="single_sidebar_widget tag_cloud_widget">
							<h4 class="widget_title">Tags</h4>
							<ul class="list">
								<li><a href="#">Du lịch</a></li>
								<li><a href="#">Khách sạn</a></li>
								<li><a href="#">Ẩm thực</a></li>
								<li><a href="#">Giải trí</a></li>
								<li><a href="#">Văn hóa</a></li>
								<li><a href="#">Kinh nghiệm</a></li>
							</ul>
						</aside>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================Blog Area =================-->

	<jsp:include page="footer.jsp" />