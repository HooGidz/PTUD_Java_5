package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.tbl_Account;
import db.tbl_Menu;
import dao.DAO;

@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AccountController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		DAO dao = new DAO();
		String action = request.getParameter("action");
		if (action == null) {
			List<tbl_Account> listAccount = dao.getAllAccount();
			request.setAttribute("listAccount", listAccount);

			request.getRequestDispatcher("/adminPage/Account/Account.jsp").forward(request, response);

		} else if (action.equals("add")) {
			request.getRequestDispatcher("/adminPage/Account/addAccount.jsp").forward(request, response);
		} else if (action.equals("edit")) {
			String accountId = request.getParameter("id");
			tbl_Account account = dao.getAccountById(accountId);
			request.setAttribute("accountDetail", account);
			request.getRequestDispatcher("/adminPage/Account/editAccount.jsp").forward(request, response);
		} else if (action.equals("delete")) {
			String accountId = request.getParameter("id");
			if (accountId != null && !accountId.isEmpty()) {
				dao.deleteAccount(accountId);
			}
			response.sendRedirect(request.getContextPath() + "/AccountController");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		DAO dao = new DAO();

		if ("addsubmit".equals(action)) {

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String fullName = request.getParameter("fullName");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String birthday = request.getParameter("birthday");
			String avatar = request.getParameter("avatar");
			String roleID = request.getParameter("roleID");
			String isActive = request.getParameter("isActive");

			dao.addAccount(username, password, fullName, phone, email, birthday, avatar, roleID, isActive);

			response.sendRedirect("AccountController");
		} else if (action.equals("editsubmit")) {

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String fullName = request.getParameter("fullName");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String birthday = request.getParameter("birthday");
			String avatar = request.getParameter("avatar");
			String roleID = request.getParameter("roleID");
			String isActive = request.getParameter("isActive");
			String accountId = request.getParameter("accountId");

			dao.editAccount(username, password, fullName, phone, email, birthday, avatar, roleID, isActive, accountId);

			response.sendRedirect("AccountController");
		}
	}
}
