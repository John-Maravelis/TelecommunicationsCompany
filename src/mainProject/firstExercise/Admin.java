package mainProject.firstExercise;

import java.util.Scanner;

public class Admin extends Users {

    
	public Admin() {	
	}
	
	 public void menuOptions() {
	    	Scanner scan = new Scanner(System.in);
	    	String userInput;
	    	
	    	while(true) {
		        System.out.println("Πα�?ακαλώ επιλέξτε μια από τις πα�?ακάτω επιλογές: ");
		        System.out.println("�?έος πωλητής: 1");
		        System.out.println("Διαγ�?αφή πωλητή: 2");
		        System.out.println("�?έος πελάτης: 3");
		        System.out.println("Διαγ�?αφή πελάτη: 4");
		        System.out.println("Δημιου�?γία νέου π�?ογ�?άμματος: 5");
		        System.out.println("Αποσ�?νδεση: 6");
		       	userInput = scan.nextLine();
		       	scan.close();
	        	switch(userInput) {
	        	case "1":
	        		newSeller();	        		
	        	case "2": 
	        		delSeller();
	        	case "3": 
	        		newClient();
	        	case "4": 
	        		delClient();
	        	case "5": 
	        		createPlan();
	        	case "6": 
	        		users.logout();
	        	default:
	        		System.out.println("Πα�?ακαλώ πληκτ�?ολογείστε σωστά.");
	        	}
	    	}
	    }
	private static void newSeller(){
        System.out.println("Nέος πωλητής");
    }
	private static void delSeller(){
        System.out.println("Διαγ�?αφή πωλητή");
    }
	private static void newClient(){
        System.out.println("�?έος πελάτης");

    }
	private static void delClient(){
        System.out.println("Διαγ�?αφή πελάτη");

    }
	private static void createPlan(){
        System.out.println("Δημιου�?γία πλάνου");

    }
}
