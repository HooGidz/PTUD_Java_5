package user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import db.tbl_Menu;
import db.tbl_Product;
import db.tbl_ProductCategory;

@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		String categoryID = request.getParameter("cid");
		String indexPage = request.getParameter("index");
		if (indexPage == null)
			indexPage = "1";
		int index = 1;
		try {
			index = Integer.parseInt(indexPage);
		} catch (Exception e) {
			index = 1;
		}

		DAO dao = new DAO();

		int pageSize = 9;
		int totalPage;

		List<tbl_Product> listProduct;

		if (categoryID != null && !categoryID.isEmpty()) {
			int total = dao.getTotalProductByCID(categoryID);
			totalPage = (int) Math.ceil((double) total / pageSize);

			listProduct = dao.getProductByCID(categoryID);
		} else {
			int total = dao.getTotalAllProduct();
			totalPage = (int) Math.ceil((double) total / pageSize);

			listProduct = dao.pagingProduct(index, pageSize);
		}

		List<tbl_ProductCategory> listCategory = dao.getAllCategory();
		List<tbl_Product> listBestSeller = dao.getBestSellerProduct();
		List<tbl_Menu> listmenu = dao.getActiveMenu();
		request.setAttribute("listMenu", listmenu);

		request.setAttribute("listCategory", listCategory);
		request.setAttribute("listProduct", listProduct);
		request.setAttribute("listBestSeller", listBestSeller);

		request.setAttribute("tag", categoryID);
		request.setAttribute("page", index);
		request.setAttribute("totalPage", totalPage);

		request.getRequestDispatcher("/userPage/product.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
