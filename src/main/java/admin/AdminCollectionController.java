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


@WebServlet("/AdminCollectionController")
public class AdminCollectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DAO dao = new DAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCollectionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		 DAO dao = new DAO();

	        if (action == null) {
	            List<tbl_Collection> listP = dao.getAllCollections();
	            request.setAttribute("listP", listP);
	            request.getRequestDispatcher("/adminPage/collection/AllColection.jsp").forward(request, response);

	        } else if (action.equals("add")) {
	        	
	            request.getRequestDispatcher("/adminPage/collection/addCollection.jsp").forward(request, response);}
	        
	        else if (action.equals("edit")) {
	            String collectionId = request.getParameter("id");
	            tbl_Collection collection = dao.getCollectionId(collectionId); 
	            request.setAttribute("collectionDetail", collection);
	            request.getRequestDispatcher("/adminPage/collection/editCollection.jsp").forward(request, response);
	        }
	        else if (action.equals("delete")) {
	            String collectionId = request.getParameter("id");
	            dao.deleteCollection(collectionId); 
	            response.sendRedirect("AdminCollectionController");
	         }
	        else if (action.equals("toggle")) {
	            String collectionId = request.getParameter("id");
	            dao.toggleCollection(collectionId);
	            response.sendRedirect("AdminCollectionController");
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

	    if (action.equals("add")) {
	        String name = request.getParameter("name");
	        String alias = request.getParameter("alias");
	        String designer = request.getParameter("designer");
	        String maker = request.getParameter("maker");
	        String description = request.getParameter("description");
	        String detail = request.getParameter("detail");
	        String image = request.getParameter("image");
	        boolean isNew = parseBoolean(request.getParameter("isNew"), false);
			boolean isBestSeller = parseBoolean(request.getParameter("isBestSeller"), false);
			boolean isActive = parseBoolean(request.getParameter("isActive"), true);
	        String createdDate = request.getParameter("createdDate");
	        dao.addCollection(name,alias,designer,maker,description,detail,image,isNew,isBestSeller,isActive,createdDate);
	        response.sendRedirect("AdminCollectionController");

	    } if (action.equals("edit")) {
	    	String collectionId = request.getParameter("collectionId");
	        String name = request.getParameter("name");
	        String alias = request.getParameter("alias");
	        String designer = request.getParameter("designer");
	        String maker = request.getParameter("maker");
	        String description = request.getParameter("description");
	        String detail = request.getParameter("detail");
	        String image = request.getParameter("image");
	        boolean isNew = parseBoolean(request.getParameter("isNew"), false);
			boolean isBestSeller = parseBoolean(request.getParameter("isBestSeller"), false);
			boolean isActive = parseBoolean(request.getParameter("isActive"), true);
	        String createdDate = request.getParameter("createdDate");
	        
	        dao.editCollection(collectionId, name, alias, designer, maker, description, detail, image, isNew, isBestSeller, isActive, createdDate);
	        response.sendRedirect("AdminCollectionController");

	    } 
	}
	private boolean parseBoolean(String s, boolean defaultValue) {
		if (s == null || s.isEmpty())
			return defaultValue;
		return s.equals("1") || Boolean.parseBoolean(s);
	}
}
