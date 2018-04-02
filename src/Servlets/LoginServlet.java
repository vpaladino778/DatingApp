package Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import Main.Validate;

import java.sql.*;

public class LoginServlet extends HttpServlet{
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        String email = request.getParameter("email");
	        String pass = request.getParameter("pass");
	        
	        if(Validate.checkUser(email, pass))
	        {
	            RequestDispatcher rs = request.getRequestDispatcher("Welcome");
	            rs.forward(request, response);
	        }
	        else
	        {
	           out.println("Username or Password incorrect");
	           RequestDispatcher rs = request.getRequestDispatcher("index.html");
	           rs.include(request, response);
	        }
	    }  
}
