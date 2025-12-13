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
        int blogId = Integer.parseInt(request.getParameter("id"));

		tbl_Blog blog = dao.getBlogById(blogId);
		List<tbl_BlogComment> commentList = dao.getCommentsByBlogId(blogId);
		tbl_Blog prevBlog = dao.getPrevBlog(blogId);
		tbl_Blog nextBlog = dao.getNextBlog(blogId);
		List<tbl_Blog> recentPosts = dao.getRecentBlogs();
		List<tbl_ProductCategory> listCategory = dao.getAllBlogCategories();
		
		request.setAttribute("blog", blog);
		request.setAttribute("prevBlog", prevBlog);
		request.setAttribute("nextBlog", nextBlog);
		request.setAttribute("commentList", commentList);
		request.setAttribute("recentPosts", recentPosts);
		request.setAttribute("listCategory", listCategory);
		
		request.getRequestDispatcher("/userPage/blogsingle.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //doGet(request, response);
    	int blogId = Integer.parseInt(request.getParameter("blogId"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String detail = request.getParameter("detail");

        tbl_BlogComment c = new tbl_BlogComment();
        c.setBlogId(blogId);
        c.setName(name);
        c.setPhone(phone);
        c.setEmail(email);
        c.setDetail(detail);

        DAO dao = new DAO();
        dao.insertBlogComment(c);

        response.sendRedirect(request.getContextPath() + "/blog-detail?id=" + blogId);
    }
}