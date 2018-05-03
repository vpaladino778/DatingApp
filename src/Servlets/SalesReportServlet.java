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

import Main.NewRegister;
import Main.SQLAccessor;
import beans.SalesReportBean;

public class SalesReportServlet extends HttpServlet{

	private static final long serialVersionUID = 153524L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		SQLAccessor sqlA = new SQLAccessor();
		ResultSet bestProf;
		try {
			bestProf = sqlA.customerMostRevenue();
			bestProf.next();
			String pID = bestProf.getString("Profile1");
			int revenue = bestProf.getInt("bf");
			ResultSet allRev = sqlA.revenueByCustRep();
			ArrayList<SalesReportBean> salesReports = new ArrayList<SalesReportBean>();
			while(allRev.next()) {
				SalesReportBean srb = new SalesReportBean(allRev.getString("CustRep"),allRev.getInt("BookingFee"));
				salesReports.add(srb);
			}
			request.setAttribute("salesReports", salesReports);
			request.setAttribute("pID", pID);
			request.setAttribute("revenue", revenue);
			RequestDispatcher rs = request.getRequestDispatcher("/Sales_Report.jsp");
			rs.forward(request, response);
		} catch (SQLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("InvalidInput.html");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}  
}
