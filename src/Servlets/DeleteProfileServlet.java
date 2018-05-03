package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.EmployeeHome;
import Main.SQLAccessor;

public class DeleteProfileServlet extends HttpServlet{
	private static final long serialVersionUID = 12676734124L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String pID = (String) request.getParameter("Profile");
        SQLAccessor sqlA = new SQLAccessor();
        String SSN;
		try {
			ResultSet rs = sqlA.getProfileSSN(pID);
			rs.next();
			SSN = rs.getString("OwnerSSN");
			sqlA.deleteCustomer(SSN);
			EmployeeHome.loadEmployeeHome(request, response, sqlA);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
