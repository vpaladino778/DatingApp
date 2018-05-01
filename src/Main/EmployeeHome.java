package Main;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeHome {

	public static void loadEmployeeHome(HttpServletRequest request, HttpServletResponse response, SQLAccessor sqlA) throws SQLException, ServletException, IOException {
		ResultSet employee = sqlA.getEmployeeInfo(UserDat.ps1.getSSN());
		employee.next();
		request.setAttribute("role", employee.getString("Role"));
		request.setAttribute("SSN", employee.getString("SSN"));
		request.setAttribute("wage", employee.getInt("HourlyRate"));
		request.setAttribute("start", employee.getDate("StartDate"));
		RequestDispatcher rs = request.getRequestDispatcher("/Employee_Control.jsp");
		rs.forward(request, response);
	}
}
