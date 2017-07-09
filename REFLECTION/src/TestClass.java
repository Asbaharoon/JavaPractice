
public class TestClass {

    public enum DayOfTheWeek{
    	MONDAY,
    	TUESDAY,
    	WEDNESDAY,
    	THURSDAY,
    	FRIDAY,
    	SATURDAY,
    	SUNDAY
    		}
	public final String name = "TEST"; 
	public final int size = 1;
	public volatile DayOfTheWeek Day = DayOfTheWeek.SATURDAY;

	public synchronized strictfp final int modifiers(int a){
    	return a + 1;
    }
    
   public static native void modPrint();
};


