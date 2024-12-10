package com.aurionpro.customerService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aurionpro.entity.Customer;
import com.aurionpro.service.dbService;

public class CustomerEditProfileService {

    private dbService dbservice;

    public CustomerEditProfileService(dbService dbservice) {
        this.dbservice = dbservice;
    }


    // Method to update customer details
    public boolean updateCustomerDetails(String username, String newEmail, String newPassword) {
        boolean updateSuccessful = false;
        Connection connection = dbservice.connect();

        if (connection == null) {
            System.out.println("Error: Database connection is null.");
            return false;  // Return false if connection fails
        }

        try {
            String query = "UPDATE customers SET email = ?, password = ? WHERE email = ?";
            PreparedStatement pstatement = connection.prepareStatement(query);

            pstatement.setString(1, newEmail);
            pstatement.setString(2, newPassword);
            pstatement.setString(3, username);

            int rowsUpdated = pstatement.executeUpdate();

            if (rowsUpdated > 0) {
                updateSuccessful = true;  // Mark as successful if rows are updated
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();  // Ensure connection is closed
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return updateSuccessful;
    }
}