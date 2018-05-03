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
import Main.UserDat;
import beans.DateBean;
import beans.ReferralBean;
import beans.SuggestedByBean;

public class ViewRFSBServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 20L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        SQLAccessor sqlA = new SQLAccessor();
        SQLAccessor sqlA2 = new SQLAccessor();
        PrintWriter out = response.getWriter();
        ResultSet rs;
        ResultSet rs2;
        
        //Need past dates
        //need pending dates
        try {
        	ArrayList<ReferralBean> refer = new ArrayList<ReferralBean>();
        	ArrayList<SuggestedByBean> suggest = new ArrayList<SuggestedByBean>();
        	
			rs = sqlA.viewReferred(UserDat.ps1.getProfileID());
			while(rs.next()) {
				ReferralBean newReferralBean = new ReferralBean();
				String ProfileB = rs.getString("ProfileB");
				String ProfileC = rs.getString("ProfileC");
				newReferralBean.setProfileB(ProfileB);
				newReferralBean.setProfileC(ProfileC); 
				if(ProfileB.equals(UserDat.ps1.getProfileID())) {
					newReferralBean.setTheirProfile(ProfileC);
					newReferralBean.setYourProfile(ProfileB);
				} else {
					newReferralBean.setTheirProfile(ProfileB);
					newReferralBean.setYourProfile(ProfileC);
				}
				newReferralBean.setDateTime(rs.getString("Date_Time"));
				
				refer.add(newReferralBean);
			}
			request.setAttribute("refer", refer);
			
			//collect pending dates
			
			rs2 = sqlA2.viewSuggestedBy(UserDat.ps1.getProfileID());
			while(rs2.next()) {
				SuggestedByBean newSuggestBean = new SuggestedByBean();
				String Profile1 = rs2.getString("Profile1");
				String Profile2 = rs2.getString("Profile2");
				newSuggestBean.setProfile1(Profile1);
				newSuggestBean.setProfile2(Profile2); 
				if(Profile1.equals(UserDat.ps1.getProfileID())) {
					newSuggestBean.setTheirProfile(Profile2);
					newSuggestBean.setYourProfile(Profile1);
				} else {
					newSuggestBean.setTheirProfile(Profile1);
					newSuggestBean.setYourProfile(Profile2);
				}
				newSuggestBean.setCustRep(rs2.getString("CustRep"));
				newSuggestBean.setDateTime(rs2.getString("Date_Time"));
				suggest.add(newSuggestBean);
			}
			request.setAttribute("suggest", suggest);
		    
		    RequestDispatcher dispatcher = request.getRequestDispatcher("ViewRFSB.jsp");
		    dispatcher.forward(request, response);
        	
        	
		} catch (SQLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("InvalidInput.html");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}
	
}
