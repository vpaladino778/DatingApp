package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.EditProfile;
import Main.NewRegister;

public class EditProfileServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String profileID = request.getParameter("regID");
        int age  = Integer.parseInt(request.getParameter("regAge"));
        int dars  = Integer.parseInt(request.getParameter("regDars"));
        int dare  = Integer.parseInt(request.getParameter("regDare"));
        int dgr  = Integer.parseInt(request.getParameter("regDgr"));
        int height  = Integer.parseInt(request.getParameter("regHeight"));
        String gender = request.getParameter("regMF");
        String hobbies = request.getParameter("regHobbies");
        String hair = request.getParameter("regHair");
        int weight  = Integer.parseInt(request.getParameter("regWeight"));
        boolean validation = EditProfile.editprofile(profileID, age, dars, dare, dgr, gender, hobbies, height, weight, hair);

        
        request.setAttribute("auth", validation);
        if(validation)
        {
        	
            RequestDispatcher rs = request.getRequestDispatcher("/Home.jsp");
            rs.forward(request, response);
        }
        else
        {
        	
        	out.println("Username or Password incorrect");
        	RequestDispatcher rs = request.getRequestDispatcher("login.html");
        	rs.include(request, response);
           
        }
    } 
}
