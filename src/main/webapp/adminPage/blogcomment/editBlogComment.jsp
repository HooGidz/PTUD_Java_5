<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                </nav>

                <div class="p-2">
                    <h1>Sửa thông tin bình luận</h1>
                </div>

                <div style="padding: 0px 30px;">

                    <form action="${pageContext.request.contextPath}/BlogCommentController?action=edit" method="post">

                        <!-- ID ẩn -->
                        <input type="hidden" name="commentId" value="${blogcommentDetail.commentId}">

                        <div class="pb-3">
                            <label class="form-label">Tên</label>
                            <input value="${blogcommentDetail.name}" name="name" type="text" 
                                   class="form-control" placeholder="Tên">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Số điện thoại</label>
                            <input value="${blogcommentDetail.phone}" name="phone" type="text" 
                                   class="form-control" placeholder="Số điện thoại">
                        </div>
                        <div class="pb-3">
                            <label class="form-label">Email</label>
                            <input value="${blogcommentDetail.email}" name="email" type="email" 
                                   class="form-control" placeholder="email">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Nội dung</label>
                            <textarea name="detail" class="form-control" rows="3">${blogcommentDetail.detail}</textarea>
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Ngày tạo</label>
                            <input value="${blogcommentDetail.createddate}" name="createddate" type="date" 
                                   class="form-control" placeholder="ngày">
                        </div>

                        <div class="pb-3">
                            <label class="form-label">Mã bài viết</label>
                            <input value="${blogcommentDetail.blogId}" name="blogId" type="number" 
                                   class="form-control">
                        </div>

                        <!-- isActive -->
                        <div class="pb-3">
                            <label class="form-label">Trạng thái</label>
                            <select name="isactive" class="form-select">
                                <c:choose>
                                    <c:when test="${blogcommentDetail.isactive}">
                                        <option value="1" selected>Hiện</option>
                                        <option value="0">Ẩn</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="1">Hiện</option>
                                        <option value="0" selected>Ẩn</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </div>
                        
                        <button type="submit" class="btn btn-primary mt-3">Cập nhật bình luận</button>
                    </form>

                    <button onclick='history.back()' class="btn btn-secondary mt-3">Quay lại</button>
                </div>

            </div>
        </div>

        <div class="layout-overlay layout-menu-toggle"></div>
    </div>

    <script src="/Java_5/adminPage/asset/vendor/libs/jquery/jquery.js"></script>
    <script src="/Java_5/adminPage/asset/vendor/js/bootstrap.js"></script>
</body>
</html>