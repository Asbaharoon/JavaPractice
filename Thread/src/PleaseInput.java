import java.util.*;

public class PleaseInput extends Thread {
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Please inpit something");
			String inp = scanner.next();
			System.out.println(inp);
		}
	}
}
