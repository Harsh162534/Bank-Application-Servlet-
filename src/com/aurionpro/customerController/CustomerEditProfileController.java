package com.aurionpro.customerController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.customerService.CustomerEditProfileService;
import com.aurionpro.customerService.CustomerTransactionService;
import com.aurionpro.entity.Customer;
import com.aurionpro.entity.Transaction;
import com.aurionpro.service.dbService;

@WebServlet("/CustomerEditProfileController")
public class CustomerEditProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CustomerEditProfileService ceditProfileService;
    private dbService dbservice;

    public CustomerEditProfileController() {
        dbservice = new dbService();  // Ensure this is initialized
        ceditProfileService = new CustomerEditProfileService(dbservice);  // Now, use dbservice to create service object
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String CurrentEmail = request.getParameter("Currentemail");
        String NewEmail = request.getParameter("Newemail");
        String NewPassword = request.getParameter("Newpassword");

        // Check if parameters are null or empty
        if (CurrentEmail == null || NewEmail == null || NewPassword == null) {
            response.sendRedirect("error.jsp");  // You can redirect to an error page
            return;
        }

        boolean updateSuccessful = ceditProfileService.updateCustomerDetails(CurrentEmail, NewEmail, NewPassword);

        if (updateSuccessful) {
        	 request.setAttribute("message", "Profile updated successfully!");  // Redirect to a success page
        } else {
            response.sendRedirect("error.jsp");  // Redirect to an error page if update fails
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
