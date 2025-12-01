package user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import db.tbl_Collection;
import db.tbl_Menu;
import db.tbl_Product;

@WebServlet("/collectionDetail")
public class CollectionDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAO dao = new DAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try {
			String cidStr = request.getParameter("id");
			if (cidStr == null || cidStr.isEmpty()) {
				response.getWriter().println("ID bộ sưu tập không hợp lệ.");
				return;
			}

			int cid = Integer.parseInt(cidStr);

			tbl_Collection collection = dao.getCollectionById(cid);
			if (collection == null) {
				response.getWriter().println("Bộ sưu tập không tồn tại.");
				return;
			}

			List<tbl_Product> products = dao.getProductsByCollectionId(cid);
			List<tbl_Menu> listmenu = dao.getActiveMenu();
			request.setAttribute("listMenu", listmenu);
			request.setAttribute("collection", collection);
			request.setAttribute("products", products);

			request.getRequestDispatcher("/userPage/collectionDetail.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Lỗi khi truy xuất bộ sưu tập: " + e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
