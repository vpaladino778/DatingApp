package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.EmployeeHome;
import Main.SQLAccessor;


public class AddEmployeeServlet extends HttpServlet{
	private static final long serialVersionUID = 1232343L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String empSSN = request.getParameter("empSSN");
        String empPass = request.getParameter("empPass");
        String empFirst = request.getParameter("empFirst");
        String empLast = request.getParameter("empLast");
        String empStreet = request.getParameter("empStreet");
        String empCity = request.getParameter("empCity");
        String empState = request.getParameter("empState");
        String empZip = request.getParameter("empZip");
        String empEmail = request.getParameter("empEmail");
        String empRole = request.getParameter("empRole");
        int empHR = Integer.parseInt(request.getParameter("empHR"));
        String empPhone = request.getParameter("empTelephone");
        SQLAccessor sqlA = new SQLAccessor();
        try {
			sqlA.newEmployee(empSSN, empRole, empHR, empPass, empFirst, empLast, empEmail, empStreet, empCity, empState, empZip, empPhone);
			EmployeeHome.loadEmployeeHome(request, response, sqlA);
		} catch (SQLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("InvalidInput.html");
			rd.forward(request, response);
			e.printStackTrace();
		}
        
    } 
}
