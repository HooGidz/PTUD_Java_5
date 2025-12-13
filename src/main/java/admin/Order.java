package admin;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import db.tbl_Order;
import db.tbl_OrderDetail;
import db.tbl_OrderStatus;
import db.tbl_Product;
import db.tbl_Provider;

/**
 * Servlet implementation class Order
 */
@WebServlet("/Order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

		DAO dao = new DAO();

		if (action == null) {
			int page = 1;
			int pageSize = 10;

			if (request.getParameter("page") != null) {
			    page = Integer.parseInt(request.getParameter("page"));
			}
			int totalOrders = dao.getTotalOrders();
			int totalPages = (int) Math.ceil((double) totalOrders / pageSize);

			List<tbl_Order> listOrder = dao.getOrdersByPage(page, pageSize);

			request.setAttribute("listOrder", listOrder);
			request.setAttribute("currentPage", page);
			request.setAttribute("totalPages", totalPages);

			request.getRequestDispatcher("/adminPage/Order/AllOrder.jsp").forward(request, response);

		} else if (action.equals("add")) {
			List<tbl_Product> products = dao.getAllProduct();
			request.setAttribute("products", products);
			request.getRequestDispatcher("/adminPage/Order/AddOrder.jsp").forward(request, response);

		} else if (action.equals("edit")) {
			String orderId = request.getParameter("id");
			tbl_Order order = dao.getOrderById(orderId);
			List<tbl_Product> products = dao.getAllProduct();
			List<tbl_OrderDetail> orderDetails = dao.getOrderDetailsByOrderId(orderId);
			tbl_OrderStatus orderStatus = dao.getOrderStatusByOrderId(orderId);
			request.setAttribute("orderDetail", order);
			request.setAttribute("products", products);
			request.setAttribute("orderDetails", orderDetails);
			request.setAttribute("orderStatus", orderStatus);
			request.getRequestDispatcher("/adminPage/Order/EditOrder.jsp").forward(request, response);

		} else if (action.equals("delete")) {
			String orderId = request.getParameter("id");
			dao.deleteOrder(orderId);
			response.sendRedirect("Order");
		}
	}
                                  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		DAO dao = new DAO();

		if (action.equals("addsubmit")) {
			String customerName = request.getParameter("customerName");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String totalAmount = request.getParameter("totalAmount");
			String quantity = request.getParameter("quantity");
			String note = request.getParameter("note");
			String paymentMethod = request.getParameter("paymentMethod");
			// Lấy tham số trạng thái đơn hàng mới
			String orderStatus = request.getParameter("orderStatus");
			String descriptionStatus = request.getParameter("descriptionStatus");
			
			String[] productIds = request.getParameterValues("productId");
			String[] productPrices = request.getParameterValues("productPrice");
			String[] productQuantities = request.getParameterValues("productQuantity");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String createdDate = dtf.format(now);
			dao.addOrder(customerName, phone, address, totalAmount, quantity, note, paymentMethod, createdDate,
					orderStatus, descriptionStatus, productIds, productPrices, productQuantities);
			response.sendRedirect("Order");

		} else if (action.equals("editsubmit")) {
			String orderId = request.getParameter("id");
			String customerName = request.getParameter("customerName");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String totalAmount = request.getParameter("totalAmount");
			String quantity = request.getParameter("quantity");
			String note = request.getParameter("note");
			String paymentMethod = request.getParameter("paymentMethod");
			// Lấy tham số trạng thái khi edit
			String orderStatus = request.getParameter("orderStatus");
			String descriptionStatus = request.getParameter("descriptionStatus");
			// Lấy danh sách sản phẩm (nhiều)
			String[] productIds = request.getParameterValues("productId");
			String[] productPrices = request.getParameterValues("productPrice");
			String[] productQuantities = request.getParameterValues("productQuantity");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String modifiedDate = dtf.format(now);

			dao.editOrder(orderId, customerName, phone, address, totalAmount, quantity, note, paymentMethod,
					orderStatus, descriptionStatus, modifiedDate, productIds, productPrices, productQuantities);
			response.sendRedirect("Order");

		} else {
			doGet(request, response);
		}
	}

}