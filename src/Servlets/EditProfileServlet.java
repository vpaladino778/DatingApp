package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.EditProfile;
import Main.NewRegister;
import Main.ProfileList;
import Main.UserDat;

public class EditProfileServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        boolean successfulEdit = false;
        try {
        	int age  = Integer.parseInt(request.getParameter("regAge"));
        	int dars  = Integer.parseInt(request.getParameter("regDars"));
        	int dare  = Integer.parseInt(request.getParameter("regDare"));
        	int dgr  = Integer.parseInt(request.getParameter("regDgr"));
        	String gender = request.getParameter("regMF");
        	String hobbies = request.getParameter("regHobbies");
        	int height  = Integer.parseInt(request.getParameter("regHeight"));
        	int weight  = Integer.parseInt(request.getParameter("regWeight"));
        	String hair = request.getParameter("regHair");
        	String SSN = UserDat.ps1.getSSN();
        	successfulEdit = EditProfile.editprofile(SSN, age, dars, dare, dgr, gender, hobbies, height, weight, hair);
        }catch(NumberFormatException e) {
        	RequestDispatcher rd = request.getRequestDispatcher("InvalidInput.html");
			rd.forward(request, response);
        }
        

        if(successfulEdit) {
        	System.out.println("Edit worked");
        	String email = UserDat.ps1.getEmail();
        	System.out.println(email);
        	ArrayList<String> profileList = ProfileList.getProfileList(email);  	
        	request.setAttribute("pList", profileList);
            RequestDispatcher rs = request.getRequestDispatcher("/ProfileSelection.jsp");
            rs.forward(request, response);
        }
        else {
        	System.out.println("unsuccessful edit");
        	RequestDispatcher rs = request.getRequestDispatcher("login.html");
        	rs.include(request, response);
        }
    } 
}
