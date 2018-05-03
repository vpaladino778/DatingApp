package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.NewRegister;
import Main.SQLAccessor;
import Main.UserDat;

public class ChangePassServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        String oldpass = request.getParameter("oldpass");
	        String pass1 = request.getParameter("newpass");
	        String pass2 = request.getParameter("checknewpass");
	        SQLAccessor sqlA = new SQLAccessor();
	        boolean done = false;
			try {
				done = sqlA.updatePass(UserDat.ps1.getSSN(), oldpass, pass1, pass2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if(done) {
	        	RequestDispatcher rs = request.getRequestDispatcher("/login.html");
	        	rs.forward(request, response);
	        }
	        else {
	        	RequestDispatcher rs = request.getRequestDispatcher("/change_pass.html");
	        	rs.forward(request, response);
	        }
	        
	    }  
}
