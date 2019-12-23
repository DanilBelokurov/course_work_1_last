package model;

import java.sql.*;
import java.util.ArrayList;

public class StudentDB {

	private static String url = "jdbc:mysql://localhost:3306/example";
	private static String username = "root";
	private static String password = "root";

	
	public static ArrayList<Student> select(String tableName) {
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<String> marks = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(url, username, password)) {

				Statement statement = conn.createStatement();
				{
					ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
					while (resultSet.next()) {
						String subject = resultSet.getString(1);
						Student st = new Student(subject);
						for(int i = 2; i < 12; i++) {
							st.setMark(resultSet.getString(i));
							System.out.println(resultSet.getString(i));
						}
						
						students.add(st);
					}
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return students;
	}

	/*public static int insert(Student student) {

		try {
			Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(url, username, password)) {

				String sql = "INSERT INTO student (subject, mark) Values (?, ?)";
				try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
					preparedStatement.setString(1, student.getSubject());
					preparedStatement.setString(2, student.getMark());

					return preparedStatement.executeUpdate();
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return 0;
	}

	public static int update(Student student) {
		try {
			Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(url, username, password)) {

				String sql = "UPDATE student SET mark = ? WHERE subject = ?";
				try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
					preparedStatement.setInt(1, student.getMark());
					preparedStatement.setString(2, student.getSubject());

					return preparedStatement.executeUpdate();
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return 0;
	}*/
}