package service;

import bean.Delete;
import dao.AccountDAO;
import dao.DeleteDAO;

public class DeleteLogic {
	public boolean execute(Delete delete) {
		AccountDAO dao = new AccountDAO();
		delete = dao.findByAccount(delete);
		if(delete != null) {
			return true;
		}
		return false;
	}
	public boolean deleteExcute(Delete delete) {
		DeleteDAO dao = new DeleteDAO();
		delete = dao.DeleteAccount(delete);
		return delete != null;
	}
}
