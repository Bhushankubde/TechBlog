package com.techblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techblog.dao.Userdao;
import com.techblog.entites.User;
import com.techblog.helper.ConnectionProvider;

@MultipartConfig
@WebServlet("/addReg")
public class RegServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String check = request.getParameter("check");
		if(check==null) {
			pw.println("box not checked");
		}else {
			
			String name= request.getParameter("user_name");
			String email= request.getParameter("user_email");
			String password= request.getParameter("user_password");
			String gender= request.getParameter("gender");
			String about= request.getParameter("about");
			User user = new User(name,email,password,gender,about);
			
			Userdao dao = new Userdao(ConnectionProvider.getConnection());
			
			if(dao.saveUser(user)) {
				pw.println("done");
			}
		
			  else { pw.println("error"); }
			  
			  }
			 
	}
 } 
