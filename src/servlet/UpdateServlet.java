package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Update;
import service.InputError;
import service.UpdateLogic;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet{


	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<String> errs = new ArrayList<String>();
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		String inputAge = request.getParameter("age");


		HttpSession session = request.getSession();
		String userId2 =(String)session.getAttribute("userId");
		//入力値のチェック
		InputError err = new InputError();
		if(err.checkInput(userId,pass,mail,name,inputAge,errs)) {
			request.setAttribute("error_msg",errs);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
			dispatcher.forward(request, response);
			return;
		}
		int age = Integer.parseInt(request.getParameter("age"));
		Update update = new Update(userId,pass,mail,name,age,userId2);
		UpdateLogic bo = new UpdateLogic();
		Update result = bo.execute(update);
		if(result !=null) {
			request.setAttribute("userId",result.getUserId());
			request.setAttribute("name",result.getName());
			request.setAttribute("mail",result.getMail());
			request.setAttribute("age",result.getAge());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updateOK.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}

	}
}
