import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCopyMachineTool {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\gaofj\\workspace\\zifu\\Java_Input-and-Output\\file1.txt");
		File file1 = new File("C:\\Users\\gaofj\\workspace\\zifu\\file2.txt");
		BufferedReader reader;
		PrintWriter writer;

		String line;

		try {
			if (file1.createNewFile() || !file1.createNewFile()) {
				reader = new BufferedReader(new FileReader(file));
				writer = new PrintWriter(new FileWriter(file1));

				while ((line = reader.readLine()) != null) {
					writer.println(line);

					writer.close();
					reader.close();
				}

			}
		} catch (IOException ioex) {
			System.err.println("FileCopyMachineTool failed to copy the file to the designated location");
		}

	}
}
