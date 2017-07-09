
import java.util.*;

public class LtoU {
    public static void main(String[] args) {
    	String a = "aBcDeFgHiJkLmNoPqRsTuVwXyZ";
    	System.out.print(CapsLock(a));
    }
    
    public static char CapsLock(char a){
    	if(a >= 'a' && a <= 'z'){
    		a -= 32;
    	}else if(a >= 'A' && a <= 'Z'){
    		a += 32;
    	}
		return a;
    }
    
    public static String CapsLock(String a){
    	char[] a_= a.toCharArray();
    	int alength = a.length();
    	for(int i = 0; i < alength; i++){
    		a_[i] = CapsLock(a_[i]);
    	}
    	a = String.valueOf(a_);
    	return a;
    }
}

