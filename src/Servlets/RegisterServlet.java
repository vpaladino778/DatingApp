package Servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import Main.NewRegister;

import java.sql.*;
public class RegisterServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        String SSN = request.getParameter("regSSN");
	        String email = request.getParameter("regEmail");
	        String pass1 = request.getParameter("regPass1");
	        String pass2 = request.getParameter("regPass2");
	        boolean validation = NewRegister.register(SSN, email, pass1, pass2);

	        
	        request.setAttribute("auth", validation);
	        if(validation)
	        {
	        	
	            RequestDispatcher rs = request.getRequestDispatcher("/Home.jsp");
	            rs.forward(request, response);
	        }
	        else
	        {
	        	
	        	out.println("Username or Password incorrect");
	        	RequestDispatcher rs = request.getRequestDispatcher("login.html");
	        	rs.include(request, response);
	           
	        }
	    }  
}
