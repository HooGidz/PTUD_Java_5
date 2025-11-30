package user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import db.tbl_Menu;
import db.tbl_Product;
import db.tbl_ProductCategory;


import java.util.Collections;
import java.util.Comparator; 


/**
 * Servlet implementation class HomeCotroller
 */
@WebServlet("/HomeCotroller")
public class HomeCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeCotroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
		response.setContentType("text/html;charset=UTF-8");
		DAO dao = new DAO();
		List<tbl_Menu> list = dao.getAllMenu();
		request.setAttribute("listP", list);
		
		List<tbl_Menu> listmenu = dao.getActiveMenu();
		request.setAttribute("listMenu", listmenu);
		
		List<tbl_Product> productList = dao.getAllProduct();
	    
    	Collections.sort(productList, new Comparator<tbl_Product>() {
	     @Override
	     public int compare(tbl_Product p1, tbl_Product p2) {
	         // So sánh giá (giá là kiểu double, so sánh trực tiếp)
	         // p1.getPrice() - p2.getPrice() sẽ cho thứ tự tăng dần (thấp đến cao)
	         return Double.compare(p1.getPrice(), p2.getPrice()); 
	     }
	 });
	 // =========================================================

	    request.setAttribute("listProduct", productList); 
	 // ...
	 // Chú ý: listP hiện tại đang chứa Menu, không nên dùng cho sản phẩm. 
	 // Nếu bạn muốn dùng listP cho sản phẩm, hãy đổi tên productList thành listP.
	 // Ví dụ: request.setAttribute("listP", productList);
	 // ...
	    
	    List<tbl_ProductCategory> productCategoryList = dao.getAllProductCategory();
	    request.setAttribute("listProductCategory", productCategoryList); 

		request.getRequestDispatcher("userPage/index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}