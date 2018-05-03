package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.SQLAccessor;
import Main.UserDat;

public class ViewPrivateServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        SQLAccessor sqlA = new SQLAccessor();
	        ResultSet rs;
			try {
				rs = sqlA.getPrivateInfo(UserDat.ps1.getSSN());
				System.out.println(UserDat.ps1.getProfileID());
				rs.next();
		        String SSN = rs.getString("SSN");
		        String email = rs.getString("Email");
		        String phone = rs.getString("Telephone");
		        String street = rs.getString("Street");
		        String city = rs.getString("City");
		        String state = rs.getString("State");
		        String zip = rs.getString("Zipcode");
		        request.setAttribute("loggedIn", UserDat.ps1.getProfileID());
		        request.setAttribute("SSN", SSN);
		        request.setAttribute("email", email);
		        request.setAttribute("phone", phone);
		        request.setAttribute("street", street);
		        request.setAttribute("city", city);
		        request.setAttribute("state", state);
		        request.setAttribute("zip", zip);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/privateinfo.jsp");
		        dispatcher.forward(request, response);
			} catch (SQLException e) {
				RequestDispatcher rd = request.getRequestDispatcher("InvalidInput.html");
				rd.forward(request, response);
				e.printStackTrace();
			}
	        
	            
	    }  
}
