package user;

import java.util.List;
import db.tbl_Blog;
import db.tbl_ProductCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;

@WebServlet("/BlogController")
public class BlogController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        DAO dao = new DAO();
     

        //List<tbl_Blog>listP = dao.getAllBlog();
     // Số bài viết mỗi trang
        int recordsPerPage = 5;
        
        // Lấy số trang từ parameter, mặc định là trang 1
        String pageStr = request.getParameter("page");
        int currentPage = (pageStr == null || pageStr.isEmpty()) ? 1 : Integer.parseInt(pageStr);
        
        // Lấy danh sách blog theo trang (5 bài/trang)
        List<tbl_Blog> listP = dao.getBlogsByPaging(currentPage, recordsPerPage);

        // Tính tổng số blog và tổng số trang
        int totalBlogs = dao.getTotalBlogCount();
        int totalPages = (int) Math.ceil((double) totalBlogs / recordsPerPage);
        
        
     // Lấy danh mục blog
        List<tbl_ProductCategory> listCategory = dao.getAllBlogCategories();
        
        // Lấy 5 bài viết gần nhất
        List<tbl_Blog> recentPosts = dao.getRecentBlogs();

        
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("listCategory", listCategory);
        request.setAttribute("recentPosts", recentPosts);
        
        request.setAttribute("totalBlogs", totalBlogs);
        request.setAttribute("listP", listP);
        //request.setAttribute("listP", listP);
       
        // Forward đến trang blog.jsp
        request.getRequestDispatcher("/userPage/blog.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}