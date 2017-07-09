
public class BreakContinueExample {
	public static void main(String[] args) {
		for (int Basis = 0; Basis <= 1078; Basis++) {
			if (Basis % 61 != 0) {
				continue;
			} else {
				System.out.println("" + Basis);
			}
			if (Basis > 1078) {
				break;
			}
		}
	}
}