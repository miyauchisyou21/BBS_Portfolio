package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import bean.Login;
import service.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{


	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");


		Login login = new Login(userId, pass);
		LoginLogic bo = new LoginLogic();
		Account result = bo.execute(login);


		if(result !=null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("name", result.getName());
			request.setAttribute("userId",result.getUserId());
			request.setAttribute("name",result.getName());
			request.setAttribute("mail",result.getMail());
			request.setAttribute("age",result.getAge());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
			dispatcher.forward(request, response);
		}else {
			int err=1;
			request.setAttribute("error_msg",err);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
