package admin;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DAO;
import db.tbl_ProductReview;

@WebServlet("/ProductReview")
public class ProductReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductReview() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
		DAO dao = new DAO();

		if (action == null) {
			List<tbl_ProductReview> list = dao.getAllReviews();
			request.setAttribute("listReview", list);
			request.getRequestDispatcher("/adminPage/ProductReview/AllProReview.jsp").forward(request, response);

		} else if (action.equals("edit")) {
			int reviewId = Integer.parseInt(request.getParameter("id"));

			tbl_ProductReview review = dao.getReviewById(reviewId);

			request.setAttribute("reviewDetail", review);

			request.getRequestDispatcher("/adminPage/ProductReview/EditProReview.jsp").forward(request, response);

		} else if (action.equals("delete")) {
			String roomcategoryId = request.getParameter("id");
			dao.deleteReview(roomcategoryId);
			response.sendRedirect("ProductReview");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		DAO dao = new DAO();

		if ("editsubmit".equals(action)) {
			int reviewId = Integer.parseInt(request.getParameter("reviewId"));
			boolean isActive = "1".equals(request.getParameter("isActive"));

			dao.editReviewStatus(reviewId, isActive);

			response.sendRedirect("ProductReview");
		} else {
			doGet(request, response);
		}
	}
}
