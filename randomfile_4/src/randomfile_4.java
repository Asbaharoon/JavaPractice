
public class randomfile_4 {
	public static void main(String[] args){
	System.out.print(Alphabet("y"));
	} 
	public static String Alphabet(String a){
		char[] cArray = a.toCharArray();
		char ch = cArray[0];
		int alength = a.length();
		if(alength != 1){
			return "ERROR";
		}else{
			switch (ch) {
			
			case 'a':
			case 'e': 
			case 'i':
			case 'o':
			case 'u':
				return "Vowel";
			
			case 'b':
			case 'c':
			case 'd':
			case 'f':
			case 'g':
			case 'h':
			case 'j':
			case 'k':
			case 'l':
			case 'm':
			case 'n':
			case 'p':
			case 'q':
			case 'r':
			case 's':
			case 't':
			case 'v':
			case 'x':
			case 'z':
				return "Consonant";
			
			case 'w':
			case 'y':
				return "Vowel or Consonant ";
			default: 
				return "ERROR";
			
			}				
		}
	}	
}
