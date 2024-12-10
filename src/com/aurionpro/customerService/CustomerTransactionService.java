package com.aurionpro.customerService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.aurionpro.entity.Customer;
import com.aurionpro.service.dbService;

public class CustomerTransactionService {

    private PreparedStatement pstatement = null;
    private Connection connection = null;
    
    
    private dbService dbservice;

    public CustomerTransactionService( dbService dbservice) {
        super();
       
        this.dbservice = dbservice;
    }

   
    public void addTransaction(String senderAccount, String receiverAccount,String transactionType, int amount ) {
        try {
            connection = dbservice.connect();
           
            String sql = "INSERT INTO Transaction (s_accountnumber, r_accountnumber, transactiontype, amount ) VALUES (?,?, ?, ?)";

            pstatement = connection.prepareStatement(sql);

            pstatement.setString(1, senderAccount);
            pstatement.setString(2, receiverAccount); 
            pstatement.setString(3, transactionType); 
            pstatement.setLong(4, amount);  

            int rowsAffected = pstatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Transaction added successfully.");
            } else {
                System.out.println("Failed to add Transaction.");
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