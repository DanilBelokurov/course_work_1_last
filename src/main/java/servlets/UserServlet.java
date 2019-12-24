package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Student;
import model.StudentDB;
import model.User;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		if (user.getRole() == 1) {
			response.sendRedirect("teacher_cabinet");
		} else {

			request.setAttribute("user", user);
			
			ArrayList<Student> students = StudentDB.select(user.getName().replace(" ", "_") + "_" + user.getId());
	        request.setAttribute("students", students);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student.jsp");
			dispatcher.forward(request, response);			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}