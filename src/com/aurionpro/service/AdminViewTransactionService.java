package com.aurionpro.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.entity.Transaction;

public class AdminViewTransactionService {
    
    private dbService dbservice;
    
    public AdminViewTransactionService(dbService dbservice) {
        this.dbservice = dbservice;
    }
    
    public List<Transaction> getAllTransaction() throws SQLException {
        List<Transaction> transactionList = new ArrayList<>();
        Connection connection = dbservice.connect();
        
       
        String sql = "SELECT * FROM Transaction"; 
        
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        
        
        while (resultSet.next()) {
           
            Transaction transaction = new Transaction(
                resultSet.getString("s_accountnumber"),
                resultSet.getString("r_accountnumber"),
                resultSet.getString("transactiontype"),
                resultSet.getInt("amount"),
                resultSet.getDate("date") // Assuming date is a Date type field in your DB
            );
            
            transactionList.add(transaction);
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        
        return transactionList;
    }
}
