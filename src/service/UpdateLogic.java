package service;

import bean.Update;
import dao.UpdateDAO;

public class UpdateLogic {
	public Update execute(Update update) {
		UpdateDAO dao = new UpdateDAO();
		 Update updateResult = dao.updateByUser(update);
		return updateResult;
	}
}
