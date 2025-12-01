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
import db.tbl_Provider;

/**
 * Servlet implementation class Provider
 */
@WebServlet("/Provider")
public class Provider extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Provider() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            
            // 1. Lấy tham số action từ URL
            String action = request.getParameter("action"); 
            
            DAO dao = new DAO();

            if (action == null) {
                List<tbl_Provider> listProvider = dao.getAllProvider();
                request.setAttribute("listProvider", listProvider);
                request.getRequestDispatcher("/adminPage/Provider/AllProvider.jsp").forward(request, response);

            } else if (action.equals("add")) {
                request.getRequestDispatcher("/adminPage/Provider/AddProvider.jsp").forward(request, response);

            } else if (action.equals("edit")) {
                String providerId = request.getParameter("id");
                tbl_Provider provider = dao.getProviderById(providerId); 
                request.setAttribute("providerDetail", provider);
                request.getRequestDispatcher("/adminPage/Provider/EditProvider.jsp").forward(request, response);

            } else if (action.equals("delete")) {
               String providerId = request.getParameter("id");
               dao.deleteProvider(providerId); 
               response.sendRedirect("Provider");
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
	    
	    if (action.equals("addsubmit")) {
	        String name = request.getParameter("name");
	        String address = request.getParameter("address");
	        String phone = request.getParameter("phone");
	        String email = request.getParameter("email");
	        String description = request.getParameter("description");
	        String status = request.getParameter("status");
	        
	        dao.addProvider(name, address, phone, email, description, status); 
	        response.sendRedirect("Provider"); 
	        
	    } else if (action.equals("editsubmit")) {
	    	String providerId = request.getParameter("id");
	        String name = request.getParameter("name");
	        String address = request.getParameter("address");
	        String phone = request.getParameter("phone");
	        String email = request.getParameter("email");
	        String description = request.getParameter("description");
	        String status = request.getParameter("status"); 
	        
	        dao.editProvider(providerId, name, address, phone, email, description, status);
	        response.sendRedirect("Provider"); 
	        
	    } else {
	        doGet(request, response);
	    }
	}

}
