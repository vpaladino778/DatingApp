package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.MainHome;
import Main.SQLAccessor;
import Main.UserDat;
import beans.DateBean;

public class CancelDateServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 12134L;
	
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
        	
        	if(prof1.equals(UserDat.ps1.getProfileID()) || prof2.equals(UserDat.ps1.getProfileID())) {
        		if(sqlA2.now(datetime, prof1, prof2)) {
        	
        			sqlA.cancelDate(prof1, prof2, datetime);
        	
        	
        			//go home
        			MainHome.profileHome(request, response, 0);
        		}
        	}
        	
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
