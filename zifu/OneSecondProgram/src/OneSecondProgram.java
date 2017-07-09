import java.util.*;
import java.text.*;
public class OneSecondProgram{
	public static void main(String[] args) {    
		 // TODO Auto-generated method stub
		System.out.println("Hello World, it's... ");				
		//25, 49, 100, 196, 400, 784, 1600, 3168, 6400, 
		for (int thing = 0; thing < 1 ; thing++) {
			System.out.println("What time is it?");
			int V = 1;
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			System.out.println(dateFormat.format(date));
			
		}
		
	}
}
