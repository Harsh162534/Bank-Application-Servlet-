package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.entity.Bank;
import com.aurionpro.service.CustomerBankService;
import com.aurionpro.service.dbService;

@WebServlet("/AdminAddBankAccountController")
public class AdminAddBankAccountController extends HttpServlet {
    private CustomerBankService customerBankService;
    private dbService dbService;

    public AdminAddBankAccountController() {
    	
        dbService = new dbService();
        customerBankService = new CustomerBankService(dbService);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Cemail = request.getParameter("Cemail");  
        
        String AccountNumber = request.getParameter("AccountNumber");
        String accountType = request.getParameter("AccountType");
        
        
            Bank bank = new Bank(Cemail, AccountNumber, accountType);
            customerBankService = new CustomerBankService(dbService);
            
            customerBankService.addCustomer(bank.getCustomerEmail(), bank.getCustomerAccountNumber(), bank.getAccountType());
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
