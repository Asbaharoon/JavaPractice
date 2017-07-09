import java.util.Scanner;
public class JIOnumbers {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.print("Imput first number");
		int a = s.nextInt();
		System.out.print("Imput second number");
		int b = s.nextInt();
		multable(a, b);
		multable(b, a);



	}
	
	public static void multable(int a, int b){
		for(int k = 1; k <= b; k++){
			System.out.println("" + a + "*" + k + "=" + a*k);
		}
		}
	
}
