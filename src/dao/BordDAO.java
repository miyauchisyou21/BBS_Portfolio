package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.Bord;
import bean.BordRequest;

public class BordDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/sukkiriShop";
	private final String DB_USER = "root";
	private final String DB_PASS = "Rzmt83dk@";

	private final String HALF_WHITE =" ";
	public List<Bord> searchdata(BordRequest request) {
		List<Bord> list = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = getSql(request);
			PreparedStatement pStmt = conn.prepareStatement(sql);
			int i = 1;
			if (request.getName() != "" && request.getName() != null) {
				pStmt.setString(i, request.getName());
				i++;
			}
			if (request.getDate() != "" && request.getDate() != null) {
				pStmt.setString(i, request.getDate());
			}
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				String userId = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				String comment = rs.getString("COMMENT");
				Timestamp ts = rs.getTimestamp("TS");
				Bord getBord = new Bord(userId, name,age,comment, ts);
				list.add(getBord);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int setData(Bord bord) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO BORD (ID,NAME,COMMENT,TS) VALUES(?, ?, ?, NOW())";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, bord.getUserId());
			pStmt.setString(2, bord.getName());
			pStmt.setString(3, bord.getComment());
			int rs = pStmt.executeUpdate();
			return rs;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * 投稿内容を取得するsqlを返します
	 *
	 * @param bord 投稿内容
	 * @return
	 */
	public String getSql(BordRequest request) {
		String sql = "SELECT ID,BORD.NAME,ACCOUNT.AGE,COMMENT,TS FROM BORD JOIN ACCOUNT ON USER_ID = ID";
		StringBuilder sb = new StringBuilder(sql);
		if(request.getName() != null || request.getDate() != null) {
			if(request.getName() !=""|| request.getDate()!="") {
				sb.append(HALF_WHITE+"WHERE");
			}
		/* 日付、名前で絞込み */
			if ((request.getName() != "" && request.getName() != null) && (request.getDate() != "" && request.getDate() != null)) {
				sb.append(HALF_WHITE+"BORD.NAME = ? AND CAST(TS AS DATE)= ?");
			} else if (request.getName() != "" && request.getName() != null) {
				sb.append(HALF_WHITE+"BORD.NAME = ? ");
			} else if (request.getDate() != "" && request.getDate() != null) {
				sb.append(HALF_WHITE+"CAST(TS AS DATE)= ?");
			}
		}
		/* 最初の読み込み時とソートなしを選択した時*/
		sb.append(HALF_WHITE+"ORDER BY");
		if(request.getInputType()=="NONE"||request.getInputType()==null) {
			sb.append(HALF_WHITE+"TS");
			sb.append(HALF_WHITE+"DESC");
		}
		if(request.getInputType() !=""&&request.getInputType()!=null) {
			if(request.getInputType()=="AGE") {
				sb.append(HALF_WHITE+"AGE");
			}else if(request.getInputType()=="NAME"){
				sb.append(HALF_WHITE+"NAME");
			}
		}
		if(request.getLimit()!="ALL") {
			sb.append(HALF_WHITE+"LIMIT");
			sb.append(HALF_WHITE+"10");
		}
		return sb.toString();
	}

//	public List<Bord> sortSql(String inputType) {
//		List<Bord> list = new ArrayList<>();
//		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
//			String sql ="SELECT ID,BORD.NAME,ACCOUNT.AGE,COMMENT,TS FROM BORD JOIN ACCOUNT ON USER_ID = ID ORDER BY";
//			if(inputType=="NAME") {
//				sql +=HALF_WHITE+"NAME";
//			}else if(inputType=="AGE") {
//				sql +=HALF_WHITE+"AGE";
//			}
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//			ResultSet rs = pStmt.executeQuery();
//			while (rs.next()) {
//				String userId = rs.getString("ID");
//				String name = rs.getString("NAME");
//				int age = rs.getInt("AGE");
//				String comment = rs.getString("COMMENT");
//				Timestamp ts = rs.getTimestamp("TS");
//				Bord getBord = new Bord(userId, name,age,comment, ts);
//				list.add(getBord);
//			}
//			rs.close();
//			return list;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
}
