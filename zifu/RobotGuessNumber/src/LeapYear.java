import java.util.Scanner;

public class LeapYear {
	static int[] Days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static boolean IsLeapYear(int Year) {
		if (Year % 4 == 0) {
			return true;
		} else if (Year % 100 == 0) {
			return false;
		} else if (Year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static int DaysBefore(int Year, int Month, int Day) {
		int dayCounter = 0;
		for (int addDays = 0; addDays < Month; addDays++) {
			dayCounter = +Days[addDays];
			if (addDays == 1) {
				dayCounter++;
			}
		}

		dayCounter += Day;
		return dayCounter;
	}

	public static void main(String[] args) {
		/*
		Scanner scan = new Scanner(System.in);
		int Year = scan.nextInt();
		if (IsLeapYear(Year)) {
			System.out.println("That is a leap year.");
		} else {
			System.out.println("That is not a leap year");
		}
		*/
		int dayCounter = DaysBefore(2007, 3, 14);
		System.out.println("You are " + dayCounter + " days old.");
	}
}
