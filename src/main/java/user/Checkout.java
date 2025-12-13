package user;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import db.CartItem;
import db.tbl_Menu;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
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
		
		@SuppressWarnings("unchecked")
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) request.getSession().getAttribute("cart");
        
        Collection<CartItem> cartItems = null;
        double grandTotal = 0;

        if (cart != null && !cart.isEmpty()) {
            cartItems = cart.values();
            
            // 2. Tính tổng tiền (Grand Total)
            for (CartItem item : cartItems) {
                grandTotal += item.getTotalPrice();
            }
        } else {
            // Khởi tạo rỗng nếu giỏ hàng null hoặc trống
            cartItems = java.util.Collections.emptyList();
        }
        
        // 3. Đặt dữ liệu vào Request để JSP truy cập
        request.setAttribute("cartItems", cartItems);
        request.setAttribute("grandTotal", grandTotal);
		List<tbl_Menu> listmenu = dao.getActiveMenu();
		request.setAttribute("listMenu", listmenu);

		request.getRequestDispatcher("/userPage/Checkout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Đảm bảo request nhận được tiếng Việt
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=UTF-8");

		// 1. Lấy thông tin từ Form
		String customerName = request.getParameter("customerName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String totalAmountParam = request.getParameter("totalAmount"); // Tổng tiền
		String note = request.getParameter("note");
		String paymentMethod = request.getParameter("paymentMethod"); // cod hoặc bank_transfer

		DAO dao = new DAO();
		HttpSession session = request.getSession(false);
		
		// 2. Lấy giỏ hàng từ Session
		@SuppressWarnings("unchecked")
		Map<Integer, CartItem> cart = (Map<Integer, CartItem>) (session != null ? session.getAttribute("cart") : null);
		
		// 3. Kiểm tra tính hợp lệ cơ bản
		if (cart == null || cart.isEmpty() || totalAmountParam == null || customerName == null || phone == null || address == null) {
			request.setAttribute("error", "Giỏ hàng trống hoặc thông tin đặt hàng bị thiếu. Vui lòng kiểm tra lại.");
			doGet(request, response); // Forward lại trang Checkout để hiển thị lỗi
			return;
		}
		
		double grandTotal;
		try {
			// Chuyển tổng tiền từ String sang Double
			grandTotal = Double.parseDouble(totalAmountParam);
		} catch (NumberFormatException e) {
			request.setAttribute("error", "Lỗi định dạng tổng tiền. Vui lòng thử lại.");
			doGet(request, response);
			return;
		}

		// 4. Gọi hàm thêm đơn hàng vào CSDL
		boolean isSuccess = dao.addOrderFromCart(customerName, phone, address, grandTotal, note, paymentMethod, cart);

		if (isSuccess) {
			// 5. Thao tác thành công: Xóa giỏ hàng khỏi session
			session.removeAttribute("cart");
			
			// 6. Chuyển hướng đến trang thông báo thành công
			request.setAttribute("orderSuccess", true);
			request.setAttribute("message", "Đặt hàng thành công! Đơn hàng của bạn đang chờ xác nhận.");
			request.getRequestDispatcher("/userPage/OrderConfirmation.jsp").forward(request, response);
			
		} else {
			// 7. Thao tác thất bại: Quay lại trang thanh toán với thông báo lỗi
			request.setAttribute("error", "Đã xảy ra lỗi hệ thống trong quá trình đặt hàng. Vui lòng thử lại.");
			doGet(request, response); // Forward lại trang Checkout để load lại dữ liệu
		}
	}
}
