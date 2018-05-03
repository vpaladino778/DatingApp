package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.EmployeeList;
import Main.ProfileList;

public class DeleteProfileListServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ArrayList<String> profiles;
		try {
			profiles = ProfileList.getAllProfiles();
			request.setAttribute("pList", profiles);
	        RequestDispatcher rs = request.getRequestDispatcher("/ProfileDeleteSelection.jsp");
	        rs.forward(request, response);
		} catch (SQLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("InvalidInput.html");
			rd.forward(request, response);
			e.printStackTrace();
		}
       
    }
}
