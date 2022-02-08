package service;

import java.util.ArrayList;

/**
 * 入力値をチェックするクラスです
 *
 * @author miyauchishou
 *
 */
public class InputError {
	/**
	 * 入力されたユーザー情報が正しいいかチェックします
	 *
	 * @param userId ユーザーID
	 * @param pass パスワード
	 * @param mail メールアドレス
	 * @param name 名前
	 * @param inputAge　年齢
	 * @param errs エラーメッセージリスト
	 * @return	エラーがあった場合true
	 */
	public boolean checkInput(String userId,String pass,String mail,String name,String inputAge,ArrayList<String> errs) {
			if(userId.equals("")||pass.equals("")||name.equals("")||inputAge.equals("")||userId.length() >9) {
				if(userId.length() >9) {
					errs.add("ユーザーIDは8文字以内で入力して下さい");
				}
				errs.add("必要項目が入力されていません");
				return true;
			}
		return false;
	}
}