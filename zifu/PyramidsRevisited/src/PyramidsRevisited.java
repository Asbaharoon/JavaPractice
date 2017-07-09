
public class PyramidsRevisited {
	
	public static void CreateLeftSection(int LayerNumber) {
		for (int i = LayerNumber; i >= 0; i--) {
			System.out.print("" + i);
		}
	}

	public static void CreateRightSection(int LayerNumber) {
		for (int i = 1; i <= LayerNumber; i++) {
			System.out.print("" + i);
		}
	}

	public static /* @ pure @ */int Spaces(int LineNumber) {
		final int[] NumberOfSpaces = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		return NumberOfSpaces[LineNumber];
	}

	public static void PushTheAir(int LayerNumber) {
		int BlankNumber = Spaces(LayerNumber);
		for (int i = 0; i < BlankNumber; i++) {
			System.out.print(" ");
		}
	}

	public static void DrawNewLine() {
		System.out.println("");
	}

	private static void AddOneLayer(int LayerNumber) {
		PushTheAir(LayerNumber);
		CreateLeftSection(LayerNumber);
		CreateRightSection(LayerNumber);
	}

	public static void FinishPyramid() {
		for (int Pyr = 0; Pyr < 10; Pyr++) {
			AddOneLayer(Pyr);
			DrawNewLine();
		}
	}

	public static void main(String[] args) {
		FinishPyramid();
	}
}
