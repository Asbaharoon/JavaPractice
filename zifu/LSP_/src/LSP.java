class Rectangle {
	private int width;
	private int height;
	
	protected int Area() {
		return this.width * this.height;
	}
	
	protected int getWidth() {
		return this.width;
	}

	protected int getHeight() {
		return this.height;
	}

	protected void setWidth(int width) {
		this.width = width;
	}

	protected void setHeight(int height) {
		this.height = height;
	}
}

class Square extends Rectangle {
	protected int Area() {
		return getWidth() * getWidth();
	}
}

public class LSPTest {
	public static void main(String[] args) {
		Rectangle rect = new Square();
		rect.setWidth(5));
		rect.setHeight(20);
		assertEquals(100 == rect.Area();
	}
}
