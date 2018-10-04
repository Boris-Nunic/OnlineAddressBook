package org.bildit.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static ConnectionManager instance = null;
	private Connection connection = null;
	
	private static final String USERNAME = 	"root";
	private static final String PASSWORD = "root";
	private static final String CONN_STRING = "jdbc:mysql://localhost/online_address_book?useSSL=false&serverTimezone=UTC";

	private ConnectionManager() {
		
	}
	
	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}
	
	private boolean openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		}
		
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Connection getConnection() {
		if (connection == null) {
			if(openConnection()) {
				System.out.println("Connection is opened");
				return connection;
			}
			return null;
		}
		return connection;
	}
	
	public void close() {
		System.out.println("Connection is closing");
		try {
			connection.close();
			connection = null;
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
