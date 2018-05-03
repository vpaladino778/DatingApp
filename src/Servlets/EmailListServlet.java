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
import beans.ContactBean;
import beans.SalesReportBean;

public class EmailListServlet extends HttpServlet{
	private static final long serialVersionUID = 153528674L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		SQLAccessor sqlA = new SQLAccessor();
		ArrayList<ContactBean> contacts = new ArrayList<ContactBean>();
		try {
			ResultSet rs = sqlA.getAllProfileIDs();
			while(rs.next()) {
				ResultSet rs2 = sqlA.getPrivateInfoFromProfile(rs.getString("ProfileID"));
				rs2.next();
				ContactBean cb = new ContactBean(rs.getString("ProfileID"),rs2.getString("Email"),rs2.getString("FirstName"),rs2.getString("LastName"));
				contacts.add(cb);
			}
			request.setAttribute("contacts", contacts);
			RequestDispatcher rs3 = request.getRequestDispatcher("/ContactList.jsp");
			rs3.forward(request, response);
		} catch (SQLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("InvalidInput.html");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}  
}
