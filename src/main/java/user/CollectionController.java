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

@WebServlet("/collections")
public class CollectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		DAO dao = new DAO();
		
		List<tbl_Menu> listmenu = dao.getActiveMenu();
		request.setAttribute("listMenu", listmenu);
		List<tbl_Collection> list = dao.getAllCollection();

		request.setAttribute("list", list);

		request.getRequestDispatcher("/userPage/collections.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
