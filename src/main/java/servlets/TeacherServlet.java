package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Database;
import model.TeacherDB;
import model.User;

public class TeacherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private User user;

	private ArrayList<String> dates;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		user = (User) session.getAttribute("user");

		dates = Database.inportDates(user.getId());

		if (user.getRole() == 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student.jsp");
			dispatcher.forward(request, response);
		} else {

			TeacherDB TDB = new TeacherDB(user.getId(), 0, dates);

			request.setAttribute("tdb", TDB);
			request.setAttribute("name", "sdfsd");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/teacher.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		TeacherDB TDB = new TeacherDB();

		if (request.getParameter("group") != null) {
			TDB = new TeacherDB(user.getId(), Integer.parseInt(request.getParameter("group")), dates);
			request.setAttribute("tdb", TDB);
		}

		/*
		 * if (session.getAttribute("user") != null) { user = (User)
		 * session.getAttribute("user"); }
		 */

		String up = request.getParameter("currValue");
		String mark = request.getParameter("newMark");
		String up1 = request.getParameter("currValue1");
		String mark1 = request.getParameter("newMark1");
		String id = user.getId();

		//TeacherDB TDB = new TeacherDB(id, 0, dates);

		if (up != null)
			TDB.update(up, mark);
		else
			TDB.update(up1, mark1);

		request.setAttribute("tdb", TDB);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/teacher.jsp");
		rd.forward(request, response);

	}
}