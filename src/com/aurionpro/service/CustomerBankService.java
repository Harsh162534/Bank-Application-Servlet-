package com.aurionpro.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.aurionpro.entity.Customer;

public class CustomerBankService {

    private PreparedStatement pstatement = null;
    private Connection connection = null;
    
    
    private dbService dbservice;

    public CustomerBankService( dbService dbservice) {
        super();
       
        this.dbservice = dbservice;
    }

    public void addCustomer(String Cemail, String customerAccountNumber, String AccountType ) {
        try {
            connection = dbservice.connect();
           
            String sql = "INSERT INTO bankaccounts (email, accountnumber, accounttype) VALUES (?, ?, ?)";

            pstatement = connection.prepareStatement(sql);
            
            pstatement.setString(1, Cemail);
            pstatement.setString(2, customerAccountNumber); 
            pstatement.setString(3, AccountType);  

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