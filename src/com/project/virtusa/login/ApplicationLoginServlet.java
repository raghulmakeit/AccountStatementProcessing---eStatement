package com.project.virtusa.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ApplicationLoginServlet
 */
@WebServlet("/login")
public class ApplicationLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationLoginValidate Validate;

	public void init() {
		Validate = new ApplicationLoginValidate();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ApplicationLoginUsebean loginBean = new ApplicationLoginUsebean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);

		try {
			if (ApplicationLoginValidate.validate(loginBean)) {
				HttpSession session = request.getSession();
				 session.setAttribute("username",username);
				response.sendRedirect("Dashboard.jsp");
			} else {
				//HttpSession session = request.getSession();
				//session.setAttribute("user", username);
				response.sendRedirect("ApplicationLogin.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
