package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

public class TeacherInit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static User user;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// HttpSession session = request.getSession();

		user = (User) request.getServletContext().getAttribute("user");
		// (User) session.getAttribute("user");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/teacherInit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] dates = request.getParameterValues("dates[]");

		ArrayList<String> result = new ArrayList<String>();

		for (int i = 0; i < dates.length; i++) {
			StringBuilder str = new StringBuilder();
			String[] tmp = dates[i].split("-");
			str.append(tmp[2]).append(".");
			str.append(tmp[1]).append(".");
			str.append(tmp[0]);
			result.add(str.toString());
		}

		request.getServletContext().setAttribute("dates", result);
		request.getServletContext().setAttribute("user", user);
		request.getServletContext().setAttribute("role", user.getId());

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
		dispatcher.forward(request, response);
	}
}