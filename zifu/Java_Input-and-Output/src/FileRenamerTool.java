import java.io.File;

public class FileRenamerTool {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\gaofj\\workspace\\zifu\\Java_Input-and-Output\\file1.txt");

		if (file.renameTo(new File("C:\\Users\\gaofj\\workspace\\zifu\\Java_Input-and-Output\\Otherfile.txt")))
			;
		System.out.println("FileRenamerTool successfully renamed this file");
	}

	{
		System.err.println("FileRenamerTool failed to rename this file");
	}

}
