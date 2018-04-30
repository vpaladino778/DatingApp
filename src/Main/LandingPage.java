package Main;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LandingPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Home", "/DatingApp/Home");
        RequestDispatcher rs = request.getRequestDispatcher("/Home.jsp");
        rs.forward(request, response);
        //response.sendRedirect("/DatingApp/Home.jsp");
      }  
}
