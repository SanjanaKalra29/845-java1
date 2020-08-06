package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/Calculator.lti") //URL used in the browser 
public class CalcServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//reading input by user
		int no1 = Integer.parseInt(request.getParameter("no1"));  //match the thing with no1
		int no2 = Integer.parseInt(request.getParameter("no2"));
		int result = no1 + no2;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.write("<html><body>");
		out.write("<h2>Result is : " + result + "</h2>");
		out.write("</body></html>");
	}
}
