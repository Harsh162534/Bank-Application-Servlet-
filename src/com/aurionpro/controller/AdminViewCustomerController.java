package com.aurionpro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.entity.Customer;
import com.aurionpro.service.AdminViewCustomerService;
import com.aurionpro.service.dbService;

@WebServlet("/AdminViewCustomerController")
public class AdminViewCustomerController extends HttpServlet {
    
    private AdminViewCustomerService AviewCustomerService;
    private dbService dbservice;
    
    public AdminViewCustomerController() {
        dbservice = new dbService();
        AviewCustomerService = new AdminViewCustomerService(dbservice);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            
            List<Customer> customerList = AviewCustomerService.getAllCustomers();
            request.setAttribute("customers", customerList);
            
            request.getRequestDispatcher("ViewCustomer.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
          
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // Using GET to show the customer data
    }
}
