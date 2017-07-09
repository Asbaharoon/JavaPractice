
import java.util.*;

public class AutoBoxing {
    public static void main(String[] args) {
    	int a = 1;
    	Unbox(Box(a));
    }
    
    public static Integer Box(int a){
    	return a;
    }
    
    public static int Unbox(Integer a){
    	return a;
    }
}

