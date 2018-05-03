package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.SQLAccessor;
import Main.UserDat;
import beans.DateBean;

public class ViewDatesServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1456456L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        SQLAccessor sqlA = new SQLAccessor();
        PrintWriter out = response.getWriter();
        ResultSet rs;
        
        //Need past dates
        //need pending dates
        try {
        	ArrayList<DateBean> pastDates = new ArrayList<DateBean>();
        	ArrayList<DateBean> pendingDates = new ArrayList<DateBean>();
        	//collect past dates
        	
			rs = sqlA.viewPastDates(UserDat.ps1.getProfileID());
			while(rs.next()) {
				DateBean newDateBean = new DateBean();
				String Profile1 = rs.getString("Profile1");
				String Profile2 = rs.getString("Profile2");
				int User1Rating = rs.getInt("User1Rating");
				int User2Rating = rs.getInt("User2Rating");
				newDateBean.setProfile1(Profile1);
				newDateBean.setProfile2(Profile2); 
				if(Profile1.equals(UserDat.ps1.getProfileID())) {
					newDateBean.setOtherUser(Profile2);
					newDateBean.setOtherRating(User2Rating);
					newDateBean.setYourRating(User1Rating);
				} else {
					newDateBean.setOtherUser(Profile1);
					newDateBean.setOtherRating(User1Rating);
					newDateBean.setYourRating(User2Rating);
				}
				newDateBean.setCustRep(rs.getString("CustRep"));
				newDateBean.setDateTime(rs.getString("Date_Time"));
				newDateBean.setLocation(rs.getString("Location"));
				newDateBean.setBookingFee(rs.getInt("BookingFee"));
				newDateBean.setComments(rs.getString("Comments"));
				newDateBean.setUser1Rating(User1Rating);
				newDateBean.setUser2Rating(User2Rating);
				newDateBean.setGeoLocation(rs.getString("GeoLocation"));
				pastDates.add(newDateBean);
			}
			request.setAttribute("pastDates", pastDates);
			
			for(int i = 0;i < pastDates.size();i++) {
				System.out.println(pastDates.get(i).getOtherUser());
			}
			
			//collect pending dates
			
			rs = sqlA.viewPendingDates(UserDat.ps1.getProfileID());
			while(rs.next()) {
				DateBean newDateBean = new DateBean();
				String Profile1 = rs.getString("Profile1");
				String Profile2 = rs.getString("Profile2");
				newDateBean.setProfile1(Profile1);
				newDateBean.setProfile2(Profile2); 
				if(Profile1.equals(UserDat.ps1.getProfileID())) {
					newDateBean.setOtherUser(Profile2);
				} else {
					newDateBean.setOtherUser(Profile1);
				}
				newDateBean.setCustRep(rs.getString("CustRep"));
				newDateBean.setDateTime(rs.getString("Date_Time"));
				newDateBean.setLocation(rs.getString("Location"));
				newDateBean.setBookingFee(rs.getInt("BookingFee"));
				newDateBean.setComments(rs.getString("Comments"));
				newDateBean.setUser1Rating(rs.getInt("User1Rating"));
				newDateBean.setUser2Rating(rs.getInt("User2Rating"));
				newDateBean.setGeoLocation(rs.getString("GeoLocation"));
				pendingDates.add(newDateBean);
			}
			request.setAttribute("pendingDates", pendingDates);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("ViewDates.jsp");
		    dispatcher.forward(request, response);
        	
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
