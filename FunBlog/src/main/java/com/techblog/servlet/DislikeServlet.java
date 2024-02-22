package com.techblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techblog.dao.DislikeDao;
import com.techblog.helper.ConnectionProvider;


@WebServlet("/dislikeuser")
public class DislikeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String operation = request.getParameter("operation");
		int pdid = Integer.parseInt(request.getParameter("pdid"));
		int udid = Integer.parseInt(request.getParameter("udid"));
		
		/*
		 * pw.println("data from server"); pw.println(operation); pw.println(pdid);
		 * pw.println(udid);
		 */
		DislikeDao dldao = new DislikeDao(ConnectionProvider.getConnection());
            if(operation.equals("dislike")) {
			
			boolean f = dldao.insertDisLike(pdid, udid);
			pw.println(f);
			
		}
		
	 
	}

}
