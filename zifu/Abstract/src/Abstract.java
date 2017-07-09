
abstract class Abstract {
    protected int Method1() {
    	return 1;
    }
    
    abstract protected int Method2();
}

abstract class AbstractExtendedClass extends Abstract {
	protected int Method2() {
		return 2;
	}
	
	abstract protected int Method3();
}

class ConcreteClass extends AbstractExtendedClass {
	protected int Method3() {
		return 1;
	}
}

class AbstractTest {
	public static void main(String[] args) {
		
		AbstractExtendedClass Test = new ConcreteClass();
		
		assert(1 == Test.Method3());
		}

}


abstract class Animal {
	protected void eat() {
		System.out.println("I like to eat");
	}
	
	abstract protected void walk();
}


class Cat extends Animal {
	protected void walk() {
		System.out.print("I walk like a cat");
	}
}

class Bird extends Animal {
	protected void walk() {
		System.out.print("I fly instead of walking");
	}
}


