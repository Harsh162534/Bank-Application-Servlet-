package com.aurionpro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.entity.Transaction;
import com.aurionpro.service.AdminViewTransactionService;
import com.aurionpro.service.dbService;

@WebServlet("/AdminViewTransactionController")
public class AdminViewTransactionController extends HttpServlet {
    
    private AdminViewTransactionService AviewTransactionService;
    private dbService dbservice;
    
    public AdminViewTransactionController() {
        dbservice = new dbService();
        AviewTransactionService = new AdminViewTransactionService(dbservice);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
           
            List<Transaction> transactionList = AviewTransactionService.getAllTransaction();
            
            request.setAttribute("transactionList", transactionList);
            
           
            request.getRequestDispatcher("ViewTransaction.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
      
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // Using GET to show the customer data
    }
}
