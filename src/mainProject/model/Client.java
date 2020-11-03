package mainProject.model;

/**
 * This class is responsible for setting the client's information.
 * @author John Maravelis
 */
public class Client {
	
	private String clientID;
	private String firstName;
	private String surname;
	private String phoneNumber;
	private String afm;
	private String username;
	private String password;
	private String sellerUsername;
	private String zip;
	
	public Client() { 
    }
	
    public Client(String username, String password) {
    	setUsername(username);
    	setPassword(password);
	}

    
	public Client( String clientID, String username, String password, String firstName, String surname, 
			String phoneNumber, String afm, String zip, String sellerUsername){
		
		setClientID(clientID);
		setFirstName(firstName);
		setSurname(surname);
		setPhoneNumber(phoneNumber);
		setAfm(afm);
		setUsername(username);
		setPassword(password);
		setSellerUsername(sellerUsername);
		setZip(zip);
	}
	
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
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
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getAfm() {
		return afm;
	}
	public void setAfm(String afm) {
		this.afm = afm;
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
	
	public String getSellerUsername() {
		return sellerUsername;
	}
	public void setSellerUsername(String sellerUsername) {
		this.sellerUsername = sellerUsername;
	}
	
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
}
