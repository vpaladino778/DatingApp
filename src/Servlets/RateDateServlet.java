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

import Main.MainHome;
import Main.SQLAccessor;
import Main.UserDat;

public class RateDateServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        SQLAccessor sqlA = new SQLAccessor();
        SQLAccessor sqlA2 = new SQLAccessor();
        PrintWriter out = response.getWriter();
        ResultSet rs;
        
        try {
        	String datetime = request.getParameter("Time");
        	String prof1 = request.getParameter("Profile1");
        	String prof2 = request.getParameter("Profile2");
        	int rating = Integer.parseInt(request.getParameter("Rating"));
        	boolean isTrue = sqlA2.past(datetime, prof1, prof2);
        	
        	System.out.println(datetime);
        	System.out.println(prof1);
        	System.out.println(prof2);
        	System.out.println(rating);
        	System.out.println(UserDat.ps1.getProfileID());
        	System.out.println(prof1.equals(UserDat.ps1.getProfileID()) || prof2.equals(UserDat.ps1.getProfileID()));
        	System.out.println(isTrue);
        	
        	
        	
        	if(prof1.equals(UserDat.ps1.getProfileID()) || prof2.equals(UserDat.ps1.getProfileID())) {
        		
        		if(sqlA2.past(datetime, prof1, prof2)) {
        	
        			sqlA.rateDate(UserDat.ps1.getProfileID(), prof1, prof2, rating, datetime);
        	
        	
        			//go home
        			MainHome.profileHome(request, response, 0);
        		}
        	}
        	System.out.println("Didnt work");
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        	
	}
	
