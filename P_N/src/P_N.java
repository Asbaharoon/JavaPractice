
public class P_N {
	public static void main(String[] args){
	
		
		
		//int[] a = {25, 78, 87};
		 System.out.print(DayCount(2, 2016));
	}
	public static String P_N(int a){
	if(a > 0){
		return "Positive";
	}else if(a < 0){ 
		return "Negative";
	}else{
		return "Zero";
	}
	}
	public static int bigNumber(int[] a){
		int alength = a.length;
		int gN = 0;
		for(int i = 0; i < alength; i++){
			if(a[i] > gN){
				gN = a[i]; 
			}
		}
		return gN;
	}
	public static String Weekday(int a){
		int a_ =  a % 7;
		switch (a_) {
		case 1: 
			return "Monday";
		
		case 2: 
			return "Tuesday";
		
		case 3: 
			return "Wednesday";

		case 4: 
			return "Thursday";

		case 5: 
			return "Friday";

		case 6: 
			return "Saturday";

		case 0: 
			return "Sunday";
			
		default:
			return "Wrong!";
			
		}
	
	}
	
	public static int DayCount_v2(int mon, int year)
	{
		static int[] days[] = {31,28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(IsLeapYear(year) && 2 == month) {
			return days[month - 1] + 1;
		}
		else {
			return days[month - 1];			
		}
	}
	
-*
	public static int DayCount(int mon, int year){
	
		switch(mon){
		
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:	
			return 31;
			
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;

		case 2: 
			if(IsLeapYear(year)) {
				return 29;
			}
			return 28;
			
		default: 
			return -1;
		}
		
		
	}
	
	public static boolean IsLeapYear(int year){
		if(0 != year % 400 && 0 == year % 100){
			return false;
		}else if(0 == year % 400){
			return true;
		}else if(0 == year % 4 && 0 != year % 100){
			return true; 
		}else{
			return false;
		}
		
	} 
	

	public static boolean IsLeapYear_v2(int year){
		if(0 == year % 100){
			return (0 == year % 400);
		}
		
		return (0 == year % 4);
	} 

}
