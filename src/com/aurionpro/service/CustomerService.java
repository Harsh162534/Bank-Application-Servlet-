package com.aurionpro.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.aurionpro.entity.Customer;

public class CustomerService {

    private PreparedStatement pstatement = null;
    private Connection connection = null;
    
    
    private dbService dbservice;

    public CustomerService( dbService dbservice) {
        super();
       
        this.dbservice = dbservice;
    }

   
    public void addCustomer(String fname, String lname, String email, String password) {
        try {
           
            connection = dbservice.connect();

           
            String sql = "INSERT INTO customers (fname, lname, email, password) VALUES (?, ?, ?, ?)";

           
            pstatement = connection.prepareStatement(sql);

            pstatement.setString(1, fname);
            pstatement.setString(2, lname);
            pstatement.setString(3, email);
            pstatement.setString(4, password);

            
            int rowsAffected = pstatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Customer added successfully.");
            } else {
                System.out.println("Failed to add customer.");
            }

        } catch (SQLException e) {
           
            e.printStackTrace();
        } finally {
            try {
                if (pstatement != null) pstatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
