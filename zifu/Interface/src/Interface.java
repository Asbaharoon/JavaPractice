package src;
import static org.junit.Assert.*;

interface IAnimal {
	public void eat();
	public void travel();
}

class Cat implements IAnimal {
    public void eat() {
    	System.out.println("Cat eats");
    }
    public void travel() {
    	System.out.println("Cat travels");
    }
}


class Dog implements IAnimal {
    public void eat() {
    	System.out.println("Dog eats");
    }
    public void travel() {
    	System.out.println("Dog travels");
    }
}


interface IShape {
	public double Area();
	public double Perimeter();
}


class Rectangle implements IShape {
	Rectangle()
	{
		this.Width = 0;
		this.Height = 0;
	}
	
	Rectangle(double Width, double Height) {
		this.Width = Width;
		this.Height = Height;
	}
	
	public double Area() {
		return this.Width * this.Height;
	}
	
	public double Perimeter() {
		return 2 * (this.Width + this.Height);
	}
	
	private double Width;
	private double Height;
}

class Circle implements  IShape {
	private final double PI = 3.14;
	private double r;
	
	Circle() {
		r = 0.0;
	}

	Circle(double r) {
		this.r = r;
	}
	
	public double Area() {
		return PI * this.r * this.r;
	}
	
	public double Perimeter() {
	
		return 2 * PI * r;
	}
}


class InterfaceTest {
	public static void main(String[] args) {
		IShape  shape1 = new Rectangle(2.0, 5.0);
		assert(10.0 == shape1.Area());
		IShape shape2 = new Circle(2.0);
		assert(3.14 * 4.0 == shape2.Area());
	}
}
