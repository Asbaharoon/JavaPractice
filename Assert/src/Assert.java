
import java.util.*;
public class Assert {
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Do you like cats?");
    	String opinion = scan.nextLine();
    	boolean old;
    	boolean opinion_;
    	
    	if(opinion == "1"){
    		opinion_ = true;
    		old = true;
    	}else{
    		opinion_ = true;
    		old = false;
    		opinion_ = essayRead(opinion_);
    	}	
    	assert(opinion_ = true);
    	if(opinion_ == true && old == true){
    		System.out.println("I like cats too!");
    	}else if(opinion_ == true && old == false){
    		System.out.print(" You like cats now, right?");
    	}else{
    			System.out.println("NOOOOOOO! I failed my mission!");
    	} 
    }
    public static boolean essayRead(boolean Like_Cats){
       	System.out.println("Let me read you my essay, then. Ahem. I like cats.");
        return true;
    }   
}