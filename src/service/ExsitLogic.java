package service;

import bean.Exsit;
import dao.ExsitDAO;

/**
 * アカウントが既に存在するかをチェックするDAOをインスタンス化するBissinesLogic
 * @author miyauchishou
 *
 */
public class ExsitLogic {
	/* boolean型の戻り値でアカウントの存在を判別 */
	public boolean execute(Exsit exsit) {
		ExsitDAO dao = new ExsitDAO();
		exsit = dao.findByExsit(exsit);
		if(exsit !=null) {
			return true;
		}
		return false;
	}
}
