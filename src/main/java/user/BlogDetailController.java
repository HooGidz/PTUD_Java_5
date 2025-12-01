package user;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import db.tbl_Blog;
import db.tbl_ProductCategory;
import db.tbl_BlogComment;

@WebServlet("/blog-detail")
public class BlogDetailController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        DAO dao = new DAO();

        // ==================== LẤY ID ====================
        String idStr = request.getParameter("id");
        
        
        if (idStr == null || idStr.isEmpty()) {
            
            response.sendRedirect("BlogController");
            return;
        }

        int blogId;
        try {
            blogId = Integer.parseInt(idStr);
            
        } catch (NumberFormatException e) {
            
            response.sendRedirect("BlogController");
            return;
        }

        // ==================== LẤY BÀI VIẾT ====================
        tbl_Blog blog = dao.getBlogById(blogId);
        
        if (blog == null) {
            System.out.println("Bài viết không tồn tại");
            response.sendRedirect("BlogController");
            return;
        }
        
        if (!blog.isActive()) {
         
            response.sendRedirect("BlogController");
            return;
        }

        // ==================== LẤY DỮ LIỆU CHO TRANG ====================
        List<tbl_ProductCategory> listCategory = dao.getAllBlogCategories();
        List<tbl_Blog> recentPosts = dao.getRecentBlogs();

        request.setAttribute("blog", blog);
        request.setAttribute("listCategory", listCategory);
        request.setAttribute("recentPosts", recentPosts);

        request.getRequestDispatcher("/userPage/blogsingle.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}