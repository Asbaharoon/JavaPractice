
public class randomNum extends Thread{
	public void run() {
		for(int i = 0; i < 1000; i++){
		double x = Math.random();
		double x_ = x * 1000;
		int x__ = ((int) x_);
		System.out.println(x__);
		}
		}
	
}
