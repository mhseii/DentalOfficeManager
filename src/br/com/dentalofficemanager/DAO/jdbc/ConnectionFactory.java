package br.com.dentalofficemanager.DAO.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try{
			// reflection
			return DriverManager.getConnection("jdbc:mysql://localhost/DentalOfficeManager", "root", "admin123");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
