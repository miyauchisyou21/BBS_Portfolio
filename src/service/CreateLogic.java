package service;

import bean.Create;
import dao.CreateDAO;

public class CreateLogic {
	public boolean execute(Create create) {
		CreateDAO dao = new CreateDAO();
		int account = dao.createByUser(create);

		if(account == 1) {
			return true;
		}else {
			return false;
		}
	}

}
