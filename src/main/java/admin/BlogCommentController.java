package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DAO;
import db.tbl_Blog;
import db.tbl_BlogComment;

/**
 * Servlet implementation class BlogCommentController
 */
@WebServlet("/BlogCommentController")
public class BlogCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogCommentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		DAO dao = new DAO();
		
		if( action == null) {
		List<tbl_BlogComment> listP = dao.getAllBlogComment();
        request.setAttribute("listP", listP);
        request.getRequestDispatcher("/adminPage/blogcomment/blogcomment.jsp").forward(request, response);
        
		}else if(action.equals("add")){
			request.getRequestDispatcher("/adminPage/blogcomment/addBlogComment.jsp").forward(request, response);
			
		}else if(action.equals("edit")) {
			String commentId = request.getParameter("id");
			tbl_BlogComment blogcomment = dao.getBlogCommentById(commentId); 
            request.setAttribute("blogcommentDetail", blogcomment);
            request.getRequestDispatcher("/adminPage/blogcomment/editBlogComment.jsp").forward(request, response);
            
		}else if (action.equals("delete")) {
            String commentId = request.getParameter("id");
            dao.deleteBlogComment(commentId); 
            response.sendRedirect("BlogCommentController");
         }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String action = request.getParameter("action");
		DAO dao = new DAO();
		if(action.equals("add")) {
			String commentId = request.getParameter("commentId");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String createddate = request.getParameter("createddate");
			String detail = request.getParameter("detail");
			String blogId = request.getParameter("blogId");
			String isactive = request.getParameter("isactive");
			dao.addBlogComment(name, phone, email, createddate, detail, blogId, isactive);
			response.sendRedirect("BlogCommentController");
		}
		if(action.equals("edit")) {
			String commentId = request.getParameter("commentId");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String createddate = request.getParameter("createddate");
			String detail = request.getParameter("detail");
			String blogId = request.getParameter("blogId");
			String isactive = request.getParameter("isactive");
			dao.editBlogComment(commentId, name, phone, email, createddate, detail, blogId, isactive);
			response.sendRedirect("BlogCommentController");
		}
	}

}
