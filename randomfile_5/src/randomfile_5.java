
public class randomfile_5 {
	public static void main(String[] args){
	TrianglePattern(5);
	
	}
	public static void TrianglePattern(int a){
		for(int i = 1; i <= a; i++){
			for(int j = i; j <= i; j++){
				System.out.print(j);
			}
		}
	}
	
	
	
	
}
