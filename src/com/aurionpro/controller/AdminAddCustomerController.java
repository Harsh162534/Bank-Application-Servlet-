package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.entity.Admin;
import com.aurionpro.entity.Customer;
import com.aurionpro.service.AdminService;
import com.aurionpro.service.CustomerService;
import com.aurionpro.service.dbService;

@WebServlet("/AdminAddCustomerController")

public class AdminAddCustomerController extends HttpServlet {
	
	    private CustomerService customerService;
	    private dbService dbService;

	    public AdminAddCustomerController() {
	    	
	        dbService = new dbService();
	        customerService = new CustomerService(dbService);
	    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    String fname = request.getParameter("fname");
	        String lname = request.getParameter("lname");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
		
		
		Customer customer =new Customer(fname,lname,email,password);
		customerService = new CustomerService(dbService);
		
		customerService.addCustomer(customer.getFname(), customer.getLname(),customer.getEmail(),customer.getPassword());
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
