import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryCreatorTool {

	public static void main(String[] args) {
		List<File> directories = new ArrayList<File>();
		directories.add(new File("C:\\Users\\gaofj\\workspace\\zifu\\folder1"));
		directories.add(new File("C:\\Users\\gaofj\\workspace\\zifu\\folder2"));
		directories.add(new File("C:\\Users\\gaofj\\workspace\\zifu\\folder3"));
		directories.add(new File("C:\\Users\\gaofj\\workspace\\zifu\\folder4"));
		directories.add(new File("C:\\Users\\gaofj\\workspace\\zifu\\folder5"));
		directories.add(new File("C:\\Users\\gaofj\\workspace\\zifu\\folder6"));
		directories.add(new File("C:\\Users\\gaofj\\workspace\\zifu\\folder7"));
		directories.add(new File("C:\\Users\\gaofj\\workspace\\zifu\\folder8"));
		directories.add(new File("C:\\Users\\gaofj\\workspace\\zifu\\folder9"));
		directories.add(new File("C:\\Users\\gaofj\\workspace\\zifu\\folder0"));

		for (File file : directories) {
			if (file.mkdir()) {
				System.out.println(file.getPath() + "DirectoryCreator successfully created a directory");
			} else {
				System.err.println(file.getPath() + "DirectoryCreator failed to create a directory");
			}
		}
	}
}