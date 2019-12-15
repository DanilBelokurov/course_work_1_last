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
import model.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
		dispatcher.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		 * RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("/WEB-INF/view/login.jsp");
		 * dispatcher.forward(request, response);
		 */

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String findQuery = "SELECT * FROM auth WHERE login = \"" + login + "\" AND password = \"" + password + "\"";

		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/course", "root", "root");
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(findQuery);

			if (!resultSet.next()) {
				//alert
				request.setAttribute("userName", "Username or password is wrong.");
				return;
			} else {
				User user = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getString(5));
				
				if(user.getRole() == 0)
					response.sendRedirect("lk");
				else
					response.sendRedirect("teacher_cabinet");
				
				connection.close();
				statement.close();
				
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

	}
}