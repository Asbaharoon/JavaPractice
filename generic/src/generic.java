
import java.util.*;

public class Generic {
    public static void main(String[] args) {
    	int a = 7;
    	int b = 6;
    	pl("a " + "b");
    	pl(0.6);
    }
    
    public static <T> void pl(T text){
    	System.out.println(text);
    }
    
    public static <T> T add(T a, T b)
    {
    	return (T)(a + b);
    }
    }
}

