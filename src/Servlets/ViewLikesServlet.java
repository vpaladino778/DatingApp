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
import beans.LikesBean;

public class ViewLikesServlet extends HttpServlet {

	private static final long serialVersionUID = 6868L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        SQLAccessor sqlA = new SQLAccessor();
        SQLAccessor sqlA2 = new SQLAccessor();
        PrintWriter out = response.getWriter();
        ResultSet rs;
        ResultSet rs2;
        
        try {
        	ArrayList<LikesBean> likeeList = new ArrayList<LikesBean>();
        	ArrayList<LikesBean> likerList = new ArrayList<LikesBean>();
        	
			rs = sqlA.viewLiked(UserDat.ps1.getProfileID());
			while(rs.next()) {
				LikesBean newLikesBean = new LikesBean();
				newLikesBean.setLikee(rs.getString("Likee"));
				newLikesBean.setDateTime(rs.getString("Date_Time"));
				newLikesBean.setLiker(rs.getString("Liker"));
				likeeList.add(newLikesBean);
			}
			request.setAttribute("likeeList", likeeList);
			//collect pending dates
			
			rs2 = sqlA2.viewLikee(UserDat.ps1.getProfileID());
			while(rs2.next()) {
				LikesBean newLikesBean = new LikesBean();
				newLikesBean.setLiker(rs2.getString("Liker"));
				System.out.println(rs2.getString("Liker"));
				newLikesBean.setLikee(rs2.getString("Likee"));
				newLikesBean.setDateTime(rs2.getString("Date_Time"));
				likerList.add(newLikesBean);
			}
			request.setAttribute("likerList", likerList);
		    
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewLikes.jsp");
		    dispatcher.forward(request, response);
        	
        	
		} catch (SQLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("InvalidInput.html");
			rd.forward(request, response);
			e.printStackTrace();
		}
        
		
	}
	
	
}
