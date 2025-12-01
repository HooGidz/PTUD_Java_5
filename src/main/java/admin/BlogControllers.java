package admin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import dao.DAO;
import db.tbl_Blog;

@WebServlet("/BlogControllers")
@MultipartConfig
public class BlogControllers extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final DAO dao = new DAO();
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action"); 
        
        DAO dao = new DAO();

        if (action == null) {
            List<tbl_Blog> listP = dao.getAllBlogs();
            request.setAttribute("listP", listP);
            request.getRequestDispatcher("/adminPage/blog/blog.jsp").forward(request, response);

        } else if (action.equals("add")) {
        	
            request.getRequestDispatcher("/adminPage/blog/add.jsp").forward(request, response);}
        
        else if (action.equals("edit")) {
            String blogId = request.getParameter("id");
            tbl_Blog blog = dao.getBlogById(blogId); 
            request.setAttribute("blogDetail", blog);
            request.getRequestDispatcher("/adminPage/blog/edit.jsp").forward(request, response);
        }
        else if (action.equals("delete")) {
            String blogId = request.getParameter("id");
            dao.deleteBlog(blogId); 
            response.sendRedirect("BlogControllers");
         }
        else if (action.equals("toggle")) {
            String blogId = request.getParameter("id");
            dao.toggleBlog(blogId);
            response.sendRedirect("BlogControllers");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String action = request.getParameter("action");
        DAO dao = new DAO();
        
        if (action.equals("add")) {
        	String accountId = request.getParameter("accountId");
	        String title = request.getParameter("title");
	        String alias = request.getParameter("alias");
	        String categoryId = request.getParameter("categoryId");
	        String description = request.getParameter("description");
	        String detail = request.getParameter("detail");
	        String image = request.getParameter("image");
	        String seoTitle = request.getParameter("seoTitle");
	        String seoDescription = request.getParameter("seoDescription");
	        String seoKeywords = request.getParameter("seoKeywords");
	        String modifiedBy = request.getParameter("modifiedBy");
	        String isActive = request.getParameter("isActive");
	        
	        dao.addBlog(accountId, title, alias, categoryId, description, detail, image,seoTitle,seoDescription,seoKeywords,modifiedBy,isActive); 
	        response.sendRedirect("BlogControllers"); 
	        
	    } else if (action.equals("edit")) {
	    	String blogId = request.getParameter("blogId");
	    	String accountId = request.getParameter("accountId");
	        String title = request.getParameter("title");
	        String alias = request.getParameter("alias");
	        String categoryId = request.getParameter("categoryId");
	        String description = request.getParameter("description");
	        String detail = request.getParameter("detail");
	        String image = request.getParameter("image");
	        String seoTitle = request.getParameter("seoTitle");
	        String seoDescription = request.getParameter("seoDescription");
	        String seoKeywords = request.getParameter("seoKeywords");
	        String modifiedBy = request.getParameter("modifiedBy");
	        String isActive = request.getParameter("isActive");
	        
	        dao.editBlog(blogId,accountId, title, alias, categoryId, description, detail, image,seoTitle,seoDescription,seoKeywords,modifiedBy,isActive);
	        response.sendRedirect("BlogControllers"); 
	        
	    } else {
	        doGet(request, response);
	    }
    }
}