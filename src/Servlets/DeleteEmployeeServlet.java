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

import Main.EmployeeList;


public class DeleteEmployeeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        ArrayList<String> custReps;
			try {
				custReps = EmployeeList.getCustReps();
				request.setAttribute("eList", custReps);
		        RequestDispatcher rs = request.getRequestDispatcher("/EmployeeSelection.jsp");
		        rs.forward(request, response);
			} catch (SQLException e) {
				RequestDispatcher rd = request.getRequestDispatcher("InvalidInput.html");
				rd.forward(request, response);
				e.printStackTrace();
			}
	       
	    }  
}
