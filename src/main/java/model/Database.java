
package model;

import java.sql.*;

public class Database {

	@SuppressWarnings("deprecation")
	public static User isLogin(String login, String password) {

		try {
			String findQuery = "SELECT * FROM auth WHERE login = \"" + login + "\" AND password = \"" + password + "\"";

			String subject = new String();

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/course", "root", "root");
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(findQuery);

			if (!resultSet.next()) {
				return null;
			} else {

				if (resultSet.getInt(4) == 1) {
					int idx = resultSet.getString(5).indexOf("_");
					subject = resultSet.getString(5).substring(0, idx);
				} else
					subject = null;

				User user = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), subject,
						resultSet.getInt(4), resultSet.getString(5));

				connection.close();
				statement.close();

				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	public static boolean export(User user) {

		try {
			/* Export to DB */
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/course", "root", "root");
			Statement statement = connection.createStatement();

			String findQuery = "SELECT * FROM auth WHERE login = \"" + user.getLogin() + "\" AND password = \""
					+ user.getPassword() + "\"";

			ResultSet resultSet = statement.executeQuery(findQuery);

			if (!resultSet.next()) {

				String sizeQuery = "SELECT COUNT( * ) FROM  auth";
				resultSet = statement.executeQuery(sizeQuery);
				resultSet.next();
				
				String insertQuery = "INSERT INTO course.auth (name, login, password, type, id) VALUES ('"
						+ user.getName() + "', '" + user.getLogin() + "', '" + user.getPassword() + "', '"
						+ user.getRole() + "', '" + user.getId() + "')";

				statement.executeUpdate(insertQuery);
				

				if (user.getRole() == 0) {
					
					String databaseChange = " use example;";
					statement.execute(databaseChange);
					
					String userName = user.getName().replace(" ", "_");

					String query = "CREATE TABLE " + userName + "_" + user.getId()
							+ " (subject varchar(100) NOT NULL, mark varchar(12) NOT NULL,mark1 varchar(12), mark2 varchar(12), mark3 varchar(12), mark4 varchar(12), mark5 varchar(12), mark6 varchar(12),mark7 varchar(12), mark8 varchar(12), mark9 varchar(12));";
				
					statement.execute(query);
				
				}

				statement.close();
				connection.close();

				return true;

			} else {

				statement.close();
				connection.close();
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}