<%@page import="com.techblog.dao.DislikeDao"%>
<%@page import="com.techblog.entites.User"%>
<%@page import="com.techblog.dao.Likedao"%>
<%@page import="com.techblog.entites.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.techblog.helper.ConnectionProvider"%>
<%@page import="com.techblog.dao.PostDao"%>

<div class="row">

<%
     User uuuu = (User)session.getAttribute("currentUser");   
 
    Thread.sleep(1000);
  
  PostDao d = new PostDao(ConnectionProvider.getConnection());
  
  int cid = Integer.parseInt(request.getParameter("cid"));
  
  List<Post> posts=null;
  
  if(cid==0){
	  posts = d.getAllPosts();
  }else{
	  posts = d.getAllPostByCatid(cid);
  }
  if(posts.size()==0)
  {
	  out.println("<h3 class='display-3 text-center'>No Posts in this Category..</h3>");
	  return;
  }
	  
  for(Post p:posts){
%>
	<div class="col-md-6 mt-2">
	   <div class="card">
	         <div class="card-body">
	         <h3><%=p.getpTitle() %></h3>
	         <br>
	       
	         <p><%=p.getpContent() %></p>
	         
	         </div>
	         <div class="card-footer primary-background text-center">
	            <%
	              Likedao ld = new Likedao(ConnectionProvider.getConnection());
	            %>
	            <%
	              DislikeDao ldd = new DislikeDao(ConnectionProvider.getConnection());
	            %>
	            <a href="#!" class="btn btn-outline-light btn-sm "><i class="fa fa-thumbs-o-up "></i><span class="like-counter"><%=ld.countLikeOnPost(p.getPid()) %></span></a>
	            <a href="show_blog_page.jsp?post_id=<%=p.getPid()  %>" class="btn btn-outline-light btn-sm ">Read more...</a>
	            <a href="#!" class="btn btn-outline-light btn-sm "><i class="fa fa-thumbs-o-down "></i><span class="dislike-counter"><%=ldd.countDisLikeOnPost(p.getPid()) %></span></a>
	         </div>
	   
	   </div>
	
	</div>
	
	  
	  
<%
	   
  }

%>
</div>