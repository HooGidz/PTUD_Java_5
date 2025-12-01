package admin;

import java.io.IOException;
import java.util.List;
import java.io.File;
import java.nio.file.Path;
import javax.servlet.http.Part;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import db.tbl_Blog;
import db.tbl_Collection;

/**
 * Servlet implementation class CollectionController
 */
@WebServlet("/CollectionController")
public class CollectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DAO dao = new DAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		 DAO dao = new DAO();

	        if (action == null) {
	            List<tbl_Collection> listP = dao.getAllCollection();
	            request.setAttribute("listP", listP);
	            request.getRequestDispatcher("/adminPage/collection/AllColection.jsp").forward(request, response);

	        } else if (action.equals("add")) {
	        	
	            request.getRequestDispatcher("/adminPage/collection/addCollection.jsp").forward(request, response);}
	        
	        else if (action.equals("edit")) {
	            String collectionId = request.getParameter("id");
	            tbl_Collection collection = dao.getCollectionById(collectionId); 
	            request.setAttribute("collectionDetail", collection);
	            request.getRequestDispatcher("/adminPage/collection/editCollection.jsp").forward(request, response);
	        }
	        else if (action.equals("delete")) {
	            String collectionId = request.getParameter("id");
	            dao.deleteCollection(collectionId); 
	            response.sendRedirect("CollectionController");
	         }
	        else if (action.equals("toggle")) {
	            String collectionId = request.getParameter("id");
	            dao.toggleCollection(collectionId);
	            response.sendRedirect("CollectionController");
	        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String action = request.getParameter("action");
	    DAO dao = new DAO();

	    if ("add".equals(action)) {
	        String name = request.getParameter("name");
	        String alias = request.getParameter("alias");
	        String designer = request.getParameter("designer");
	        String maker = request.getParameter("maker");
	        String description = request.getParameter("description");
	        String detail = request.getParameter("detail");
	        String image = request.getParameter("image");
	        String isNew = request.getParameter("isNew");
	        String isBestSeller = request.getParameter("isBestSeller");
	       // boolean isActive = "on".equals(request.getParameter("isActive"));
	        //String image = ""; // hoặc có thể để null hoặc đường dẫn ảnh mặc định
	        
	        String isActive = request.getParameter("isActive");
	       // String createdBy = request.getParameter("createby");
	        String createdBy = "admin"; 
	        //tbl_Collection c = new tbl_Collection(0, name, alias, designer, maker, description, detail, image,
	               // isNew, isBestSeller, isActive, new java.util.Date());
	        //dao.addCollection(c);
	        dao.addCollection(name,alias,designer,maker,description,detail,image,isNew,isBestSeller,isActive,createdBy);
	        response.sendRedirect("CollectionController");

	    } else if ("edit".equals(action)) {
	        int collectionId = Integer.parseInt(request.getParameter("collectionId"));
	        String name = request.getParameter("name");
	        String alias = request.getParameter("alias");
	        String designer = request.getParameter("designer");
	        String maker = request.getParameter("maker");
	        String description = request.getParameter("description");
	        String detail = request.getParameter("detail");
	        //String image = request.getParameter("image");
	        boolean isNew = "on".equals(request.getParameter("isNew"));
	        boolean isBestSeller = "on".equals(request.getParameter("isBestSeller"));
	        boolean isActive = "1".equals(request.getParameter("isActive"));
	        String image = "";

	        tbl_Collection c = new tbl_Collection(collectionId, name, alias, designer, maker, description, detail, image,
	                isNew, isBestSeller, isActive, new java.util.Date());
	        dao.editCollection(c);
	        response.sendRedirect("CollectionController");

	    } else {
	        doGet(request, response);
	    }
	}

}
