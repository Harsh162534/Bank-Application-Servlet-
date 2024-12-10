package com.aurionpro.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.entity.Customer;

public class AdminViewCustomerService {
    
    private dbService dbservice;
    
    public AdminViewCustomerService(dbService dbservice) {
        this.dbservice = dbservice;
    }
    
    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = dbservice.connect();
        
       
        String sql = "SELECT *FROM customers";  // Modify the table and column names as needed
        
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            Customer customer = new Customer(
                resultSet.getString("fname"),
                resultSet.getString("lname"),
                resultSet.getString("email"),
                resultSet.getString("password")
            );
            
            customerList.add(customer);
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        
        return customerList;
    }
}
