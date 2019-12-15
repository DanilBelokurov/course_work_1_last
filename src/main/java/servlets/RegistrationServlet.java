
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Database;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/signup.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String name = request.getParameter("name");
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			String id = request.getParameter("groups");
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/course", "root", "root");
			Statement statement = connection.createStatement();
			
			String findQuery = "SELECT * FROM auth WHERE login = \"" + login + "\" AND password = \"" + password + "\"" ;

			ResultSet resultSet = statement.executeQuery(findQuery);
			if (!resultSet.next()) {
				String sizeQuery = "SELECT COUNT( * ) FROM  auth";
				resultSet = statement.executeQuery(sizeQuery);
				resultSet.next();
				int size = resultSet.getInt(1);
				String insertQuery = "INSERT INTO course.auth (name, login, password, type, id) VALUES ('" + name
						+ "', '" + login + "', '" + password + "', '" + role + "', '" + id + "')";
				
				statement.executeUpdate(insertQuery);
				response.sendRedirect("course_1/login");
			} else {
				//alert
				request.setAttribute("userName", "Sorry, user with the same name already exists.");
			}
			statement.close();
			connection.close();

			//doGet(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		//doGet(request, response);
	}
}