<%@page import="com.techblog.dao.DislikeDao"%>
<%@page import="com.techblog.dao.Likedao"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.techblog.dao.Userdao"%>
<%@page import="com.techblog.entites.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.techblog.entites.Post"%>
<%@page import="com.techblog.helper.ConnectionProvider"%>
<%@page import="com.techblog.dao.PostDao"%>
<%@page import="com.techblog.entites.User"%>
<%@page errorPage="Error_Page.jsp" %>
<%
User user =(User)session.getAttribute("currentUser");
if(user==null){
	response.sendRedirect("Login.jsp");
}

%>
<%
 int postID = Integer.parseInt(request.getParameter("post_id"));
  PostDao dao = new PostDao(ConnectionProvider.getConnection());
  Post p = dao.getPostByPostId(postID);

%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=p.getpTitle() %>||TechBlog By @Bhushan</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">        
<link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
  .post-title{
   font-weight:100;
   font-size:40px;
  }
  .post-content{
   font-weight:100;
   font-size:25px;
  }
  .post-date{
    font-style:italic;
    font-weight:bold;
  }
  .post-user-info{
   font-size:15px;
  }
  .row-user{
  border:1px solid #e2e2e2;
  padding-top:10px;
  }
  .post-code{
     background:#9e9e9e;
     color:#000;
  }
  body{
   background:url(img/bgt.jpg);
   background-size:cover;
   background-attachment:fixed;
  }

</style>		
    			
</head>
<body>
                   
                   
                         <!--  navbar -->
       
       <nav class="navbar navbar-expand-lg navbar-dark primary-background">
  <a class="navbar-brand" href="index.jsp"><span class="fa fa-graduation-cap"></span>TechBlog</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="Profile_Page.jsp"><span class="fa fa-laptop"></span>@Bhushan <span class="sr-only">(current)</span></a>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <span class="fa fa-check-square-o"></span>Categories
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Programming Language</a>
          <a class="dropdown-item" href="#">Project Implementation</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Data Structure</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"><span class="fa fa-phone"></span>Contact</a>
        
     <!--  </li>
      <li class="nav-item">
        <a class="nav-link" href="#" data-toggle="modal" data-target="#add-post-model"><span class="fa fa-asterisk"></span>Post</a>
      </li>
       -->
    
    
    </ul>
       
    <ul class="navbar-nav mr-right">
             
          <li class="nav-item">
           <a class="nav-link" href="#!" data-toggle="modal" data-target="#profile-modal"><span class="fa fa-user-circle"></span><%=user.getName() %></a>
          </li>   
         
          <li class="nav-item">
           <a class="nav-link" href="logout_user"><span class="fa fa-user-plus"></span>Logout</a>
          </li>
             
    </ul>
  </div>
</nav>
       
       
     <!--   navbar end -->
     
     
    <!--  Main content of body -->
    
         <div class="container">
            <div class="row my-4">
              <div class="col-md-8 offset-md-2">
              
                 <div class="card">
                 
                    <div class="card-header primary-background text-white">
                       <h4 class="post-title"><%=p.getpTitle() %></h4>
                    </div> 
                    
                     <div class="card-body">
                       <p class="post-content"><%=p.getpContent() %></p>
                       
                       <br>
                       <br>
                       
                       <div class="post-code">
                       <pre><%=p.getpCode() %></pre>
                       </div>
                              <!--  User name and post time display on card-body -->
                       <div class="row row-user">
                          <div class="col-md-8">
                               <!--   userID se name fetch -->
                            <% 
                                Userdao ud = new Userdao(ConnectionProvider.getConnection()); 
                            
                            %>
                            <p class="post-user-info"><a href="#!"><%=ud.getUserIdByusertId(p.getUserID()).getName() %></a> posted a post:</p>
                          </div>
                          <div class="col-md-4">
                             <p class="post-date"><%=DateFormat.getDateTimeInstance().format(p.getpDate()) %></p>
                          </div>
                          
                       </div>
                    </div> 
                    
                     <div class="card-footer primary-background">
                     <%
                     Likedao ld = new Likedao(ConnectionProvider.getConnection());
                     
                     %>
                     <%
                     DislikeDao ldd = new DislikeDao(ConnectionProvider.getConnection());
                     %>
                  <a href="#!" onclick="doLike(<%=p.getPid() %>,<%=user.getId() %>)" class="btn btn-outline-light btn-sm "><i class="fa fa-thumbs-o-up"></i><span class="like-counter"><%=ld.countLikeOnPost(p.getPid()) %></span></a>
	            
	              <a href="#!" onclick="dodisLike(<%=p.getPid() %>,<%=user.getId() %>)" class="btn btn-outline-light btn-sm "><i class="fa fa-thumbs-o-down "></i><span class="dislike-counter"><%=ldd.countDisLikeOnPost(p.getPid()) %></span></a>
                    
                     </div>
                    
                 </div> 
                    
              </div>
            
            </div>
         
         </div>
    
    
    
    <!--  Main content of body end -->
     
                   
    <!-- Profile modal  -->

