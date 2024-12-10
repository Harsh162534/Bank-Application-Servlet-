package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.entity.Admin;
import com.aurionpro.service.AdminService;
import com.aurionpro.service.dbService;

@WebServlet("/AdminRegistrationController")

public class AdminRegistrationController extends HttpServlet {
	
	private Admin admin;
	private dbService service = new dbService();
	private AdminService aservice;
	
	
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String username = request.getParameter("username");  
	     String password = request.getParameter("password");
		
		
		Admin admin=new Admin(username,password);
		aservice = new AdminService(service);
		
		aservice.addAdmin(admin.getAdminName(), admin.getAdminPassword());
		
		 response.sendRedirect("login.jsp");
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
