<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Page</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">        
<link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
  body{
   background:url(img/bgt.jpg);
   background-size:cover;
   background-attachment:fixed;
  }
</style>

</head>
<body>
             <!-- navbar -->
             <nav class="navbar navbar-expand-lg navbar-dark primary-background">
  <a class="navbar-brand" href="index.jsp"><span class="fa fa-graduation-cap"></span>TechBlog</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#"><span class="fa fa-laptop"></span>@Bhushan <span class="sr-only">(current)</span></a>
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
        <a class="nav-link" href="Contact.jsp"><span class="fa fa-phone"></span>Contact</a>
      </li>
     
    
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
   
     <!-- navbar end -->
     
     <div class="container mt-4">
        <div class="row">
           <div class="col-md-8 offset-2">
              <div class="card">
                 <div class="card-header text-center primary-background text-white">
                   <h3>Contact Us</h3>
                   <p>Please fill this form in a decent manner</p>
                 </div>
                  <div class="card-body">
                  <form>
  <div class="form-group">
    <label for="exampleInputPassword1">Full Name</label>
    <input type="text" required class="form-control" id="exampleInputPassword1" placeholder="Enter Name">
  </div>
                  
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" required class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  
  <div class="form-group">
   <label for="exampleInputMessage">Message</label>
   <textarea class="form-control" required placeholder=" Any Suggestion in our TechBlog!" style="height:100px;"></textarea>       
  </div>
  
   <div class="container text-center">
   <button type="submit" class="btn btn-outline-primary">Contact</button>
   </div>
  
</form>
                 </div>
                  <div class="card-footer primary-background text-white">
                     <div class="container">
       <a href="#!" class="btn btn-outline-light btn-sm "><i class="fa fa-twitter"></i></a>
       <a href="#!"class="btn btn-outline-light btn-sm "><i class="fa fa-facebook"></i></a>
       <a href="#!"class="btn btn-outline-light btn-sm "><i class="fa fa-instagram"></i></a>
       <a href="#!"class="btn btn-outline-light btn-sm "><i class="fa fa-linkedin"></i></a>
      <div class="copyright">
        &copy; Copyright <strong><span>2023</span></strong> All Rights Reserved
      </div>
                       
                     </div>
                 </div>
         
           </div>
        
        
        </div>
     
     
     </div>
     
     
     
     

</body>
</html>