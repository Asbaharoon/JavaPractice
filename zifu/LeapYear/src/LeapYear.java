package java.ZifuUser.LeapYear;
import java.util.Scanner;
public class Date {
    int Year;
    int Month;
    int Day;
    
    int GetYear() {
    	return Year;
    }
    
    int GetMonth() {
    	return Month;
    }
    
    int GetDay() {
    	return Day;
    }
    
    void SetYear(int NewYear) {
    	Year = NewYear;
    }
    
    void SetMonth(int NewMonth) {
    	Month = NewMonth;
    }
    
    void SetDay(int NewDay) {
    	Day = NewDay;
    }
};

public class LeapYear {
	static int[] Days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	/*@ requires 
	 ensures true */
	public static boolean IsLeapYear(Date date) {
		int Year = date.GetYear();
		return IsLeapYear(Year);
	}

	/*@ requires Year > 0 && Year < 3000
	 ensures true */
	public static /*@ pure */boolean IsLeapYear(int Year) {
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
	/*@ 
	 */
	public static /*@ pure @*/int DaysBefore(Date date) {
		int Year = date.GetYear();
		int Month = date.GetMonth();
		int Day = date.GetDay();
	}
	public static int DaysBefore(int Year, int Month, int Day) {
		int dayCounter = 0;
		for (int addDays = 0; addDays < Month - 1; addDays++) {
			dayCounter += Days[addDays];
			if (addDays == 1 && IsLeapYear(Year)) {
				dayCounter++;
			}
		}

		dayCounter += Day;
		return dayCounter;
	}

	public static int DaysAfter(int Year, int Month, int Day) {
		int daysBefore_ = DaysBefore(Year, Month, Day);
		return WholeYear(Year) - daysBefore_;
	}

	public static int WholeYear(int Year) {
		if (IsLeapYear(Year)) {
			return 366;
		} else {
			return 365;
		}
	}

	public static int YearToDay(int StartYear, int EndYear) {
		int DayCounter = 0;
		for (int Year = StartYear; Year < EndYear; Year++) {
			DayCounter += WholeYear(Year);
		}

		return DayCounter;
	}

	public static int DayDifference(int StartYear, int StartMonth, int StartDay, int EndYear, int EndMonth,
			int EndDay) {
		if(StartYear != EndYear) {
			return DaysAfter(StartYear, StartMonth, StartDay) + YearToDay(StartYear + 1, EndYear - 1)
				+ DaysBefore(EndYear, EndMonth, EndDay);
		} else {
			return DaysDifference(StartYear, StartMonth, StartDay, EndMonth, EndDay);	
		}
	}

	public static int WholeMonth(int Month){
		
		
	}
	public static void main(String[] args) {
		int StartYear, StartMonth, StartDay, EndYear, EndMonth, EndDay;
		Scanner scan = new Scanner(System.in);
		
		StartYear = scan.nextInt();
		StartMonth = scan.nextInt();
		StartDay = scan.nextInt();
		EndYear = scan.nextInt();
		EndMonth = scan.nextInt();
		EndDay = scan.nextInt();
		int dayCounter = DayDifference(StartYear, StartMonth, StartDay, EndYear, EndMonth, EndDay);
 		System.out.println("You are " + dayCounter + " days old.");
	}
}