package mainProject.firstExercise;

import java.util.Scanner;


public class Users {
	
	static Users users = new Users();
	static Client clients = new Client();
	static Seller sellers = new Seller();
	static Admin admins = new Admin();
	
	private String username;
    private String password;
    private String name;
    private String surname;
    private String client;
    private String seller;
    private String admin;
    private static int userCounter = 0;
    private static final String AFM="" ;
    
        
	public Users () {
		
	}
    public Users(String AFM) {
    }
	 
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	
        String signIn = "Σ�?νδεση";
        String signUp = "Εγγ�?αφή";
        String userInput;
        String id="";
        
       System.out.println("Καλωσή�?θατε!");

       while (true) {
           System.out.println("Για σ�?νδεση στο λογα�?ιασμό σας πατήστε: Σ�?νδεση");
           System.out.println("Για δημιου�?γία νέου λογα�?ισμο�? πατήστε: Εγγ�?αφή");
           userInput = scan.nextLine();

           if (userInput.equals(signIn)) {
        	   getId(id);
              users.login(id);
               break;
           }else {
               if (userInput.equals(signUp)) {               	
            	getId(id);
            	if(id.equals("Πελάτης")) {
            		clients.Users(AFM);
            		users.register(id);
            	}
                break;
               }else {
                   System.out.println("Λάθος εισαγωγή, πα�?ακαλώ πληκτ�?ολογείστε σωστά.");
                   System.out.println();
               }
           }
       }
       scan.close();
    
    }
    
	//getters and setters for user's username
    public String getUsername() {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Πα�?ακαλώ εισάγετε το username: "); 
    	
    	String tempUsername = scan.nextLine();
        return tempUsername;
    }
    public void setUsername(String username) {
    	this.username = username;
    }

    //getters and setters for user's password
    public String getPassword() {
    	Scanner scan = new Scanner(System.in);	
    	System.out.println("Πα�?ακαλώ εισάγετε το password: ");
        password = scan.nextLine();
        scan.close();
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //getters and setters for user's name
    public String getName() {
    	Scanner scan = new Scanner(System.in);    	
    	System.out.println("Πα�?ακαλώ εισάγετε το όνομά σας: ");
        name = scan.nextLine();
        scan.close();
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //getters and setters for user's surname
    public String getSurname() {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Πα�?ακαλώ εισάγετε το επίθετό σας: ");
        surname = scan.nextLine();
        scan.close();
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    //getters and setters for Client
    public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client = client;
    }

    //getters and setters for Seller
    public String getSeller() {
        return seller;
    }
    public void setSeller(String seller) {
        this.seller = seller;
    }

    //getters and setters for Admin
    public String getAdmin() {
        return admin;
    }
    public void setAdmin(String admin) {
        this.admin = admin;
    }

        public static String getId(String id) {
    	Scanner scan = new Scanner(System.in);
    	
    	while(true) {
    		System.out.println("Πα�?ακαλώ εισάγετε την ιδιότητά σας(Πελάτης, Πωλητής ή Διαχει�?ιστής): ");
    		id = scan.nextLine();
    		
	    	if(id.equals("Πελάτης")) {	    	    		
	    		break;
	    	}else if(id.equals("Πωλητής")) {
	    		break;
	    	}else if(id.equals("Διαχει�?ιστής")) {	    	
	    		break;
	    	}else {
	    		System.out.println("Λάθος εισαγωγή, πα�?ακαλώ πληκτ�?ολογείστε σωστά.");
	    		System.out.println();
	    	}
    	}
    	return id;
    }
        
    public void register(String id){
        userCounter++;
        if(id.equals("Πελάτης")) {	    	    		
    		clients.Users(AFM);
    	}        
        setUsername(getUsername());      
        setPassword(getPassword());      
        setName(getName());    
        setSurname( getSurname());
        System.out.println("Έχετε εγγ�?αφεί επιτυχώς!");
    }

    public void login(String id){
    	
    	getUsername();
        getPassword();
        System.out.println("Επιτυχής σ�?νδεση!");
        System.out.println(id);
        if(id.equals("Πελάτης")) {	    	    		
    		clients.menuOptions();
    	}else if(id.equals("Πωλητής")) {
    		sellers.menuOptions();
    	}else if(id.equals("Διαχει�?ιστής")) {	    	
    		admins.menuOptions();
    	}       
    }
    
    public void logout(){
        System.out.println("Έχετε αποσυνδεθεί.");
        System.exit(0);
    }
      
}
