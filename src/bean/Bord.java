package bean;

import java.sql.Timestamp;

public class Bord {
	private String userId;
	private String name;
	private Timestamp ts;
	private String comment;
	private int age;
	private String date;

	public Bord(String userId, String name, String comment, Timestamp ts) {
		this.userId = userId;
		this.name = name;
		this.ts = ts;
		this.comment = comment;
	}
	public Bord(String userId, String name,int age, String comment, Timestamp ts) {
		this.userId = userId;
		this.name = name;
		this.age =age;
		this.ts = ts;
		this.comment = comment;
	}
	public Bord() {

	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public Timestamp getTs() {
		return ts;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
