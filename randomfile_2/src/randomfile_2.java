
public class randomfile_2 {
	public static void main(String[] args){
		System.out.print(D(1524, 2345, 3321) );
	}
	
	
	public static String D(int a , int b, int c) {
		if(c > b && b > a){
			return "The numbers are in ascending order.";	
		}else if(a > b && b > c){
			return "The numbers are in descending order.";		
		}else{
			return "Neither";
		}
		
	}	
}

