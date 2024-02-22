package com.techblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.techblog.dao.Userdao;
import com.techblog.entites.Message;
import com.techblog.entites.User;
import com.techblog.helper.ConnectionProvider;


@MultipartConfig
@WebServlet("/editUser")
public class EditServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		pw.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
		pw.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
		pw.println("<title>Edit</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		
		/* fetch all edit data */
		
		String userEmail =request.getParameter("usr_email");
		String userName =request.getParameter("usr_name");
		String userPassword =request.getParameter("usr_password");
		String userAbout =request.getParameter("usr_about");

		
		/* get the user form session */
		
		HttpSession s = request.getSession();
		User user = (User)s.getAttribute("currentUser");
		
		user.setEmail(userEmail);
		user.setName(userName);
		user.setPassword(userPassword);
		user.setAbout(userAbout);
		
		
		//Update database
		Userdao userdao = new Userdao(ConnectionProvider.getConnection());
		boolean ans = userdao.updateData(user);
		
		if (ans) 
		{
		  pw.println("Profile updated...");
		  Message msg = new Message("Profile Details Updated...","success","alert-success");
		  s.setAttribute("msg", msg);			
		}else 
		       {
					pw.println("Profile not updated...");
					Message msg = new Message("Something went wrong...","error","alert-danger");
					s.setAttribute("msg", msg);
				}
		
		 response.sendRedirect("Profile_Page.jsp");
		
		pw.println("</body>");
		
		pw.println("</html>");
		
	}

}
