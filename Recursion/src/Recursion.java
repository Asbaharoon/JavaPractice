
import java.util.*;

public class Recursion {	
    public static void main(String[] args) {
    	System.out.println(binarySearch(0, 1000, -1000));
    	System.out.println(binarySearch(-500, 0, -1));
    	System.out.println(binarySearch(0, 1000, 1));
    	System.out.println(binarySearch(0, 1000, -0));
    	System.out.println(binarySearch(0, 1000, 0));
    	System.out.println(binarySearch(0, 1000, 999));
    	System.out.println(binarySearch(0, 1000, 1000));
    	System.out.println(binarySearch(0, 1000, 1001));
    	System.out.println(0);
    	System.out.println(1);
    	System.out.println(fact(7));
    	try{
    		System.out.println(add(0, 1)); 		
    	}catch(StackOverflowError e){
    		System.err.println("Infinite recursion.");
    	}
    
    }
    
    public static int add(int a, int b){
     	int test = a + b;
     	if(test > 10000) {
     		return test;
     	}
    	System.out.println(test);
    	return add(b , test);
    }
    
    private static int getLastFib(int size){
    	switch(size){
    	case 0:
    		return 0;
    	case 1:
    		return 1;
    	default: 
    		return getLastFib(size - 1) + getLastFib(size - 2);
    	}
    	
    	}
    
        private static int fact(int base){
        /*	if(0 == base){
        		return 1;
        	}else{
        		return base * fact(base - 1); 
        	} */
        	return 0 == base? 1 : base * fact(base - 1);
        }
        
        private static boolean binarySearch(int start, int end, int val){
        	int mid = (start + end) / 2;
        	System.out.println("Start: " + start + " Middle: " + mid + " End: " + end);
        	if(start > end){
        		return false;
        	}
        	if(mid < val){
         		return binarySearch(mid + 1, end, val);
        	}else if(mid > val){
        		return binarySearch(start, mid - 1, val);
        	}else{
        		return true;
        	}
        }
    }



