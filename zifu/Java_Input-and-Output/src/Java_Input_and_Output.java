import java.io.File;
import java.io.IOException;

public class Java_Input_and_Output {
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

	public static void main(String[] args) {
		String Filename = "C:\\Users\\gaofj\\workspace\\zifu\\Java_Input-and-Output\\file1.txt";
		File file = new File(Filename);
		boolean x = true;
		int j = 0;

		try {
			if (file.createNewFile()) {
				System.out.println(Filename);
				System.out.println("result = " + x);
			} else {
				x = false;
				System.err.println(Filename);
				System.err.println("result = " + x);
				for (j = 1; j < 2; j++) {
					ErrorCount(x, j);
				}
			}
		} catch (IOException ioex) {

		}
	}
}
