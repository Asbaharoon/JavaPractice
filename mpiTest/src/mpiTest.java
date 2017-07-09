

public class mpiTest {
	public static enum charType{
	    ControlChar,
		Number,
		Lowercase_Letter, 
		Uppercase_Letter,
	};
		
	public static final int ControlChar = 0;
	public static final int Number = 1;
	public static final int Uppercase_Letter = 2;
	public static final int Lowercase_Letter = 3;

	public static void main(String[] args) {
		int a = n_u_l('h');
		switch(a){
		case ControlChar:
			System.out.print("ControlChar");
		case Number:
			System.out.print("Number");
		case Uppercase_Letter:
			System.out.print("Uppercase_Letter");
		case Lowercase_Letter:
			System.out.print("Number");

		
		}
		
    }
  
    public static void println(String a){
    	System.out.println(a);
    }
    public static int n_u_l(char a){    	
    	if(a >= '0' && a <= '9'){
    		return Number; 
    	}else if(a >= 'a' && a <= 'z'){
    		return Lowercase_Letter;
    	}else if(a >= 'A' && a <= 'Z'){
    		return Uppercase_Letter;
    	}else{
    		return ControlChar;
    	}
    }  
    	
    
    
}
