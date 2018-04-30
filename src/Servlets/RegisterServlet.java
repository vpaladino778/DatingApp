package Servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import Main.NewRegister;

import java.sql.*;
public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        String fname = request.getParameter("fname");
	        String lname = request.getParameter("lname");
	        String SSN = request.getParameter("regSSN");
	        String profileID = request.getParameter("regProfileID");
	        String email = request.getParameter("regEmail");
	        String pass1 = request.getParameter("regPass1");
	        String pass2 = request.getParameter("regPass2");
	        String street = request.getParameter("street");
	        String city = request.getParameter("city");
	        String state = request.getParameter("state");
	        String zip = request.getParameter("zip");
	        String phone = request.getParameter("phone");
	        boolean newProfileCreated = NewRegister.register(SSN, profileID, email, pass1, pass2, fname, lname, street, city, state, zip, phone);
	        
	        RequestDispatcher rs = request.getRequestDispatcher("/Edit_Profile.html");
	        rs.forward(request, response);
	        
	        
	    }  
}
