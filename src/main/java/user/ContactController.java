package user;

import java.io.IOException;
import java.util.Date; // Cần dùng java.util.Date cho thời gian gửi
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import db.tbl_Contact;
import db.tbl_Menu;

@WebServlet("/ContactController") // Ánh xạ tới đường dẫn
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAO dao;

	public ContactController() {
		super();
		this.dao = new DAO(); // Khởi tạo DAO
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Yêu cầu GET chỉ đơn giản chuyển hướng đến trang contact.jsp để hiển thị form
		// Lưu ý: Đảm bảo tên file JSP của bạn là contact.jsp
		List<tbl_Contact> contactList = dao.getAllContact();
		request.setAttribute("listContact", contactList);
		List<tbl_Menu> listmenu = dao.getAllMenu();
		request.setAttribute("listMenu", listmenu);
		request.getRequestDispatcher("userPage/contact.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}