package Data;

public class User {
	
	private String username;
	private String password;
	private int privilege;
	
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
