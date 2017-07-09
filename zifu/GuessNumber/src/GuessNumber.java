import java.util.Scanner;
import java.util.Random;
public class GuessNumber {
	public static void main(String[] args) {
		int z = 0;
		Random w = new Random();
		Scanner scan = new Scanner(System.in);
		int f = w.nextInt(10000);
		f = 1;
		System.out.println("Please guess a number from [1-9999]");
		while(true) {
			int y = scan.nextInt();
			z++;
			if (y == f) {
				System.out.println("You win!");
				System.out.println("You guessed it in " + z + " tries!");
				break;
			} else if (y > f) {
				System.out.println("Too high!");
			} else {
				System.out.println("Too low!");
			}
		}
	}
}