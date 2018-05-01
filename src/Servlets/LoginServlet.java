package Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import Main.EmployeeHome;
import Main.ProfileList;
import Main.ProfileSignedIn;
import Main.SQLAccessor;
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
	        	SQLAccessor sqlA = new SQLAccessor();
	        	try {
					boolean employee_check = sqlA.checkEmployee(UserDat.ps1.getSSN());
					if(employee_check) {
						EmployeeHome.loadEmployeeHome(request, response, sqlA);
					}
					else {
						ArrayList<String> profileList = ProfileList.getProfileList(email);  	
			        	request.setAttribute("pList", profileList);
			            RequestDispatcher rs = request.getRequestDispatcher("/ProfileSelection.jsp");
			            rs.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	        }
	        else
	        {
	        	out.println("Username or Password incorrect");
	        	RequestDispatcher rs = request.getRequestDispatcher("login.html");
	        	rs.include(request, response);
	           
	        }
	    }  
}
