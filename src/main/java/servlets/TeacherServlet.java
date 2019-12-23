package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TeacherDB;
import model.User;

public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User user;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		user = (User) session.getAttribute("user");

		if (user.getRole() == 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student.jsp");
			dispatcher.forward(request, response);
		} else {

			TeacherDB TDB = new TeacherDB(user.getId(), 0);

			request.setAttribute("tdb", TDB);
			request.getServletContext().setAttribute("name", "sdfsd");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/teacher.jsp");
			dispatcher.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("group") != null) {
			TeacherDB TDB = new TeacherDB(user.getId(), Integer.parseInt(request.getParameter("group")));
			request.setAttribute("tdb", TDB);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/teacher.jsp");
		dispatcher.forward(request, response);
	}
}