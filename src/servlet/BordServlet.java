package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Bord;
import bean.BordRequest;
import service.BordLogic;

@WebServlet("/BordServlet")
public class BordServlet extends HttpServlet{

	/**
	 * 初期表示画面を表示します
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BordRequest bordRequest = new BordRequest();
		BordLogic bo = new BordLogic();
		/* 無条件で検索します */
		List<Bord>resultList = bo.search(bordRequest);
		request.setAttribute("resultList",resultList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bord.jsp");
		dispatcher.forward(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		String name = (String)session.getAttribute("name");
		String comment = request.getParameter("comment");
		Bord bord = new Bord(userId,name,comment,null);
		BordLogic bo = new BordLogic();
		boolean result = bo.executeData(bord);

		if(result) {
			BordRequest bordRequest = new BordRequest();
			BordLogic ba = new BordLogic();
			List<Bord>resultList = ba.search(bordRequest);
			request.setAttribute("resultList",resultList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bord.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}
}
