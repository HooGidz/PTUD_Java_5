package user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.CartItem;

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddToCart() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");
        if (idParam == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        int productId;
        try {
            productId = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        String name = request.getParameter("name");
        String priceParam = request.getParameter("price");
        double price = 0;
        if (priceParam != null && !priceParam.isEmpty()) {
            try {
                price = Double.parseDouble(priceParam);
            } catch (NumberFormatException e) {
                price = 0;
            }
        }
        String image = request.getParameter("image");

        int quantity = 1;
        String qtyParam = request.getParameter("quantity");
        if (qtyParam != null && !qtyParam.isEmpty()) {
            try {
                quantity = Integer.parseInt(qtyParam);
                if (quantity < 1) quantity = 1;
            } catch (NumberFormatException e) {
                quantity = 1;
            }
        }

        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }

        if (cart.containsKey(productId)) {
            CartItem existing = cart.get(productId);
            existing.setQuantity(existing.getQuantity() + quantity);
        } else {
            CartItem newItem = new CartItem(productId, name, price, image, quantity);
            cart.put(productId, newItem);
        }

        // Show cart via controller
        response.sendRedirect(request.getContextPath() + "/CartController");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
