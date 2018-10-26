package model;

public class User {
	private String userName;
	private int    userId;
	private String    password;
	private int    userType;
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType){
		this.userType = userType;
	}
	
	
}
