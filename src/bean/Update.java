package bean;

public class Update {
	private String userId;
	private String pass;
	private String mail;
	private String name;
	private int age;
	private String userId2;



	public Update(String userId,String pass,String mail,String name,int age,String userId2) {
		this.userId = userId;
		this.pass = pass;
		this.mail = mail;
		this.name = name;
		this.age = age;
		this.userId2 = userId2;

	}
	public String getUserId() {return userId;}
	public String getPass() {return pass;}
	public String getMail() {return mail;}
	public String getName() {return name;}
	public int getAge() {return age;}
	public String getUserId2() {return userId2;}



}