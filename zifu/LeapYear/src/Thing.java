import java.util.Scanner;

public class Thing {
	public static double Area(double Radius) {
		double Pi = 3.14;
		return Radius * Radius * Pi;
	}

	public static double Circumference(double Radius) {
		int Constant = 2;
		double Pi = 3.14;
		return Constant * Pi * Radius;
	}

	public static void main(String[] args) {
		System.out.println("Please choose a number.");
		Scanner scan = new Scanner(System.in);
		double Radius = scan.nextDouble();
		
		double Areaizer = Area(Radius);
		System.out.println("The area of that circle is " + Areaizer);

		double Circumferenceizer = Circumference(Radius);
		System.out.println("The circumference of that circle is " + Circumferenceizer);
	}
}