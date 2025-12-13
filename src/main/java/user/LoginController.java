package user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import db.tbl_Account;

/**
 * Servlet implementation class UserController Xử lý các nghiệp vụ liên quan đến
 * Người dùng (Đăng nhập, Đăng ký, Đăng xuất)
 */
@WebServlet("/LoginController") // Ánh xạ tới đường dẫn
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAO dao;

	/**
	 * Khởi tạo DAO
	 */
	public LoginController() {
		super();
		this.dao = new DAO(); // Khởi tạo đối tượng DAO để truy cập CSDL
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action"); // Lấy tham số hành động (ví dụ: action=logout)

		if (action != null && action.equalsIgnoreCase("logout")) {
			// Xử lý Đăng xuất
			HttpSession session = request.getSession();
			session.removeAttribute("user"); // Xóa đối tượng người dùng khỏi Session
			session.invalidate(); // Hủy toàn bộ Session
			response.sendRedirect("userPage/login.jsp"); // Chuyển hướng về trang chủ
		} else {
			// Mặc định, chuyển hướng đến trang Hồ sơ (Profile) hoặc trang chủ
			response.sendRedirect("userPage/login.jsp"); // Chuyển hướng về trang đăng nhập
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");

		if (action != null && action.equalsIgnoreCase("login")) {
			// Xử lý Đăng nhập
			handleLogin(request, response);
		} else if (action != null && action.equalsIgnoreCase("register")) {
			// Xử lý Đăng ký

		} else {
			// Nếu không có action, chuyển hướng về trang chủ
			doGet(request, response);
		}
	}

	private void handleLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lấy giá trị từ form (tên biến 'name' và 'password' trong login.jsp)
		String username = request.getParameter("name");
		String password = request.getParameter("password");

		// 1. Gọi DAO để kiểm tra người dùng
		// (tbl_account phải là class tbl_Account, cần thống nhất tên)
		tbl_Account account = dao.login(username, password);

		if (account != null) {
			// 2. Đăng nhập thành công: Lưu vào Session
			HttpSession session = request.getSession();
			session.setAttribute("account", account); // Lưu đối tượng account vào session

			// Chuyển hướng về trang chủ
			response.sendRedirect("/Java_5/HomeCotronller");
		} else {
			// 3. Đăng nhập thất bại: Quay lại trang login với thông báo lỗi
			request.setAttribute("errorMessage", "Tên đăng nhập/Mật khẩu không đúng.");
			// Chuyển hướng nội bộ để giữ lại errorMessage
			request.getRequestDispatcher("userPage/login.jsp").forward(request, response);
		}
	}

}