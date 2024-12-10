package com.aurionpro.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aurionpro.entity.Admin;

public class AdminService {

    private dbService dbservice;

    public AdminService(dbService dbservice) {
        this.dbservice = dbservice;
    }

    public Admin getAdminByUsername(String username) {
        Connection connection = dbservice.connect();
        Admin admin = null;

        try {
            String query = "SELECT * FROM admins WHERE username = ?";
            PreparedStatement pstatement = connection.prepareStatement(query);

            pstatement.setString(1, username);
            ResultSet rs = pstatement.executeQuery();

            if (rs.next()) {
                String adminName = rs.getString("username");
                String adminPassword = rs.getString("password");
                admin = new Admin(adminName, adminPassword);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }

    public void addAdmin(String adminName, String adminPassword) {
        Connection connection = dbservice.connect();

        try {
            String query = "INSERT INTO admins (username, password) VALUES (?, ?)";
            PreparedStatement pstatement = connection.prepareStatement(query);
            pstatement.setString(1, adminName);
            pstatement.setString(2, adminPassword);

            int rowsAffected = pstatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Admin added successfully.");
            } else {
                System.out.println("Failed to add admin.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
