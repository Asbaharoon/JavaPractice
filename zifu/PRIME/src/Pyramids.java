
public class Pyramids {
	/*@ requires LineNumber <= 10;
	 @ ensures \result < 10;
	 @*/
	public static /*@ pure @*/int Spaces(int LineNumber) {
		final int[] NumberOfSpaces = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		return NumberOfSpaces[LineNumber];
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			int SpaceNumber = Spaces(i);
			for (int j = 0; j < SpaceNumber; j++) {
				System.out.print(" ");
			}
			for (int j = i; j >= 0; j--) {
				System.out.print("" + j);
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("" + j);
			}
			System.out.print(" ");

			for (int j = SpaceNumber; j >= 0; j--) {
				System.out.print("" + j);
			}
			for (int j = 1; j <= SpaceNumber; j++) {
				System.out.print("" + j);
			}

			System.out.println("");
		}

	}
}
