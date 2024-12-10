package com.aurionpro.customerService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aurionpro.entity.Admin;
import com.aurionpro.entity.Customer;
import com.aurionpro.service.dbService;

public class CustomerLoginService {

    private dbService dbservice;

    public CustomerLoginService(dbService dbservice) {
        this.dbservice = dbservice;
       
    }

    public Customer getCustomerByUsername(String username) {
        Connection connection = dbservice.connect();
        Customer customer = null;

        try {
        	String query = "SELECT * FROM customers WHERE email = ?";
        	PreparedStatement pstatement = connection.prepareStatement(query);
        	pstatement.setString(1, username);  // Set the username (email) parameter
        	ResultSet rs = pstatement.executeQuery();

        	if (rs.next()) {
        	    // Retrieve the customer's details from the result set
        	    String email = rs.getString("email");  // Assuming the column name is 'email' in the DB
        	    String password = rs.getString("password");  // Assuming the column name is 'password' in the DB
        	    String fname = rs.getString("fname");  // Assuming the column name is 'fname' in the DB
        	    String lname = rs.getString("lname");  // Assuming the column name is 'lname' in the DB
        	    
        	    // Create a Customer object with the retrieved data
        	    customer = new Customer(fname, lname, email, password);
        	}


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    }

