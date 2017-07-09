
import java.io.*;

public class rot13 {
	public static void main(String[] args) {

		String res = Convert("Hello");
		System.out.print("" + res);
	}

	public static int GetIndex(char ch) {
		final String cTable = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return cTable.indexOf(ch);
	}

	public static char Convert(int index) {
		final String cTable = "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM";
		return cTable.charAt(index);
	}

	public static char Convert(char ch) {
		int chIndex = GetIndex(ch);
		if (chIndex < 0) {
			return ch;
		}
		return Convert(chIndex);

	}

	public static String Convert(String str) {
		char[] str_ = str.toCharArray();
		for (int i = 0; i < str_.length; i++) {
			str_[i] = Convert(str_[i]);
		}
		return new String(str_);
	}
}
