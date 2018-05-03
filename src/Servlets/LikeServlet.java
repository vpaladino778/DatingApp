package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.SQLAccessor;
import Main.UserDat;
import beans.ProfileBean;

/**
 * Servlet implementation class LikeServlet
 * Allows users to LIKE another user
 */
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String likerProfile = UserDat.ps1.getProfileID();
		String likeeProfile = request.getParameter("liker");
		SQLAccessor accessor = new SQLAccessor();
		try {
			accessor.likeProfile(likerProfile, likeeProfile);
		} catch (SQLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("InvalidInput.html");
			rd.forward(request, response);
			e.printStackTrace();
		}

		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

}
