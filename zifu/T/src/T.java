import java.math.*;
public class T {
	public static void main (String[] args) {
	int d = 3;
	int count = 0;
//	boolean g = false;
	while (d < 1000){
			if(d % 3 == 0 || d % 5 == 0){
				System.out.println("" + d);
				count += d;
				//7, 9119455,3 ,5 233186
			}
		    d++;
//			if (d == 1000){
//				System.out.println("Count: " + count);
//				g = true;	
//			}
		}
	}
}

