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

import bean.Create;
import bean.Exsit;
import service.CreateLogic;
import service.ExsitLogic;
import service.InputError;

@WebServlet("/CreateUser")
public class CreateUser  extends HttpServlet{


	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create.jsp");
				dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<String> errs = new ArrayList<String>();
		InputError err = new InputError();
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");

		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		String inputAge = request.getParameter("age");
		//入力値のチェック
		if(err.checkInput(userId,pass,mail,name,inputAge,errs)) {
			request.setAttribute("error_msg",errs);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create.jsp");
			dispatcher.forward(request, response);
			return;
		}
		int age = Integer.parseInt(request.getParameter("age"));
		//既にデータがないかチェックする
		Exsit exsit = new Exsit(userId);
		ExsitLogic ba = new ExsitLogic();
		boolean resultExsit = ba.execute(exsit);
		if(resultExsit) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
			return;
		}

		Create create = new Create(userId, pass,mail,name,age);
		CreateLogic bo = new CreateLogic();
		boolean result = bo.execute(create);



		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/createOK.jsp");
			dispatcher.forward(request, response);
		}else {
			//response.sendRedirect("/WEB-INF/jsp/error.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
