import java.io.File;

public class FileRemoverTool {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\gaofj\\workspace\\zifu\\Java_Input-and-Output\\file1.txt");
		if (file.delete()) {
			System.out.println("The file was successfully removed");
		} else {
			System.err.println("The file failed to be removed");
		}

	}

}
