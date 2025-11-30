package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import db.tbl_Product;

@WebServlet("/product")
public class Product extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        DAO dao = new DAO();

        if (action == null) {
            List<tbl_Product> listProduct = dao.getAllProduct();
            request.setAttribute("listProduct", listProduct);
            request.getRequestDispatcher("/adminPage/product/AllProduct.jsp").forward(request, response);

        } else if (action.equals("add")) {
            request.getRequestDispatcher("/adminPage/product/AddProduct.jsp").forward(request, response);

        } else if (action.equals("edit")) {
        	int productId = Integer.parseInt(request.getParameter("id"));
            tbl_Product product = dao.getProductById(productId);
            request.setAttribute("product", product);
            request.getRequestDispatcher("/adminPage/product/EditProduct.jsp").forward(request, response);

        } else if (action.equals("delete")) {
        	int productId = Integer.parseInt(request.getParameter("id"));
            dao.deleteProduct(productId);
            response.sendRedirect("product");
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        DAO dao = new DAO();

        
        if (action.equals("addsubmit")) {

                    int providerId = parseInt(request.getParameter("providerId"), 0);
                    int categoryId = parseInt(request.getParameter("categoryId"), 0);
                    String name = defaultString(request.getParameter("name"));
                    String alias = defaultString(request.getParameter("alias"));
                    String brands = defaultString(request.getParameter("brands"));
                    String material = defaultString(request.getParameter("material"));
                    String dimensions = defaultString(request.getParameter("dimensions"));
                    String description = defaultString(request.getParameter("description"));
                    String detail = defaultString(request.getParameter("detail"));
                    String image = defaultString(request.getParameter("image"));
                    double price = parseDouble(request.getParameter("price"), 0);
                    double priceSale = parseDouble(request.getParameter("priceSale"), 0);
                    int quantity = parseInt(request.getParameter("quantity"), 0);
                    boolean isNew = parseBoolean(request.getParameter("isNew"), false);
                    boolean isBestSeller = parseBoolean(request.getParameter("isBestSeller"), false);
                    boolean isActive = parseBoolean(request.getParameter("isActive"), true);
                    int star = parseInt(request.getParameter("star"), 0);

                    tbl_Product p = new tbl_Product(
                            0, providerId, categoryId, name, alias, brands, material, dimensions,
                            description, detail, image, price, priceSale, quantity, isNew, isBestSeller, isActive, star
                    );
            dao.addProduct(p);
            response.sendRedirect("product");

        } else if (action.equals("editsubmit")) {

            int productId = parseInt(request.getParameter("id"), 0);
            int providerId = parseInt(request.getParameter("providerId"), 0);
            int categoryId = parseInt(request.getParameter("categoryId"), 0);
            
            String name = defaultString(request.getParameter("name"));
            String alias = defaultString(request.getParameter("alias"));
            String brands = defaultString(request.getParameter("brands"));
            String material = defaultString(request.getParameter("material"));
            String dimensions = defaultString(request.getParameter("dimensions"));
            String description = defaultString(request.getParameter("description"));
            String detail = defaultString(request.getParameter("detail"));
            String image = defaultString(request.getParameter("image"));

            double price = parseDouble(request.getParameter("price"), 0);
            double priceSale = parseDouble(request.getParameter("priceSale"), 0);
            int quantity = parseInt(request.getParameter("quantity"), 0);

            boolean isBestSeller = parseBoolean(request.getParameter("isBestSeller"), false);
            boolean isActive = parseBoolean(request.getParameter("isActive"), true);

            int star = parseInt(request.getParameter("star"), 0);

            dao.editProduct(
                productId,
                providerId,
                categoryId,
                name,
                alias,
                brands,
                material,
                dimensions,
                description,
                detail,
                image,
                price,
                priceSale,
                quantity,
                isBestSeller,
                isActive,
                star
            );

            response.sendRedirect("product");
        }


        else {
            doGet(request, response);
        }
    }
    private int parseInt(String s, int defaultValue) {
        if (s == null || s.isEmpty()) return defaultValue;
        try { return Integer.parseInt(s); } catch (NumberFormatException e) { return defaultValue; }
    }

    private double parseDouble(String s, double defaultValue) {
        if (s == null || s.isEmpty()) return defaultValue;
        try { return Double.parseDouble(s); } catch (NumberFormatException e) { return defaultValue; }
    }

    private boolean parseBoolean(String s, boolean defaultValue) {
        if (s == null || s.isEmpty()) return defaultValue;
        return s.equals("1") || Boolean.parseBoolean(s);
    }

    private String defaultString(String s) {
        return (s == null) ? "" : s.trim();
    }
}