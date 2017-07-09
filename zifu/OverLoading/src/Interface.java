//abstract
interface Animal {
	public void eat();
	public void travel();
}

class Cat implements Animal {
    public void eat() {
    	System.out.println("Cat eats");
    }
    public void travel() {
    	System.out.println("Cat travels");
    }
}


class Dog implements Animal {
    public void eat() {
    	System.out.println("Dog eats");
    }
    public void travel() {
    	System.out.println("Dog travels");
    }
}

abstract class AnimalClass {
	public void eat() {
		System.out.print("eat is same for all");
	}
	
	public abstract void travel();
}

abstract class CatClass {
	public void travel()
	{
    	System.out.println("Cat travels");		
	}
}

abstract class DogClass {
	public void travel()
	{
    	System.out.println("Dog travels");
	}
}


public class Interface {
	public static void main(String[] args) {
		AnimalClass ac =  new AnimalClass();
		
        Cat cat = new Cat();
        cat.eat();
	}
}
