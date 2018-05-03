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

import Main.SQLAccessor;
import Main.UserDat;
import beans.DateBean;

public class CancelDateServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        SQLAccessor sqlA = new SQLAccessor();
        PrintWriter out = response.getWriter();
        ResultSet rs;
        
        try {
        	String dateTime = request.getParameter("cancelDateTime");
        	String otherUser = request.getParameter("cancelOtherUser");
        	String profile1 = request.getParameter("cancelProfile1");
        	String profile2 = request.getParameter("cancelProfile2");
        	
        	sqlA.cancelDate(profile1, profile2, dateTime);
        	
        	//go home
        	
			
        	
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
