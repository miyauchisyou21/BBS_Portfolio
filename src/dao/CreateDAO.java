package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Create;

public class CreateDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/sukkiriShop";
	private final String DB_USER  = "root";
	private final String DB_PASS  = "Rzmt83dk@";

	public int createByUser(Create create) {



		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "INSERT INTO ACCOUNT (USER_ID,PASS,MAIL,NAME,AGE) VALUES(?, ?, ?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, create.getUserId());
			pStmt.setString(2, create.getPass());
			pStmt.setString(3, create.getMail());
			pStmt.setString(4, create.getName());
			pStmt.setInt(5,create.getAge());

			int rs = pStmt.executeUpdate();
			return rs;



		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
