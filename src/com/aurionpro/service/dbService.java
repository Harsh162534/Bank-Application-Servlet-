package com.aurionpro.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class dbService {
	
	private Connection connection=null;

	public Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");

   System.out.println("Connection Successful");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connection;
	}

}
