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

public class HomePageServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        UserDat.ps1.setProfileID(request.getParameter("Username"));
	        SQLAccessor sqlA = new SQLAccessor();
	        ResultSet rs;
			try {
				rs = sqlA.getProfileInfo(UserDat.ps1.getProfileID());
				rs.next();
		        String profileID = UserDat.ps1.getProfileID();
		        String loginEmail = UserDat.ps1.getEmail();
		        int age = rs.getInt("Age");
		        int dars = rs.getInt("DatingAgeRangeStart");
		        int dare = rs.getInt("DatingAgeRangeEnd");
		        int dgr = rs.getInt("DatingGeoRange");
		        String gender = rs.getString("M_F");
		        String hobbies = rs.getString("Hobbies");
		        int height = rs.getInt("Height");
		        int weight = rs.getInt("Weight");
		        String hair = rs.getString("HairColor");
		        
		        request.setAttribute("profileID", profileID);
		        request.setAttribute("loginEmail", loginEmail);
		        request.setAttribute("age", age);
		        request.setAttribute("dars", dars);
		        request.setAttribute("dare", dare);
		        request.setAttribute("dgr", dgr);
		        request.setAttribute("gender", gender);
		        request.setAttribute("hobbies", hobbies);
		        request.setAttribute("height", height);
		        request.setAttribute("weight", weight);
		        request.setAttribute("hair", hair);
		        System.out.println(loginEmail);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
		        dispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }  

}
