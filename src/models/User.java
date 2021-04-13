package models;

public class User {
	
	int uid;
	String username;
	String password;
	int enabled;
	
	public User(int uid, String username, String password, int enabled) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	
}