<!-- Modal -->
<div class="modal fade" id="profile-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header primary-background text-white">
        <h5 class="modal-title" id="exampleModalLabel">TechBlog</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container text-center">
           <img src="pics/<%=user.getProfile()%>" class="img-fluid" style="border-radius:50%; max-width:120px;">
               <h5 class="modal-title " id="exampleModalLabel"><%=user.getName() %></h5>
        
             
                                <!--  User Details -->
            
             <div id="profile-details">
             
             <table class="table">
 
  <tbody>
    <tr>
      <th scope="row">ID :</th>
      <td><%=user.getId() %></td>
     
    </tr>
    <tr>
      <th scope="row">Email :</th>
      <td><%=user.getEmail() %></td>
     
    </tr>
    
    <tr>
      <th scope="row">Gender :</th>
      <td><%=user.getGender() %></td>
      
    </tr>
    
    <tr>
      <th scope="row">Status :</th>
      <td><%=user.getAbout() %></td>
      
    </tr>
    
     <tr>
      <th scope="row">Registered :</th>
      <td><%=user.getDateTime().toString() %></td>
      
    </tr>
  </tbody>
</table>

 </div>
                   <!-- profile-edit -->
                   <div id="profile-edit" style="display:none;">
                   <h3 class="mt-2">Please Edit Carefully!</h3>
                   <form action="editUser" method="post" enctype="multipart/form-data">
                     <table class="table">
                       <tr>
                           <td>ID :</td>
                           <td><%=user.getId() %></td>
                       </tr>
                       
                       <tr>
                           <td>Email :</td>
                           <td><input type="email" class="from-control" name="usr_email"value="<%=user.getEmail()%>"></td>
                       </tr>
                       
                       <tr>
                           <td>Password :</td>
                           <td><input type="password" class="from-control" name="usr_password"value="<%=user.getPassword()%>"></td>
                       </tr>
                       
                       <tr>
                           <td>Name :</td>
                           <td><input type="text" class="from-control" name="usr_name"value="<%=user.getName()%>"></td>
                       </tr>
                       
                       
                        <tr>
                           <td>Gender :</td>
                           <td><%=user.getGender().toUpperCase() %></td>
                       </tr>
                       
                       <tr>
                           <td>About :</td>
                           <td>
                          <textarea rows="2" class="form-control" name="usr_about"><%=user.getAbout() %>
                          </textarea>
                          </td>
                       </tr>
                       
                     </table>
                       <div class="container">
                        <button type="submit" class="btn btn-outline-primary">Save</button>
                       </div>
                   </form>
                   </div>
              
          </div>
          
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button id="profile-edit-btn" type="button" class="btn btn-primary">Edit</button>
      </div>
    </div>
  </div>
</div>
    
                               <!-- Profile modal end -->
    
                           <!--  Post model start -->
   

<!-- Modal -->
<div class="modal fade" id="add-post-model" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Provide the post details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
            
            <form id="add-post-form" action="postadd"method="post">
            
              <div class="form-group">
                <select class="form-control" name="cid">
                <option selected disabled>----select category----</option>
                <%
                  
                   PostDao postd = new PostDao(ConnectionProvider.getConnection());
                   ArrayList<Category>list = postd.getAllCategories();
                   for(Category c:list)
                   { 
                %>
                <option value="<%=c.getCid()%>"><%=c.getName() %></option>
                
                <%
                   }
                %>
                </select> 
              </div>
            
              <div class="form-group">
                 <input type="text" name="ptitle" placeholder="Enter Post Title" class="form-control">
              </div>
              
              <div class="form-group">
                 <textarea class="form-control" name="pcontent" placeholder="Enter Post Content" style="height:100px;"></textarea>
              </div>
              
              <div class="form-group">
                 <textarea class="form-control" name="pcode" placeholder="Enter Post Program(If any)" style="height:150px;"></textarea>
              </div>
              
                <div class="container text-center">
                    <button type="submit" class="btn btn-outline-primary">Post</button>
                </div>
              
              </form>
            
            
            
      </div>
      
    </div>
  </div>
</div>
   
   
   
  <!--  Post model end -->
     
     
       <!--  javascript -->

  <script
  src="https://code.jquery.com/jquery-3.7.0.min.js"
  integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
  crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
<script src="js/myjs.js" type="text/javascript"></script>
 
 <script>
   $(document).ready(function(){
	   
	    let editStatus=false;
	    
	   $('#profile-edit-btn').click(function(){
		  /*  alert("button clicked"); */
		    if(editStatus==false){
		    	
		    	 $("#profile-details").hide()
				  $("#profile-edit").show()
				  editStatus=true;
		    	 $(this).text("Back");
		    	 
		    }else{
		    	
		    	 $("#profile-details").show()
				  $("#profile-edit").hide()
				  editStatus=false;	
		    	 $(this).text("Edit");
		    }
	   })
   });
  
 </script>
 
                <!--  now add post js--> 
        <script>
        
        $(document).ready(function(e){
        	//alert("Loaded....");
        	
        	$("#add-post-form").on("submit",function(event){
        		//the post form is submitted then this function called 
        		event.preventDefault();
        		console.log("you have clicked on submit");
        		let form = new FormData(this);
        		//now requesting server
        		$.ajax({
        			
        			url:"postadd",
        		    type: 'POST',
                    data: form,
                    success: function (data, textStatus, jqXHR) {
                    	//success....
                    	console.log(data);
                    	if(data.trim()=='done'){
                    		swal("Good job!", "saved Sucessfully!", "success");
                    	}else{
                    		swal("Error!", "Something went wrong try Again!", "error");
                    	}
                        
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        //error....
                    	swal("Error!", "Something went wrong try Again!", "error");
                    },
                    processData: false,
                    contentType: false
        			
        		})
        		
        	})     	
    
        })
       
        </script>

</body>
</html>