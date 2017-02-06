package com.fred.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fred.dao.LoginDao;

/**
 *
 * @author fred 0720106420
 */

public class LoginServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String n=request.getParameter("username");  
        String p=request.getParameter("userpass");
        //String e=request.getServerName();    
        
        HttpSession session = request.getSession(false);
        
        if(session!=null)
        session.setAttribute("name", n);
        session.setMaxInactiveInterval(1*60);
        //session.setAttribute("email", p);

        if(LoginDao.validate(n, p)){  
            RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
            rd.forward(request,response);  
        }  
        else{  
            out.print("</p></p><strong><center><p style=\"color:white\">Sorry <font color=\"#0AC986\">USERNAME</font> or <font color=\"#0AC986\">PASSWORD</font> error</p><center><strong>");  
            RequestDispatcher rd=request.getRequestDispatcher("signin.jsp");  
            rd.include(request,response);  
        }  

        out.close();  
    }  
} 
