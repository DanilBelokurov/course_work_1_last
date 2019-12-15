
package model;

import java.sql.*;


public class Database {

	private static final String url = "jdbc:mysql://localhost/course?serverTimezone=Europe/Moscow&useSSL=false";
	private static final String usernameDB = "root";
	private static final String passwordDB = "root";
		
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, usernameDB, passwordDB);
	}
}