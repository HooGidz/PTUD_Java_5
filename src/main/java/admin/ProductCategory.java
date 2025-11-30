package admin;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DAO;
import db.tbl_ProductCategory;

@WebServlet("/ProductCategory")
public class ProductCategory extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProductCategory() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        DAO dao = new DAO();

        if (action == null) {
            List<tbl_ProductCategory> list = dao.getAllCategory();
            request.setAttribute("listCategory", list);
            request.getRequestDispatcher("/adminPage/ProductCategory/AllCategory.jsp").forward(request, response);

        } else if (action.equals("add")) {
            request.getRequestDispatcher("/adminPage/ProductCategory/AddCategory.jsp").forward(request, response);

        } else if (action.equals("edit")) {
        	int categoryId = Integer.parseInt(request.getParameter("id"));
            tbl_ProductCategory category = dao.getProductCategoryById(categoryId);
            request.setAttribute("categoryDetail", category);
            request.getRequestDispatcher("/adminPage/ProductCategory/EditCategory.jsp").forward(request, response);

        } else if (action.equals("delete")) {
        	String categoryId = request.getParameter("id");
            dao.deleteProductCategory(categoryId);
            response.sendRedirect("ProductCategory");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        DAO dao = new DAO();

        if ("addsubmit".equals(action)) {
        	String roomCategoryId = request.getParameter("roomCategoryId");
            String name = request.getParameter("name");
            String alias = request.getParameter("alias");
            String description = request.getParameter("description");
            String isActive = (request.getParameter("isActive") != null) ? "1" : "0";

            dao.addProductCategory(roomCategoryId, name, alias, description, isActive);
            response.sendRedirect("ProductCategory");

        } else if ("editsubmit".equals(action)) {
            int categoryId = Integer.parseInt(request.getParameter("id"));
            int roomCategoryId = Integer.parseInt(request.getParameter("roomCategoryId"));
            String name = request.getParameter("name");
            String alias = request.getParameter("alias");
            String description = request.getParameter("description");
            boolean isActive = "1".equals(request.getParameter("status"));

            dao.editProductCategory(categoryId, roomCategoryId, name, alias, description, isActive);
            response.sendRedirect("ProductCategory");

        } else {
            doGet(request, response);
        }
    }
}
