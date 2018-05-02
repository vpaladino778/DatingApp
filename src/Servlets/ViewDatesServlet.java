package Servlets;

import java.io.IOException;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        SQLAccessor sqlA = new SQLAccessor();
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
				newDateBean.setProfile1(Profile1);
				newDateBean.setProfile2(Profile2); 
				if(Profile1.equals(UserDat.ps1.getProfileID())) {
					newDateBean.setOtherUser(Profile2);
				} else {
					newDateBean.setOtherUser(Profile1);
				}
				newDateBean.setCustRep(rs.getString("CustRep"));
				newDateBean.setDate_Time(rs.getString("Date_Time"));
				newDateBean.setLocation(rs.getString("Location"));
				newDateBean.setBookingFee(rs.getInt("BookingFee"));
				newDateBean.setComment(rs.getString("Comment"));
				newDateBean.setUser1Rating(rs.getInt("User1Rating"));
				newDateBean.setUser2Rating(rs.getInt("User2Rating"));
				newDateBean.setGeoLocation(rs.getString("GeoLocation"));
				pastDates.add(newDateBean);
			}
			request.setAttribute("pastDates", pastDates);
			
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
				newDateBean.setDate_Time(rs.getString("Date_Time"));
				newDateBean.setLocation(rs.getString("Location"));
				newDateBean.setBookingFee(rs.getInt("BookingFee"));
				newDateBean.setComment(rs.getString("Comment"));
				newDateBean.setUser1Rating(rs.getInt("User1Rating"));
				newDateBean.setUser2Rating(rs.getInt("User2Rating"));
				newDateBean.setGeoLocation(rs.getString("GeoLocation"));
				pendingDates.add(newDateBean);
			}
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewDates.jsp");
		    dispatcher.forward(request, response);
        	
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
