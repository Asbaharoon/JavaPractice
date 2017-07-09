import java.util.*;



public class randomfile_1 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.print("Imput first number");
		double a = s.nextDouble();
		System.out.print("Imput second number");
		double b = s.nextDouble();
		System.out.print("Imput third number");
		double c = s.nextDouble();
		double[] arr = {a , b, c};
		double ave = average(arr);
		
		System.out.print(ave);
	}
	
	final static double pi = 3.14159265;
	public static double circumference(double r){
			return 2 * pi * r;
	}
	public static double area(double r){
			return pi * r * r;
	}
	public static double average(double[] a){
		int alength = a.length;
		double sum = 0;
		for(int i = 0; i < alength; i++){
			sum += a[i];
		}
		return sum/alength;
	}
}
