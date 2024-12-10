package com.aurionpro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.service.AdminService;
import com.aurionpro.service.dbService;
import com.aurionpro.customerService.CustomerLoginService;
import com.aurionpro.entity.Admin;
import com.aurionpro.entity.Customer;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    private AdminService adminService;
    private dbService dbService;
    private CustomerLoginService customerLoginService;

    public LoginController() {
    	
        dbService = new dbService();
        adminService = new AdminService(dbService);
        customerLoginService = new CustomerLoginService(dbService);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        // Dispatcher for page forwarding
        RequestDispatcher dispatcher = null;
        boolean validLogin = false;

        // Validate Admin login
        if ("Admin".equals(role)) {
            Admin admin = adminService.getAdminByUsername(username); // Retrieve admin by username

            if (admin != null && admin.getAdminPassword().equals(password)) {
                validLogin = true;
             	
                
                dispatcher = request.getRequestDispatcher("/AdminHome.jsp"); // Forward to Admin Home
            }
        }
        else if("Customer".equals(role)) {
        	Customer customer = customerLoginService.getCustomerByUsername(username);
        	 if (customer != null && customer.getPassword().equals(password)) {
        	  validLogin = true;
      
        	 dispatcher = request.getRequestDispatcher("/CustomerHome.jsp");
        }
        }

        // If login is valid, set session attributes and forward the request
        if (validLogin) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            
           
            session.setAttribute("role", role);
            dispatcher.forward(request, response); // Forward to home page based on role
        } else {
            // If login is invalid, forward to login page with an error
            response.sendRedirect("login.jsp?error=true");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to the login page if someone accesses the controller directly with GET
        response.sendRedirect("login.jsp");
    }
}
