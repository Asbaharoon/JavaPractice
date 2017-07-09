import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTool {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\gaofj\\workspace\\zifu\\Java_Input-and-Output\\file1.txt");
		char[] Char = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
				'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'0', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '`', '~', '-', '_', '=', '+', '[', ']', '{', '}',
				'\\', '|', ';', ':', ',', '.', '<', '>', '/', '?' };

		BufferedReader reader;
		String line;
		try {
			reader = new BufferedReader(new FileReader(file));

			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

			reader.close();
		} catch (IOException ioex) {
			System.out.println(Char);
		}
	}
}
