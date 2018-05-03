package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Main.ProfileDAO;
import Main.UserDat;
import beans.ProfileBean;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
    
	private ProfileDAO profileDAO;
	
	
    @Override
    public void init() {
    	profileDAO = new ProfileDAO();
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		List<ProfileBean> profiles = profileDAO.list();
    		String searchQuery = request.getParameter("searchField");
    		
    		if(searchQuery != null) {
    			List<ProfileBean> results = profileDAO.PerformSearch(searchQuery, profiles);
        		request.setAttribute("profiles", results); // Results of search
    		}else {
        		request.setAttribute("profiles", profiles); // Will be available as ${profile} in JSP
    		}
    		
    		System.out.println("See this pID as "+UserDat.ps1.getProfileID());
    		request.setAttribute("loggedIn", UserDat.ps1.getProfileID());
            request.getRequestDispatcher("Profiles.jsp").forward(request, response);
    	}catch (SQLException e) {
    		RequestDispatcher rd = request.getRequestDispatcher("InvalidInput.html");
			rd.forward(request, response);
            throw new ServletException("Cannot obtain profiles from DB", e);
        }
	}
    
    

}
