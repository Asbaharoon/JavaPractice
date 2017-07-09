class Addition {
	Addition() {
		
	}

	Addition(int a) {
		System.out.println("In Addition Constructor");
	}
	
	int Sub(int a, int b) {
		return a - b;
	}

	int Add(int a, int b) {
		return a + b;
	}
	
	float Add(float a, float b) {
		return a + b;
	}
	
	double Add(double a, double b) {
		return a + b;
	}
	
	short Add(short a, short b) {
		return (short)(a + b);
	}
	
	long Add(long a, long b) {
		return a + b;
	}
	
	byte Add(byte a, byte b){
		return (byte)(a + b);
	}
	
	String Add(String a , String b){
		return a + b; 
	}
	
	char Add(char a, char b){
		return (char)(a + b);	}



int Add(int a, int b, int c) {
	return a + b + c;
}

float Add(float a, float b, float c) {
	return a + b + c;
}

double Add(double a, double b, double c) {
	return a + b + c;
}

short Add(short a, short b, short c) {
	return (short)(a + b + c);
}

long Add(long a, long b, long c) {
	return a + b + c;
}

byte Add(byte a, byte b, byte c){
	return (byte)(a + b + c);
}

String Add(String a , String b, String c){
	return a + b + c;
}

char Add(char a, char b, char c){
	return (char)(a + b + c);	}

}

class ExtendedAddition extends Addition {
	ExtendedAddition(int a) {
		super(a);
		System.out.println("In ExtendedAddition Constructor");
	}
}

public class OverLoading {
	public static void main(String[] args) {
		ExtendedAddition add = new ExtendedAddition(1);
		long Overflow = add.Add(0x60000000, 0x60000000, 0x40000000);
		if(Overflow > 10000) {
			System.out.println("It is too big, we cannot deal with it");
		}
		
		int Underflow = add.Sub(0x1000, 0x2000);
		if(Underflow < 0) {
			System.out.print("It is not enough");
		}
		int a = add.Add(1,2);
		float b = add.Add((float)1.0, (float)2.0);
		double c = add.Add(1.0, 1.0);		
		short d = add.Add((short)1,(short) 2);
		long e = add.Add(1, 2);
		byte f = add.Add((byte)1,(byte) 2);
		String g = add.Add("h", "i");
		char j = add.Add('k', 'l');
		int aa = add.Add(1, 2, 3);
		float bb = add.Add((float)1.0, (float)2.0, (float)3.0);
		double cc = add.Add(1.0, 2.0, 3.0);		
		short dd = add.Add((short)1, (short)2, (short)3);
		long ee = add.Add(1, 2);
		byte ff = add.Add((byte)1, (byte)2, (byte)3);
		String gg = add.Add("h", "i", "j" );
		char jj = add.Add('k', 'l', 'm');
	
	}
}