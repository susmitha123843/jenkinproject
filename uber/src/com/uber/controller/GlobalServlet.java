package com.uber.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uber.entity.UberEmployee;
import com.uber.service.UberEmployeeService;
import com.uber.service.UberEmployeeServiceInterface;

public class GlobalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String option= request.getParameter("ac");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		if(option.equals("register"))
		{
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			String email=request.getParameter("email");
			String address=request.getParameter("address");
			UberEmployee ue=new UberEmployee();
			ue.setName(name);
			ue.setPassword(pass);
			ue.setEmail(email);
			ue.setAddress(address);
			UberEmployeeServiceInterface us=UberEmployeeService.createObject(ue);
			int i=us.createProfile(ue);
			if(i>0)
			{
				out.println("profile created");
			}else
			{
				out.println("profile cant be created");
			}
	
			
		}
		if(option.equals("login"))
		{
			
		}
		
		out.println("</body></html>");
	}

}
