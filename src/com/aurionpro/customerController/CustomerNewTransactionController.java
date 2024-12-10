package com.aurionpro.customerController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aurionpro.customerService.CustomerTransactionService;
import com.aurionpro.entity.Transaction;
import com.aurionpro.service.dbService;


@WebServlet("/CustomerNewTransactionController")
public class CustomerNewTransactionController extends HttpServlet {

	private CustomerTransactionService cTransactionService;
	private dbService dbservice;
    
    public CustomerNewTransactionController() {
    	
    	 dbservice = new dbService();
         cTransactionService = new CustomerTransactionService(dbservice);   
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	        String sAccount = request.getParameter("senderAccount");
		    String rAccount = request.getParameter("receiverAccount"); 
		    String tType = request.getParameter("transactionType"); 
		    
	        String samount = request.getParameter("amount");
	        int amount = Integer.parseInt(samount);
	
	        
	        Transaction transaction = new Transaction(sAccount, rAccount, tType, amount, null);
	        cTransactionService = new CustomerTransactionService(dbservice);
	        cTransactionService.addTransaction(transaction.getSenderAccountNumber(), transaction.getReceiverAccountNumber(),transaction.getTransactionType(), transaction.getAmount());
	}
	
	
	
	
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
