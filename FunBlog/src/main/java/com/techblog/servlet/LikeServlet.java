package com.techblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techblog.dao.Likedao;
import com.techblog.helper.ConnectionProvider;


@WebServlet("/likeuser")
public class LikeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
	
		
		String operation = request.getParameter("operation");
		int pid = Integer.parseInt(request.getParameter("pid"));
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		/*
		 * pw.println("data from server"); 
		 * pw.println(operation);
		 *  pw.println(pid);
		 * pw.println(uid);
		 */
		
		Likedao  ldao = new Likedao(ConnectionProvider.getConnection());
		
		if(operation.equals("like")) {
			
			boolean f = ldao.insertLike(pid, uid);
			pw.println(f);
			
		}
		
		
		
	}

}
