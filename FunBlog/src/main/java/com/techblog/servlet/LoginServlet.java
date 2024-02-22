package com.techblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techblog.dao.Userdao;
import com.techblog.entites.Message;
import com.techblog.entites.User;
import com.techblog.helper.ConnectionProvider;


@WebServlet("/loginUser")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		pw.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
		pw.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
		pw.println("<title>check</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		
		String userEmail  = request.getParameter("uemail");
		String userPassword  = request.getParameter("upassword");
		
		  Userdao dao = new Userdao(ConnectionProvider.getConnection()); 
		  User u =dao.getUserEmailandUserPassword(userEmail, userPassword); 
		  if (u==null) {
		  
			  //login error
		  
		  Message msg = new Message("Invalid Details","error","alert-danger");
		  
		  HttpSession s = request.getSession(); 
		  s.setAttribute("msg", msg);
		  response.sendRedirect("Login.jsp");
		
		 
		  }else { 
			  
			  //login successful 
			  //Create Session 
		  HttpSession s =request.getSession(); 
		  s.setAttribute("currentUser", u);
		  response.sendRedirect("Profile_Page.jsp"); }
		 
		
		pw.println("</body>");
		
		pw.println("</html>");
	}

}
