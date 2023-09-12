package Pirex;

public class User {
	
	private final String username;
	private final String password;
	private final int privilege;
	
	public User(String username, String password, int privilege)
	{
		this.username = username;
		this.password = password;
		this.privilege = privilege;
	}
	
	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public int getPrivilege() {
		return privilege;
	}
}
