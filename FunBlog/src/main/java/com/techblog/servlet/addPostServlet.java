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

import com.techblog.dao.PostDao;
import com.techblog.entites.Post;
import com.techblog.entites.User;
import com.techblog.helper.ConnectionProvider;


@MultipartConfig
@WebServlet("/postadd")
public class addPostServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter pw = response.getWriter();
	
			int cid = Integer.parseInt(request.getParameter("cid"));			
			String ptitle = request.getParameter("ptitle");
			String pcontent = request.getParameter("pcontent");
			String pcode = request.getParameter("pcode");
			
			/* pw.println(ptitle); */
			
			/* getting currentuser id */
			
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("currentUser");	
			
			Post p = new Post(ptitle,pcontent,pcode,null,cid,user.getId());
			
			PostDao dao = new PostDao(ConnectionProvider.getConnection());
			if (dao.savePost(p)) {
				pw.println("done");
			}else {
				pw.println("error");
			}
			
		
		 
	}

}
