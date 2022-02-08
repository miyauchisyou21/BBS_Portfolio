package service;

import java.util.List;

import bean.Bord;
import bean.BordRequest;
import dao.BordDAO;

public class BordLogic {

	public List<Bord> search(BordRequest request ) {
		BordDAO dao = new BordDAO();
		List<Bord> bordList = dao.searchdata(request);
		return bordList;
	}


	public boolean executeData(Bord bord) {
		BordDAO dao = new BordDAO();
		int data = dao.setData(bord);

		if(data == 1) {
			return true;
		}else {
		return false;
		}
	}
//	public List<Bord> sortData(String inputType) {
//		BordDAO dao = new BordDAO();
//		List<Bord> bordList = dao.sortSql(inputType);
//		return bordList;
//
//	}
}

