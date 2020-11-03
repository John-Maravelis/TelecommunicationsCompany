package mainProject.firstExercise;

import java.util.Scanner;

public class Seller extends Users {


    public Seller() {		
	}

    public void menuOptions() {
    	Scanner scan = new Scanner(System.in);
    	Users users = new Users();
    	
    	String userInput;
    	
    	while(true) {
	        System.out.println("Πα�?ακαλώ επιλέξτε μια από τις πα�?ακάτω επιλογές: ");
	        System.out.println("�?έος πελάτης: 1");
	        System.out.println("Λογα�?ισμός πελάτη: 2");
	        System.out.println("Π�?όγ�?αμμα πελάτη: 3");
	        System.out.println("Αποσ�?νδεση: 4");
	       	userInput = scan.nextLine();
	       	scan.close();
        	switch(userInput) {
        	case "1":
        		String id = "";
        		users.register(id);
        	case "2": 
        		clientBill();
        	case "3": 
        		clientPlan();
        	case "4": 
        		users.logout();
        	default:
        		System.out.println("Πα�?ακαλώ πληκτ�?ολογείστε σωστά.");
        	}
    	}
    }
	
	private static void clientBill(){

    }

	private static void clientPlan(){

    }


}
