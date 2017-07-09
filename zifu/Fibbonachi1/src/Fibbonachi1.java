
public class Fibbonachi1 {
	public static void main(String[] args) {
		System.out.println("0");
		int fibbonachi = 0;
		int OtherFibbonachi = 1;
		int addedFibbonachi = 0;
 		while (addedFibbonachi < 1000) {
 			addedFibbonachi = fibbonachi + OtherFibbonachi;
			if (addedFibbonachi % 2 == 0) {
				System.out.println("" + addedFibbonachi);
			}
			fibbonachi = OtherFibbonachi;
			OtherFibbonachi = addedFibbonachi;
			}
	}
}
