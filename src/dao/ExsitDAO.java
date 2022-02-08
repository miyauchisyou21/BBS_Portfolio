package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Exsit;

public class ExsitDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/sukkiriShop";
	private final String DB_USER  = "root";
	private final String DB_PASS  = "Rzmt83dk@";



	public Exsit findByExsit(Exsit exsit) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT USER_ID FROM ACCOUNT WHERE USER_ID= ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, exsit.getUserId());
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				String userId = rs.getString("USER_ID");
				exsit = new Exsit(userId);
				return exsit;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}


}
