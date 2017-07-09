import java.util.Scanner; 
public class OddtoEven {
	public static boolean IsEven(int Number) {
		if ((Number & 1) != 0) {
			return false;
		} else {
			return true;
		}
	}
	public static int POW(int x, int y){
		int Value = 1; 
		for (int Counter = 0; Counter < y; Counter++ ){
		Value *= x;
		}
		return Value;
	}
	
	public static void main(String[] args){
		System.out.println("Please imput a number.");
		Scanner scan = new Scanner(System.in);
		int Imput = scan.nextInt();
		boolean Finish = IsEven(Imput);
		System.out.println("It is " + Finish + " that that is a even number.");
		System.out.println("Please imput two more numbers.");
		int OtherImput = scan.nextInt();
		int FinalImput = scan.nextInt();
		int OtherFinish = POW(OtherImput,FinalImput);
		System.out.println("The answer to the first number to the power of the second is " + OtherFinish);
	}	
}
