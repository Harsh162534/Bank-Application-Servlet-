package com.aurionpro.customerController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.customerService.CustomerViewPassbookService;
import com.aurionpro.entity.Transaction;
import com.aurionpro.service.dbService;


@WebServlet("/CustomerViewPassbookController")
public class CustomerViewPassbookController extends HttpServlet {
    
    private CustomerViewPassbookService cViewPassbookService;
    private dbService dbservice;
    
    public CustomerViewPassbookController() {
        dbservice = new dbService();
        cViewPassbookService = new CustomerViewPassbookService(dbservice);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username"); // Assuming 'username' is stored in the session

        if (username == null) {
            // If username is not found in the session, redirect to login page
            response.sendRedirect("login.jsp");
            return;
        }

        try {
        	List<Transaction> transactionList = cViewPassbookService.getAllTransaction(username); 
        	request.setAttribute("transaction", transactionList);
        	
        	
        	request.getRequestDispatcher("ViewPassbook.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
