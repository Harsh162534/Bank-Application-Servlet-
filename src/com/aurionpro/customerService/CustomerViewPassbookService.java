package com.aurionpro.customerService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aurionpro.entity.Transaction;
import com.aurionpro.service.dbService;

public class CustomerViewPassbookService {

    private dbService dbservice;

    public CustomerViewPassbookService(dbService dbservice) {
        this.dbservice = dbservice;
    }

    public List<Transaction> getAllTransaction(String username) throws SQLException {
        List<Transaction> transactionList = new ArrayList<>();

        // Use try-with-resources to ensure resources are closed automatically
        try (Connection connection = dbservice.connect();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Transaction"); // Corrected query
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String senderAccount = resultSet.getString("s_accountnumber");
                String receiverAccount = resultSet.getString("r_accountnumber"); // Fixed column name
                String type = resultSet.getString("transactiontype");
                int amount = resultSet.getInt("amount");
                String Username = username;
                
                
                

               String query = "SELECT t.date "
                             + "FROM Transaction t "
                             + "JOIN bankaccounts b ON t.s_accountnumber = b.accountnumber OR t.r_accountnumber = b.accountnumber "
                             + "JOIN customers c ON b.email = c.email "
                             + "WHERE c.email = ?";

                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, Username);  

               ResultSet rs = ps.executeQuery();
               java.sql.Date transactionDate = null ;

               while (rs.next()) {
            	    transactionDate = rs.getDate("date");
            	    System.out.println("Transaction Date: " + transactionDate);
            	}
                
               
                
//                String date = resultSet.getString("date"); // Fetch date

                // Create Transaction object with date
               Transaction transaction = new Transaction(senderAccount, receiverAccount, type, amount,transactionDate);
               transactionList.add(transaction);
            }
        } catch (SQLException e) {
            throw new SQLException("Error fetching transactions", e);
        }

        return transactionList;
    }
}
