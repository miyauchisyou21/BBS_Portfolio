package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bord;
import bean.BordRequest;
import service.BordLogic;
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		BordRequest bordRequest = createBordRequest(request);
		BordLogic bo = new BordLogic();
		List<Bord>resultList = bo.search(bordRequest);
		request.setAttribute("resultList",resultList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bord.jsp");
		dispatcher.forward(request,response);
	}
	/**
	 * 検索条件を作成します
	 * @param request
	 * @return 検索条件
	 */
	protected BordRequest createBordRequest(HttpServletRequest request) {
		String date = request.getParameter("ts");
		String name = request.getParameter("name");
		String sort = request.getParameter("sort");
		String limit10 = request.getParameter("display");
		String inputType="";
		String limit ="";
		/* sortの条件を作成 */
//		if(sort == "sortAge") {
//			inputType = "AGE";
//		}else if(sort == "sortName") {
//			inputType= "NAME";
//		}
		if("sortNone".equals(sort)) {
			inputType = "NONE";
		}else if("sortAge".equals(sort)) {
			inputType = "AGE";
		}else if("sortName".equals(sort)) {
			inputType= "NAME";
		}
		/* 全件取得か10件取得か*/
		if("all".equals(limit10)) {
			limit = "ALL";
		}else{
			limit = "10";
		}
		BordRequest bordRequest = new BordRequest();
		bordRequest.setDate(date);
		bordRequest.setName(name);
		bordRequest.setInputType(inputType);
		bordRequest.setLimit(limit);
		return bordRequest;
	}

}
