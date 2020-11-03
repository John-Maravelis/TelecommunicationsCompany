package mainProject.model;

/**
 * This class is responsible for setting the admins's information.
 * @author John Maravelis
 */
public class Admin {
	private String username;
    private String password;
    
    public Admin() {
    }
    
    public Admin(String username, String password) {
    	setUsername(username);
    	setPassword(password);
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
}
