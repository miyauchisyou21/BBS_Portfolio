package service;

import bean.Account;
import bean.Login;
import dao.AccountDAO;

/**
 * AccountDAOをインスタンス化呼びだすBissines class
 * @author miyauchishou
 *
 */
public class LoginLogic {
	public Account execute(Login login) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(login);
		return account;
	}
}
