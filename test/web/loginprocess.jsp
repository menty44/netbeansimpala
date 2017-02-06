<%-- 
    Document   : loginprocess
    Created on : Dec 6, 2016, 9:23:45 AM
    Author     : fred
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@page import="com.fred.dao.LoginDao"%>  
    <jsp:useBean id="obj" class="com.fred.bean.LoginBean"/>  
      
    <jsp:setProperty property="*" name="obj"/>  
      
    <%  
    boolean status=LoginDao.validate(obj);  
    if(status){  
    out.println("You r successfully logged in");  
    session.setAttribute("session","TRUE");  
    }  
    else  
    {  
    out.print("Sorry, email or password error");  
    %>  
    <jsp:include page="index.jsp"></jsp:include>  
    <%  
    }  
    %>  
