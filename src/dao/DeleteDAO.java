package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Delete;
public class DeleteDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/sukkiriShop";
	private final String DB_USER  = "root";
	private final String DB_PASS  = "Rzmt83dk@";


	public Delete DeleteAccount(Delete delete) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "DELETE FROM ACCOUNT WHERE USER_ID= ? AND PASS=? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, delete.getUserId());
			pStmt.setString(2, delete.getPass());
			pStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
