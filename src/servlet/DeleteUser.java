package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Delete;
import service.DeleteLogic;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {


	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/delete.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		Delete delete  =  new Delete(userId, pass);
		DeleteLogic bo = new DeleteLogic();
		boolean result = bo.execute(delete);
		if(result==true) {
			bo.deleteExcute(delete);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deleteOK.jsp");
			dispatcher.forward(request, response);
		}else {
			int err = 1;
			request.setAttribute("error_msg",err);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/delete.jsp");
			dispatcher.forward(request, response);
		}


	}
}
