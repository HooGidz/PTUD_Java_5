package user;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import db.tbl_Menu;
import db.tbl_Product;
import db.tbl_ProductReview;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		String productId = request.getParameter("productId") ;
		DAO dao = new DAO();
		
		List<tbl_Menu> listmenu = dao.getActiveMenu();
		request.setAttribute("listMenu", listmenu);

		List<tbl_Product> listProBest = dao.getProBest();
		List<tbl_ProductReview> listProReview = dao.getProReviewById(productId);
		tbl_Product p = dao.getProductDetail(productId);
		request.setAttribute("detail", p);
		request.setAttribute("listProBest", listProBest);
		request.setAttribute("listProReview", listProReview);
		request.getRequestDispatcher("/userPage/ProductDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		DAO dao = new DAO();

		if (action.equals("addsubmit")) {
			String productId = request.getParameter("productId");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String detail = request.getParameter("detail");
			String star = "5";
			String isActive = "1";
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String createdDate = dtf.format(now);

			dao.addProReview(productId, name, phone, email, createdDate, detail, star, isActive);
			response.sendRedirect(request.getContextPath() + "/ProductDetail?productId=" + productId);
		}
	}

}
