class Date {
	Date() {
		Year = 0;
		Month = 0;
		Day = 0;
	}

	Date(int Month_, int Day_) {
		Year = 0;
		Month = Month_;
		Day = Day_;
	}

	Date(int Year_, int Month_, int Day_) {
		Year = Year_;
		Month = Month_;
		Day = Day_;
	}

	private int Year;

	private void SetYear(int Year_) {
		Year = Year_;
	}

	protected int GetYear() {
		return Year;
	}

	protected int Month;
	protected int Day;
}

class DateInAYear extends Date {
	DateInAYear() {

	}

	DateInAYear(int Year_) {
		SetYear(Year_);
	}
}

class MonthAndYear extends DateInAYear {
	MonthAndYear() {

	}

	MonthAndYear(int Year_, int Month_) {
		super(Year_);
		Month = Month_;
	}
}

class SpecificDate extends MonthAndYear {
	SpecificDate(int Year_, int Month_, int Day_) {
		super(Year_, Month_);
		Day = Day_;
	}
}

public class OOP {
	public static void main(String[] OOP) {
		// Date date = new Date(2016, 5, 22);
		// Date date2 = new Date(5, 22);
		// DateInAYear date3 = new DateInAYear(2016);

		// MonthAndYear date4 = new MonthAndYear(2016, 5);
		SpecificDate date4 = new SpecificDate(2016, 5, 22);
		// date.Year = 2016;
		// date.Month = 5;
		// date.Day = 22;
		System.out.println("The date is " + date4.GetYear() + "Month: " + date4.Month + " Day: " + date4.Day);
	}
}
