<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="vi">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>${blog.title} - Aranoz Hotel</title>
    <link rel="icon" href="img/favicon.png">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/slick.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
 
<jsp:include page="header.jsp" />

<section class="breadcrumb breadcrumb_bg">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8">
                    <div class="breadcrumb_iner">
                        <div class="breadcrumb_iner_item">
                            <h2>Chi tiết bài viết</h2>
                            <p>Trang chủ <span>-</span> Chi tiết tin tức</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- breadcrumb start-->

<!-- Nội dung chi tiết + bình luận -->
<section class="blog_area single-post-area section_padding">
    <div class="container">
        <div class="row">

            <!-- Cột chính -->
            <div class="col-lg-8 posts-list">
                <div class="single-post">

                    <!-- Ảnh đại diện -->
                    <div class="feature-img">
                        <img class="img-fluid rounded" 
                             src="${blog.image}" 
                             alt="${blog.title}"
                             style="box-shadow: 0 15px 35px rgba(0,0,0,0.1);">
                    </div>

                    <div class="blog_details">
                        <h2 class="mt-4 mb-3">${blog.title}</h2>
                        <ul class="blog-info-link mt-3 mb-4">
                            <li><i class="far fa-user"></i> ${not empty blog.createby ? blog.createby : 'Admin'}</li>
                            <li><i class="far fa-calendar-alt"></i> <fmt:formatDate value="${blog.createdate}" pattern="dd MMMM, yyyy"/></li>
                            <li><i class="far fa-comments"></i> ${commentList.size()} bình luận</li>
                        </ul>

                        <p class="excert" style="font-size:18px; color:#444;">${blog.description}</p>
                        <div style="font-size:17px; line-height:1.9; color:#555; margin-top:30px;">
                            ${blog.detail}
                        </div>
                    </div>
                </div>

                
            <!-- Sidebar -->
            <div class="col-lg-4">
                <div class="blog_right_sidebar">
                    <!-- Danh mục -->
                    <aside class="single_sidebar_widget post_category_widget">
                        <h4 class="widget_title">Danh mục</h4>
                        <ul class="list cat-list">
                            <c:forEach items="${listCategory}" var="cat">
                                <li>
                                    <a href="BlogController?cate=${cat.categoryId}" class="d-flex justify-content-between">
                                        <p>${cat.name}</p>
                                        <p class="text-muted">(${cat.blogCount})</p>
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </aside>

                    <!-- Tin tức gần nhất -->
                    <aside class="single_sidebar_widget popular_post_widget">
                        <h3 class="widget_title">Tin tức gần nhất</h3>
                        <c:forEach items="${recentPosts}" var="p">
                            <div class="media post_item mb-3">
                                <img src="${p.image}" alt="${p.title}"
                                     style="width:80px;height:80px;object-fit:cover;border-radius:8px;">
                                <div class="media-body ml-3">
                                    <a href="blog-detail?id=${p.blogId}">
                                        <h3 style="font-size:15px;line-height:1.4;">${p.title}</h3>
                                    </a>
                                    <p class="text-muted small mt-1">
                                        <fmt:formatDate value="${p.createdate}" pattern="dd MMM, yyyy"/>
                                    </p>
                                </div>
                            </div>
                        </c:forEach>
                    </aside>
                </div>
            </div>

        </div>
    </div>
</section>

<jsp:include page="footer.jsp" />

<!-- JS -->
<script src="js/jquery-1.12.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.magnific-popup.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/custom.js"></script>
</body>
</html>