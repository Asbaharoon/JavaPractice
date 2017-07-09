import java.util.Scanner;

public class PRIME {
	public static int Sum(int[] ints) {
		int base = 0;
		for(int x: ints) {
			base += x;
		}
		return base;
	}

	public static boolean IsPrime(int PrimeCheckBase) {
		for (int Divisor = 2; Divisor < PrimeCheckBase / 2 + 1; Divisor++) {
			if (PrimeCheckBase % Divisor != 0) {
			} else {
				return false;
			}
		}
		return true;
	}
	public static boolean SearchFor(int[] LostObjectSearch, int LostObject){
		for(int x: LostObjectSearch){
			if(x == LostObject){
				return true;
			}
		}
		return false;
	}
	public static void main(String[] thingy) {
		for (String x : thingy) {
			System.out.println(x);
		}

		System.out.println("Please imput a number.");
		//Scanner scan = new Scanner(System.in);
		//int Prime = scan.nextInt();
		//boolean PrimeChecker = IsPrime(Prime);
		//System.out.println("It is " + PrimeChecker + " that that number is a prime!");
		final int[] Days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		//int SumOfDays = Sum(Days);
		//System.out.println("" + SumOfDays);
		boolean Found = SearchFor(Days, 97);
		System.out.println(Found? "Found!": "Not found");
 	}
}

