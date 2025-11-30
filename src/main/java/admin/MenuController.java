package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import db.tbl_Menu;

/**
 * Servlet implementation class MenuController
 */
@WebServlet("/MenuController")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String action = request.getParameter("action");

		DAO dao = new DAO();

		if (action == null) {
			List<tbl_Menu> listMenu = dao.getAllMenu();
			request.setAttribute("listMenu", listMenu);
			request.getRequestDispatcher("/adminPage/Menu/Menu.jsp").forward(request, response);

		} else if (action.equals("add")) {
			request.getRequestDispatcher("/adminPage/Menu/addMenu.jsp").forward(request, response);
		} else if (action.equals("edit")) {
			String menuId = request.getParameter("id");
			tbl_Menu menu = dao.getMenuById(menuId);
			request.setAttribute("menuDetail", menu);
			request.getRequestDispatcher("/adminPage/Menu/editMenu.jsp").forward(request, response);
		} else if (action.equals("delete")) {
			String menuId = request.getParameter("id");
			if (menuId != null && !menuId.isEmpty()) {
				dao.deleteMenu(menuId);
			}

			response.sendRedirect(request.getContextPath() + "/MenuController");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		DAO dao = new DAO();
		if (action != null && action.equals("addsubmit")) {
			String name = request.getParameter("name");
			String alias = request.getParameter("alias");
			String description = request.getParameter("description");
			String position = request.getParameter("position");
			String createddate = request.getParameter("createddate");
			String createdby = request.getParameter("createdby");
			String modifieddate = request.getParameter("modifieddate");
			String modifiedby = request.getParameter("modifiedby");
			String isactive = request.getParameter("isactive");
			String isdropdown = request.getParameter("isdropdown");

			dao.addMenu(name, alias, description, position, createddate, createdby, modifieddate, modifiedby, isactive,
					isdropdown);
			response.sendRedirect(request.getContextPath() + "/MenuController");
		} else if ("editsubmit".equals(action)) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String alias = request.getParameter("alias");
			String description = request.getParameter("description");
			String position = request.getParameter("position");
			String createddate = request.getParameter("createddate");
			String createdby = request.getParameter("createdby");
			String modifieddate = request.getParameter("modifieddate");
			String modifiedby = request.getParameter("modifiedby");
			String isactive = request.getParameter("isactive");
			String isdropdown = request.getParameter("isdropdown");
			if (id != null && !id.isEmpty()) {
				dao.editMenu(id, name, alias, description, position, createddate, createdby, modifieddate, modifiedby,
						isactive, isdropdown);
			}
			response.sendRedirect(request.getContextPath() + "/MenuController");
		} else {
			response.sendRedirect(request.getContextPath() + "/MenuController");
		}

	}
}