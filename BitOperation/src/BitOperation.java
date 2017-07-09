
import java.util.*;

public class BitOperation {

	public static void main(String[] args) {
		int a1 = -3;
		
		System.out.println(lShift(a1, 30));
		
		int a = 0b1011001111011;
		int b = 0b1001011101010;
		BinaryPrintInt("and=", and(a, b));
		BinaryPrintInt("or=", or(a, b));
		BinaryPrintInt("xor=", xor(a, b));
		BinaryPrintInt("not=", not(a));
		BinaryPrintInt("rshift=", rShift(a, b));
		BinaryPrintInt("lshift=", lShift(a, b));

	}

	public static int and(int a, int b) {
		return a & b;
	}

	public static int or(int a, int b) {
		return a | b;
	}

	public static int xor(int a, int b) {
		return a ^ b;
	}

	public static int not(int a) {
		return a ^ 0xffffffff;
	}

	public static int rShift(int a, int b) {
		return a >> b;
	}

	public static int lShift(int a, int b) {
		return a << b;
	}

	public static void BinaryPrintInt(String desc, int val) {
		System.out.println(desc + String.format("%16s", Integer.toBinaryString(val)).replace(" ", "0"));
	}

}
