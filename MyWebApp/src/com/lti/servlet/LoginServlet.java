package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.service.DatabaseLoginService;
import com.lti.service.InMemoryLoginService;


@WebServlet("/login.lti")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//reading user input
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		//InMemoryLoginService loginService = new InMemoryLoginService(); //made new class
		DatabaseLoginService loginService = new DatabaseLoginService(); 
		boolean isValid = loginService.authenticate(uname, pwd); //to check valid authentication of user
		if(isValid) {
			String rememberMe = request.getParameter("reme");   //to make the remember thing for next time as well
			if(rememberMe != null && rememberMe.contentEquals("yes")) {
				Cookie c1 = new Cookie("uname", uname); // key value format
				c1.setMaxAge(60 * 60); //1 hr
				
				//encode the pwd using Base64 encoding
				// so that pswd not seen in cookie
				
				Cookie c2 = new Cookie("pwd", Base64.getEncoder().encodeToString(pwd.getBytes())); // key value format
				c2.setMaxAge(60 * 60); //1 hr
				response.addCookie(c1);
				response.addCookie(c2);
			}
			response.sendRedirect("welcome.html");
		}
		else
			response.sendRedirect("Login.html"); //redirect page, if valid then to welcome page, if now, then login page again
	}
}
