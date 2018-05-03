package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.EmployeeHome;
import Main.SQLAccessor;
import Main.UserDat;

public class SuggestProfServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        SQLAccessor sqlA = new SQLAccessor();
        String prof1 = request.getParameter("prof1");
        String prof2 = request.getParameter("prof2");
        try {
			sqlA.suggestProfile(prof1, prof2, UserDat.ps1.getSSN());
			EmployeeHome.loadEmployeeHome(request, response, sqlA);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    } 
}
