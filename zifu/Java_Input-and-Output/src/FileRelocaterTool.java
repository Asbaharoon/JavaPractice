import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileRelocaterTool {

	public static void main(String[] args) {
		File oldFile = new File("C:\\Users\\gaofj\\workspace\\zifu\\Java_Input-and-Output\\file1.txt");
		File newFile = new File("C:\\Users\\gaofj\\workspace\\zifu\\folder0\\file1.txt");

		BufferedReader reader;
		PrintWriter writer;

		String line;

		try {
			if (newFile.createNewFile() || !newFile.createNewFile()) {
				reader = new BufferedReader(new FileReader(oldFile));
				writer = new PrintWriter(new FileWriter(newFile));

				while ((line = reader.readLine()) != null) {
					writer.println(line);
				}

				reader.close();
				writer.close();
			}

			oldFile.delete();

		} catch (IOException ioex) {

		}

	}
}
