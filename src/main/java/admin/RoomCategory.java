package admin;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DAO;
import db.tbl_RoomCategory;

@WebServlet("/RoomCategory")
public class RoomCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RoomCategory() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
		DAO dao = new DAO();

		if (action == null) {
			List<tbl_RoomCategory> list = dao.getAllRoomcategory();
			request.setAttribute("listRoomcate", list);
			request.getRequestDispatcher("/adminPage/RoomCategory/AllRoomCate.jsp").forward(request, response);

		} else if (action.equals("add")) {
			request.getRequestDispatcher("/adminPage/RoomCategory/AddRoomCate.jsp").forward(request, response);

		} else if (action.equals("edit")) {
			int roomCategoryId = Integer.parseInt(request.getParameter("id"));
			tbl_RoomCategory roomCategory = dao.getRoomCategoryById(roomCategoryId);
			request.setAttribute("roomCate", roomCategory);
			request.getRequestDispatcher("/adminPage/RoomCategory/EditRoomCate.jsp").forward(request, response);

		} else if (action.equals("delete")) {
			String roomcategoryId = request.getParameter("id");
			dao.deleteRoomCategory(roomcategoryId);
			response.sendRedirect("RoomCategory");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		DAO dao = new DAO();

		if ("addsubmit".equals(action)) {
			String name = request.getParameter("name");
		    String alias = request.getParameter("alias");
		    String description = request.getParameter("description");
		    boolean isActive = "1".equals(request.getParameter("isActive"));

		    dao.addRoomCategory(name, alias, description, isActive);

		    response.sendRedirect("RoomCategory");

		} else if ("editsubmit".equals(action)) {
			int roomCategoryId = Integer.parseInt(request.getParameter("roomCategoryId"));
			String name = request.getParameter("name");
			String alias = request.getParameter("alias");
			String description = request.getParameter("description");
			boolean isActive = "1".equals(request.getParameter("isActive"));

			dao.editRoomCategory(roomCategoryId, name, alias, description, isActive);
			response.sendRedirect("RoomCategory");

		} else {
			doGet(request, response);
		}
	}
}
