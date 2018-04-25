package Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import Main.ProfileList;
import Main.ProfileSignedIn;
import Main.UserDat;
import Main.Validate;

import java.sql.*;
import java.util.ArrayList;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        String email = request.getParameter("loginEmail");
	        String pass = request.getParameter("loginPass");
	        boolean validation = Validate.checkUser(email, pass);
	        
	        request.setAttribute("auth", validation);
	        if(validation)
	        {
	        	ArrayList<String> profileList = ProfileList.getProfileList(email);  	
	        	request.setAttribute("pList", profileList);
	            RequestDispatcher rs = request.getRequestDispatcher("/ProfileSelection.jsp");
	        	String SSN = Validate.findSSN(email, pass);
	        	UserDat.ps1 = new ProfileSignedIn(SSN, email);

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
