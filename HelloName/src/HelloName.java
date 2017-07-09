
public class HelloName {
public static void main(String[] args){
	int r1 = c1(-5, 8, 6);
	System.out.println(r1);
	int r2 = c2(55, 9, 9);
	System.out.println(r2);
	int r3 = c3(20, -3, 5, 8);
	System.out.println(r3);
	int r4 = c4(5, 15, 6);
	System.out.println(r1);

}
public static int c1(int a, int b, int c){
return a + b * c;
}
public static int c2(int a, int b, int c){
return (a + b) % c;
}
public static int c3(int a, int b, int c, int d){
return a + b * c / d;
}
public static int c4(int a, int b, int c, 
		int d, int e, int f){
return a + b / c * d - e % f;
}
}