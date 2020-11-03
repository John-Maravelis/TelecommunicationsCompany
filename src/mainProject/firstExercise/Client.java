package mainProject.firstExercise;

import java.util.Scanner;

public class Client extends Users {
    
    public static String phoneNumber;

    public Client(){    	
	}
    
    
    public String Users(String AFM) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Πα�?ακαλώ εισάγετε τον ΑΦΜ σας.");
		AFM = scan.nextLine();
		System.out.println("Πα�?ακαλώ εισάγετε τον α�?ιθμό τηλεφώνου σας.");
		phoneNumber = scan.nextLine();
		scan.close();
		return AFM;
    }

    public void menuOptions() {
    	Scanner scan = new Scanner(System.in);
    	String userInput;
    	
    	while(true) {
	        System.out.println("Πα�?ακαλώ επιλέξτε μια από τις πα�?ακάτω επιλογές: ");
	        System.out.println("Π�?οβολή λογα�?ιασμο�?: 1");
	        System.out.println("Π�?οβολή ιστο�?ικο�? κλήσεων: 2");
	        System.out.println("Πλη�?ωμή λογα�?ιασμο�? λογα�?ιασμο�?: 3");
	        System.out.println("Αποσ�?νδεση: 4");
	       	userInput = scan.nextLine();
	       	scan.close();
        	switch(userInput) {
        	case "1":
        		showAccount();
        	case "2": 
        		showCallHistory();
        	case "3": 
        		payAccount();
        	case "4": 
        		users.logout();	
        	default:
        		System.out.println("Πα�?ακαλώ πληκτ�?ολογείστε σωστά.");
        	}
    	}
    }
    
    private static void showAccount(){
        System.out.println("Αυτός είναι ο λογα�?ιασμός σας.");
    }

    private static void showCallHistory(){
        System.out.println("Αυτό είναι το ιστο�?ικό κλήσεων σας.");
    }

    private static void payAccount(){
        System.out.println("Ο μηνιαίος λογα�?ιασμός είναι: ");
    }
}
