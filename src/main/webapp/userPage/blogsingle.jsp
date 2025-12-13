<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
								<li class="nav-item"><a class="nav-link" href="index.html">Trang chủ</a>
								</li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="blog.html"
									id="navbarDropdown_1" role="button" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"> Sản phẩm </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
										<a class="dropdown-item" href="category.html"> Danh mục cửa hàng</a> <a class="dropdown-item" href="single-product.html">Chi tiết sản phẩm</a>

									</div></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="blog.html"
									id="navbarDropdown_3" role="button" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false">Trang </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown_2">
										<a class="dropdown-item" href="login.html"> Đăng nhập</a> <a
											class="dropdown-item" href="tracking.html">Theo dõi</a> <a
											class="dropdown-item" href="checkout.html">hoàn tất thanh toán sản phẩm</a> <a class="dropdown-item" href="cart.html">giỏ hàng mua sắm</a> <a class="dropdown-item" href="confirmation.html">xác nhận</a>
										<a class="dropdown-item" href="elements.html">Yếu tố</a>
									</div></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="blog.html"
									id="navbarDropdown_2" role="button" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"> Bài viết </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown_2">
										<a class="dropdown-item" href="blog.html"> Bài viết</a> <a
											class="dropdown-item" href="single-blog.html">Bài viết chi tiết</a>
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
	<!-- Header part end-->

	<!--================Home Banner Area =================-->
	<!-- breadcrumb start-->
	<section class="breadcrumb breadcrumb_bg">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="breadcrumb_iner">
						<div class="breadcrumb_iner_item">
							<h2>Bài viết chi tiết</h2>
							<p>
								Trang chủ<span>-</span> Bài viết chi tiết
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- breadcrumb start-->
	<!--================Blog Area =================-->
	<section class="blog_area single-post-area padding_top">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 posts-list">
					<div class="single-post">
						<div class="feature-img">
							<img class="img-fluid" src="${blog.image}" alt="${blog.title}">
						</div>
						<div class="blog_details">
							<h2>${blog.title}</h2>
							<ul class="blog-info-link mt-3 mb-4">
								<li><i class="far fa-user"></i> ${empty blog.createBy ? 'Admin' : blog.createBy}
								</li>

								<li><i class="far fa-calendar-alt"></i> <fmt:formatDate
										value="${blog.createDate}" pattern="dd/MM/yyyy" /></li>
							</ul>
							<p class="excert">${blog.description}</p>
							<div class="blog-content">
								<c:out value="${blog.detail}" escapeXml="false" />
							</div>
						</div>
					</div>
					<div class="navigation-top">
						<div class="d-sm-flex justify-content-between text-center">
							<p class="like-info">
								<span class="align-middle"> <i class="far fa-heart"></i>
								</span> ${commentList.size()} bình luận
							</p>

							<ul class="social-icons">
								<li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
								<li><a href="#"><i class="fab fa-twitter"></i></a></li>
								<li><a href="#"><i class="fab fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fab fa-behance"></i></a></li>
							</ul>
						</div>

						<div class="navigation-area">
							<div class="row">

								<!-- PREV BLOG -->
								<c:if test="${prevBlog != null}">
									<div
										class="col-lg-6 col-md-6 col-12 nav-left d-flex align-items-center">
										<div class="thumb">
											<a
												href="${pageContext.request.contextPath}/blog-detail?id=${prevBlog.blogId}">
												<img class="img-fluid" src="${prevBlog.image}" alt="">
											</a>
										</div>
										<div class="arrow">
											<a
												href="${pageContext.request.contextPath}/blog-detail?id=${prevBlog.blogId}">
												<span class="lnr text-white ti-arrow-left"></span>
											</a>
										</div>
										<div class="detials">
											<p>Bài trước</p>
											<a
												href="${pageContext.request.contextPath}/blog-detail?id=${prevBlog.blogId}">
												<h4>${prevBlog.title}</h4>
											</a>
										</div>
									</div>
								</c:if>

								<!-- NEXT BLOG -->
								<c:if test="${nextBlog != null}">
									<div
										class="col-lg-6 col-md-6 col-12 nav-right d-flex align-items-center justify-content-end">
										<div class="detials">
											<p>Bài tiếp theo</p>
											<a
												href="${pageContext.request.contextPath}/blog-detail?id=${nextBlog.blogId}">
												<h4>${nextBlog.title}</h4>
											</a>
										</div>
										<div class="arrow">
											<a
												href="${pageContext.request.contextPath}/blog-detail?id=${nextBlog.blogId}">
												<span class="lnr text-white ti-arrow-right"></span>
											</a>
										</div>
										<div class="thumb">
											<a
												href="${pageContext.request.contextPath}/blog-detail?id=${nextBlog.blogId}">
												<img class="img-fluid" src="${nextBlog.image}" alt="">
											</a>
										</div>
									</div>
								</c:if>

							</div>
						</div>
					</div>

					<div class="blog-author">
						<div class="media align-items-center">
							<img src="img/blog/author.png" alt="">
							<div class="media-body">
								<h4>${empty blog.createBy ? 'Admin' : blog.createBy}</h4>
								<p>
									Bài viết được đăng ngày
									<fmt:formatDate value="${blog.createDate}" pattern="dd/MM/yyyy" />
								</p>
							</div>
						</div>
					</div>

					<div class="comments-area">
						<h4>${commentList.size()}bìnhluận</h4>

						<c:forEach items="${commentList}" var="c">
							<div class="comment-list">
								<div class="single-comment d-flex">
									<div class="desc">
										<p class="comment">${c.detail}</p>
										<div class="d-flex justify-content-between">
											<h5>${c.name}</h5>
											<p class="date">
												<fmt:formatDate value="${c.createddate}"
													pattern="dd/MM/yyyy HH:mm" />
											</p>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>

					<div class="comment-form">
						<h4>Để lại bình luận</h4>
						<form action="${pageContext.request.contextPath}/blog-detail"
							method="post" class="form-contact comment_form">

							<input type="hidden" name="blogId" value="${blog.blogId}" />

							<div class="form-group">
								<textarea class="form-control w-100" name="detail" rows="5"
									placeholder="Nhập bình luận..." required></textarea>
							</div>

							<div class="form-group">
								<input class="form-control" name="name" type="text"
									placeholder="Tên của bạn" required>
							</div>

							<div class="form-group">
								<input class="form-control" name="phone" type="text"
									placeholder="Số điện thoại">
							</div>

							<div class="form-group">
								<input class="form-control" name="email" type="email"
									placeholder="Email" required>
							</div>

							<button type="submit" class="btn_3 button-contactForm">
								Gửi bình luận</button>
						</form>

					</div>
				</div>
				<div class="col-lg-4">
					<div class="blog_right_sidebar">
						<aside class="single_sidebar_widget search_widget">
							<form action="#">
								<div class="form-group">
									<div class="input-group mb-3">
										<input type="text" class="form-control"
											placeholder='Tìm kiếm bài viết' onfocus="this.placeholder = ''"
											onblur="this.placeholder = 'Tìm kiếm bài viết'">
										<div class="input-group-append">
											<button class="btn" type="button">
												<i class="ti-search"></i>
											</button>
										</div>
									</div>
								</div>
								<button
									class="button rounded-0 primary-bg text-white w-100 btn_1"
									type="submit">Tìm kiếm</button>
							</form>
						</aside>
						<aside class="single_sidebar_widget post_category_widget">
							<h4 class="widget_title">Danh mục</h4>
							<ul class="list cat-list">
								<c:forEach items="${listCategory}" var="cat">
									<li><a href="BlogController?cate=${cat.categoryId}"
										class="d-flex justify-content-between">
											<p>${cat.name}</p>
											<p>(${cat.blogCount})</p>
									</a></li>
								</c:forEach>
							</ul>
						</aside>

						<aside class="single_sidebar_widget popular_post_widget">
							<h3 class="widget_title">Bài viết gần nhất</h3>

							<c:forEach items="${recentPosts}" var="p">
								<div class="media post_item">
									<img src="${p.image}" alt="${p.title}"
										style="width: 80px; height: 80px; object-fit: cover">
									<div class="media-body">
										<a
											href="${pageContext.request.contextPath}/blog-detail?id=${p.blogId}">
											<h3>${p.title}</h3>
										</a>
										<p>
											<fmt:formatDate value="${p.createDate}" pattern="dd/MM/yyyy" />
										</p>
									</div>
								</div>
							</c:forEach>
						</aside>

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
						<aside class="single_sidebar_widget instagram_feeds">
							<h4 class="widget_title">Bảng tin Instagram</h4>
							<ul class="instagram_row flex-wrap">
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_5.png" alt="">
								</a></li>
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_6.png" alt="">
								</a></li>
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_7.png" alt="">
								</a></li>
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_8.png" alt="">
								</a></li>
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_9.png" alt="">
								</a></li>
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_10.png" alt="">
								</a></li>
							</ul>
						</aside>
						<aside class="single_sidebar_widget newsletter_widget">
							<h4 class="widget_title">Bản tin</h4>
							<form action="#">
								<div class="form-group">
									<input type="email" class="form-control"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'Enter email'"
										placeholder='Enter email' required>
								</div>
								<button
									class="button rounded-0 primary-bg text-white w-100 btn_1"
									type="submit">Đăng ký</button>
							</form>
						</aside>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================Blog Area end =================-->

	<!--::footer_part start::-->
	<footer class="footer_part">
		<div class="container">
			<div class="row justify-content-around">
				<div class="col-sm-6 col-lg-2">
					<div class="single_footer_part">
						<h4>Top Products</h4>
						<ul class="list-unstyled">
							<li><a href="">Managed Website</a></li>
							<li><a href="">Manage Reputation</a></li>
							<li><a href="">Power Tools</a></li>
							<li><a href="">Marketing Service</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6 col-lg-2">
					<div class="single_footer_part">
						<h4>Quick Links</h4>
						<ul class="list-unstyled">
							<li><a href="">Jobs</a></li>
							<li><a href="">Brand Assets</a></li>
							<li><a href="">Investor Relations</a></li>
							<li><a href="">Terms of Service</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6 col-lg-2">
					<div class="single_footer_part">
						<h4>Features</h4>
						<ul class="list-unstyled">
							<li><a href="">Jobs</a></li>
							<li><a href="">Brand Assets</a></li>
							<li><a href="">Investor Relations</a></li>
							<li><a href="">Terms of Service</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6 col-lg-2">
					<div class="single_footer_part">
						<h4>Resources</h4>
						<ul class="list-unstyled">
							<li><a href="">Guides</a></li>
							<li><a href="">Research</a></li>
							<li><a href="">Experts</a></li>
							<li><a href="">Agencies</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6 col-lg-4">
					<div class="single_footer_part">
						<h4>Newsletter</h4>
						<p>Heaven fruitful doesn't over lesser in days. Appear
							creeping</p>
						<div id="mc_embed_signup">
							<form target="_blank"
								action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
								method="get" class="subscribe_form relative mail_part">
								<input type="email" name="email" id="newsletter-form-email"
									placeholder="Email Address" class="placeholder hide-on-focus"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = ' Email Address '">
								<button type="submit" name="submit" id="newsletter-submit"
									class="email_icon newsletter-submit button-contactForm">subscribe</button>
								<div class="mt-10 info"></div>
							</form>
						</div>
					</div>
				</div>
			</div>

		</div>
		<div class="copyright_part">
			<div class="container">
				<div class="row">
					<div class="col-lg-8">
						<div class="copyright_text">
							<P>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;
								<script>document.write(new Date().getFullYear());</script>
								All rights reserved | This template is made with <i
									class="ti-heart" aria-hidden="true"></i> by <a
									href="https://colorlib.com" target="_blank">Colorlib</a>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</P>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="footer_icon social_icon">
							<ul class="list-unstyled">
								<li><a href="#" class="single_social_icon"><i
										class="fab fa-facebook-f"></i></a></li>
								<li><a href="#" class="single_social_icon"><i
										class="fab fa-twitter"></i></a></li>
								<li><a href="#" class="single_social_icon"><i
										class="fas fa-globe"></i></a></li>
								<li><a href="#" class="single_social_icon"><i
										class="fab fa-behance"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!--::footer_part end::-->

	<!-- jquery plugins here-->
	<!-- jquery -->
	<script src="js/jquery-1.12.1.min.js"></script>
	<!-- popper js -->
	<script src="js/popper.min.js"></script>
	<!-- bootstrap js -->
	<script src="js/bootstrap.min.js"></script>
	<!-- easing js -->
	<script src="js/jquery.magnific-popup.js"></script>
	<!-- swiper js -->
	<script src="js/swiper.min.js"></script>
	<!-- swiper js -->
	<script src="js/masonry.pkgd.js"></script>
	<!-- particles js -->
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<!-- slick js -->
	<script src="js/slick.min.js"></script>
	<script src="js/jquery.counterup.min.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/contact.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.form.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/mail-script.js"></script>
	<!-- custom js -->
	<script src="js/custom.js"></script>
</body>

</html>