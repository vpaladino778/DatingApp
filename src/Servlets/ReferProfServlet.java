package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.MainHome;
import Main.SQLAccessor;
import Main.UserDat;

public class ReferProfServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		SQLAccessor sqlA = new SQLAccessor();
		String prof1 = request.getParameter("prof1");
		String prof2 = request.getParameter("profile2");
		try {
			System.out.println(UserDat.ps1.getProfileID()+", "+prof1+", "+ prof2);
			sqlA.refferProfile(UserDat.ps1.getProfileID(), prof1, prof2);
			MainHome.profileHome(request, response,0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} 
}

