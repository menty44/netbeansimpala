<%-- 
    Document   : index
    Created on : Nov 25, 2016, 12:15:27 PM
    Author     : fred
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>TRDR | Login</title>   
    
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>

        <link rel="stylesheet" href="css1/style.css">      
    
  </head>

  <body>

    <div class="login-form">
     <h1>Signin To Portal</h1>
     
     <form action="loginServlet" method="post">
     <div class="form-group ">
         <input type="text" class="form-control" placeholder="username " id="" name="username">
       <i class="fa fa-user"></i>
     </div>
     <div class="form-group log-status">
         <input type="password" class="form-control" placeholder="userpass" id="" name="userpass">
       <i class="fa fa-lock"></i>
     </div>
      <span class="alert">Invalid Credentials</span>
      <a class="link" href="#">Lost your password?</a>
     <button type="submit" class="log-btn" >Log in</button>
     </form>
    
   </div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<!--        <script src="js1/index.js"></script>-->   
  </body>
</html>


