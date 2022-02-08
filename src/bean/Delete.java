package bean;

public class Delete {
	private String userId;
	private String pass;
	public Delete(String userId,String pass) {
		this.userId = userId;
		this.pass = pass;
	}
	public String getUserId() {return userId;}
	public String getPass() {return pass;}
}