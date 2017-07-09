import java.util.Scanner;

public class RobotGuessNumber {
	public static void main(String[] args) {
		System.out.println("Please choose a number from [1-10,000]");
		Scanner s = new Scanner(System.in);
		System.out.println("I will try to guess the number. ");
		System.out.print("Type'H' if I guess too high ,and'L'if too low");
		System.out.print("and 'W' if I win.");
		int count = 0;
		int LowRange = 1;
		int HighRange = 9999;
		boolean bWin = false;
		while (!bWin) {
			int GuessValue = (LowRange + HighRange) / 2;
			System.out.println("\nI guess the number is " + GuessValue + ".");
			char c = s.next().charAt(0);
			count++;
			if (c == 'H' || c == 'h') {
				HighRange = GuessValue - 1;
			} else if (c == 'L' || c == 'l') {
				LowRange = GuessValue + 1;
			} else if (c == 'W' || c == 'w') {
				bWin = true;
				System.out.println("I guessed " + count + " times.");
			}
		}
	}
}