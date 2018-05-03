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

import Main.EmployeeHome;
import Main.EmployeeList;
import Main.SQLAccessor;

public class DeleteAndReturn extends HttpServlet{
	
	private static final long serialVersionUID = 1234234124L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String employee = (String) request.getParameter("Employee");
        System.out.println("THe employee name is "+employee);
        String[] names = employee.split(", ",5);
        SQLAccessor sqlA = new SQLAccessor();
        String SSN;
		try {
			SSN = sqlA.getSSNFromName(names[0], names[1]);
			sqlA.deleteEmployee(SSN);
			EmployeeHome.loadEmployeeHome(request, response, sqlA);
			
		} catch (SQLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("InvalidInput.html");
			rd.forward(request, response);
			e.printStackTrace();
		}
    }
}
