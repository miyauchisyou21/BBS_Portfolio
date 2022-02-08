package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Update;
public class UpdateDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/sukkiriShop";
	private final String DB_USER  = "root";
	private final String DB_PASS  = "Rzmt83dk@";

	public Update updateByUser(Update update) {

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "UPDATE ACCOUNT SET USER_ID = ?,PASS = ?,MAIL = ?,NAME = ?,AGE= ? WHERE USER_ID= ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, update.getUserId());
			pStmt.setString(2, update.getPass());
			pStmt.setString(3, update.getMail());
			pStmt.setString(4, update.getName());
			pStmt.setInt(5, update.getAge());

			//LoginServletから既存のUserIdを取得
			pStmt.setString(6,update.getUserId2());

			int rs = pStmt.executeUpdate();
			if(rs==1) {
				return update;
			}
			return null;

		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
