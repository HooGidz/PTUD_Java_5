package admin;

import java.io.IOException; 
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import db.tbl_Contact;


/**
 * Servlet implementation class Contact
 */
@WebServlet("/Contact")
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		String action = request.getParameter("action");

		DAO dao = new DAO();

		if (action == null) {
			List<tbl_Contact> listContact = dao.getAllContact();
			request.setAttribute("listContact", listContact);
			request.getRequestDispatcher("/adminPage/Contact/Contact.jsp").forward(request, response);
		}
		 else if (action.equals("edit")) {
				String contactId = request.getParameter("id");
				tbl_Contact contact = dao.getContactById(contactId);
				request.setAttribute("contactDetail", contact);
				request.getRequestDispatcher("/adminPage/Contact/EditContact.jsp").forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		DAO dao = new DAO();
		
			if (action.equals("editsubmit")) {

			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String message = request.getParameter("message");
			String isRead = request.getParameter("isRead");
			String createdDate = request.getParameter("createdDate");
			String createdBy = request.getParameter("createdBy");
			String contatcId = request.getParameter("contatcId");
			dao.editContact(name,phone,email,message,isRead,createdDate,createdBy,contatcId);

			response.sendRedirect("Contact");
		}
	}

}
