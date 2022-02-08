package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/* ログイン、アカウント登録,削除,更新を行うjspへ遷移するServlet */
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException{
			/* URLでファイルへアクセスを行た際表示するjspを呼び出す */
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/welcome.jsp");
			/* dispatcher変数でrequest,responseをServletへ送信 */
			dispatcher.forward(request, response);
	}

}
