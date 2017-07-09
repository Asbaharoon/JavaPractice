class PrivateMember {
	PrivateMember() {
		Area = 10;
	}

	private int Area;
	
	protected int GetArea() {
		return Area;
	}
}

class PrivateMember___ {
	PrivateMember___() {
		Area = 10;
	}

	private int Area;
	
	protected int GetArea() {
		return Area * 10;
	}
}

class PrivateMember_ {
	PrivateMember_() {
		Width = 10;
		Height = 10;
	}

	private int Width;
	private int Height;
	
	protected int GetArea() {
		return Width * Height;
	}
}

class PrivateMember__ {
	private final double PI = 3.14;
	PrivateMember__() {
		r = 10;
	}

	private int r;
	
	protected double GetArea() {
		return PI * r * r;
	}
}

public class DataHiding {
	public static void main(String[] args) {
		PrivateMember pm = new PrivateMember();
		pm.GetArea();

		PrivateMember_ pm_ = new PrivateMember_();
		pm_.GetArea();
	}
}
