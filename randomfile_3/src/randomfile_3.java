
public class randomfile_3 {
	public static void main(String[] args){
		System.out.print(Equality(2564, 3526, 2456));
	}
	public static String Equality(int a, int b, int c){
		if(a == b && b == c){
			return "All numbers are equal.";
		}else if(a != b && b != c && c != a){
			return "All numbers are different.";
		}else{
			return "Neither.";
		}
		
	}
	
	
	
	
}
