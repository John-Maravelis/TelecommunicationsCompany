package mainProject.model;

/**
 * This class is responsible for setting the seller's information.
 * @author John Maravelis
 */
public class Seller {

	private String sellerID;
	private String username;
	private String password;
	private String firstName;
	private String surname;
	private String adminUsername;

	public Seller() {
	}

	public Seller(String username, String password) {
		setUsername(username);
		setPassword(password);
	}
	
	public Seller(String sellerID, String username, String password, String firstName, String surname, String adminUsername) {
		
		setSellerID(sellerID);
		setFirstName(firstName);
		setSurname(surname);
		setUsername(username);
		setPassword(password);
		setAdminUsername(adminUsername);
	}
	
	
	public String getSellerID() {
		return sellerID;
	}
	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
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
