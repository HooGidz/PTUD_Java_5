package user;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.CartItem;

@WebServlet("/CartController")
public class CartController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to Cart.jsp located at /userPage/Cart.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/userPage/Cart.jsp");
        dispatcher.forward(request, response);
    }

    // handle update/remove actions from forms in the cart page
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);
        if (session != null) {
            @SuppressWarnings("unchecked")
            Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
            if (cart != null && action != null) {
                String idParam = request.getParameter("productID");
                int pid = -1;
                try {
                    pid = Integer.parseInt(idParam);
                } catch (Exception e) {
                    pid = -1;
                }
                if (pid != -1) {
                    if ("update".equals(action)) {
                        String qtyParam = request.getParameter("quantity");
                        try {
                            int q = Integer.parseInt(qtyParam);
                            if (q <= 0) {
                                cart.remove(pid);
                            } else if (cart.containsKey(pid)) {
                                cart.get(pid).setQuantity(q);
                            }
                        } catch (NumberFormatException ex) {
                            // ignore invalid quantity
                        }
                    } else if ("remove".equals(action)) {
                        cart.remove(pid);
                    }
                    // save back into session not necessary as map object mutated
                }
            }
        }
        // redirect to GET to display updated cart
        response.sendRedirect(request.getContextPath() + "/CartController");
    }
}
