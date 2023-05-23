package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {
	private static String HOST = "localhost";
	private static String PASSWORD = "projects";
	private static String SCHEMA  = "projects";
	private static String USER = "projects";
	private static int PORT = 3306;
	
	public static Connection getConnection() {
		String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER, PASSWORD);
System.out.println("Connecting with url=" + url);
		
		try {
			Connection conn = DriverManager.getConnection(url);
			System.out.println("Connection established!");
			return conn;
		} catch (SQLException e) {
			System.out.println("Connection failed!");
			throw new DbException("Unable to get connection at /" + url);
		}
	}
}
