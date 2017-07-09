import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilePenTool {
	public static int ErrorCount(boolean x, int j) {
		if (x == false) {
			for (int i = 0; i < 2; i++) {
				if (j > 0) {
					System.err.println("Error");
				}
			}
		}
		return j;
	}

	static String[] string = { "'", "\"" };
	static char[] Char = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
			'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', '0', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '`', '~', '-', '_', '=', '+', '[', ']', '{',
			'}', '\\', '|', ';', ':', ',', '.', '<', '>', '/', '?' };

	public static void main(String[] args) {
		String Filename = "C:\\Users\\gaofj\\workspace\\zifu\\Java_Input-and-Output\\file1.txt";
		File file = new File(Filename);
		boolean x = true;
		boolean y = true;
		int j = 0;
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(file, y));
			writer.println(string);
			writer.println(Char);
			writer.close();
			System.out.println(x);
		} catch (IOException ioex) {
			y = false;
			x = false;
			System.err.println("Fail");
			PrintWriter writer_;
			try {
				writer_ = new PrintWriter(new FileWriter(file, y));
				writer_.println(string);
				writer_.println(Char);
				writer_.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
