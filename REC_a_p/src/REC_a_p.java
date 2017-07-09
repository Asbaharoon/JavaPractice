
public class REC_a_p {
	public static void swap(int &a, int &b){
		int c = a;
		a = b; 
		b = c;
	}

	public static void main(String[] args){
	int a = 3; 
	int b = 4; 
	swap(a, b); 
	System.out.print(" " + a + " " + b);
	}
	
}

