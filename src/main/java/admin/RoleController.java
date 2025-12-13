package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import db.tbl_Account;
import db.tbl_Role;

/**
 * Servlet implementation class RoleController
 */
@WebServlet("/RoleController")
public class RoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		DAO dao = new DAO();
		String action = request.getParameter("action");
		if (action == null) {
			List<tbl_Role> listRole = dao.getAllRole();
			request.setAttribute("listRole", listRole);

			request.getRequestDispatcher("/adminPage/Role/AllRole.jsp").forward(request, response);
		}
		else if (action.equals("add")) {
			request.getRequestDispatcher("/adminPage/Role/AddRole.jsp").forward(request, response);
		} else if (action.equals("edit")) {
			String roleId = request.getParameter("id");
			tbl_Role role = dao.getRoleById(roleId);
			request.setAttribute("roleDetail", role);
			request.getRequestDispatcher("/adminPage/Role/EditRole.jsp").forward(request, response);
		}else if (action.equals("delete")) {
			String roleId = request.getParameter("id");
			if (roleId != null && !roleId.isEmpty()) {
				dao.deleteRole(roleId);
			}
			response.sendRedirect(request.getContextPath() + "/RoleController");
		}

		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		DAO dao = new DAO();
		
		if ("addsubmit".equals(action)) {

			String rolename = request.getParameter("rolename");
			String description = request.getParameter("description");
			
			dao.addRole(rolename, description);

			response.sendRedirect("RoleController");
		}
		else if (action.equals("editsubmit")) {

			String rolename = request.getParameter("rolename");
			String description = request.getParameter("description");
			String roleId = request.getParameter("roleId");

			dao.editRole(rolename,description,roleId);

			response.sendRedirect("RoleController");
		}

	}
	
}
