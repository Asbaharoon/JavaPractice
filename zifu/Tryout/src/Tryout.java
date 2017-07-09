import java.util.Scanner;
public class Tryout {
	public static void main(String[]args){
		System.out.println("News flash: People have to retire at the age of 65.");
		System.out.println("So I am doing an interview on this person over here.");
		System.out.println("What's your name?, person over there?\r\n");
		System.out.println("Please choose what to input\n");
		System.out.println("1. Name\n");
		System.out.println("2. Math score\n");
		System.out.println("3. English score\n");
		int h = 1;
		Scanner scan = new Scanner(System.in);
		int Choice = scan.nextInt();	
		
		if( Choice < 1 || Choice > 3000000); {
			System.out.println("Wrong choice, person!");
			System.out.println("Do you have a name?");
			System.out.println("Oh. You don't.");
		}
		String name = scan.nextLine();
	    System.out.println("Hi, " + name + "!\r\n");			
	    
	    
	    int retireAge = 65;
	    /*if(age >= retireAge) {
	    	System.out.println("Retired");11
	    } else {
	    	System.out.println("Not Retired");
	    }*/
	    
	    //age >= retireAge? System.out.println("Retired"); : System.out.println("Not Retired");
	    
	    boolean stop = false;
	    while (!stop) {
		    System.out.println("How old are you?");
		    float age = 394876;
		    try {
		      age = scan.nextFloat();
		    }
		    catch(Exception e) {
		    	System.out.println("That is not your age," + "'" + name + "'" + ".");
		    	 return;
		    }
		    
	    	if(age > 0 && age < 122) 
	    	{
	    		System.out.println("Then you are " + age + " years old!");
	    		stop = true;
	    	if (age >= retireAge) {
	    		float retiredYears = age - retireAge ;
	    		System.out.println("You have retired " + retiredYears + " years!");
	    	}
	    	else {
	    		float yearsToRetire = retireAge - age;
	    		System.out.println("You will retire in " + yearsToRetire + " years!");
	    	}
	    	}
	    	else {
	    		h++;	
	    		System.out.println("That is not true.");
	    		if( h  > 3){
	    			System.out.println("Stop it, " + name + "!");
	    			stop = true;
	    		}
	    	}
	    }
	}
}

	    
	      

