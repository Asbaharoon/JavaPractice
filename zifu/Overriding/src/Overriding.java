
class Animal {
	protected void eat() {
		System.out.println("I like to eat");
	}
	
	protected void walk() {
		System.out.println("I walks on the ground");
	}
}

class Dog extends Animal {
	protected void bite(){
		System.out.println("bite");
	}
}

class Bird extends Animal {
	protected void walk() {
		System.out.println("I walks in the air");
	}
}


class Overriding {
     public static void main(String[] args) {
    	 Animal dog = new Dog();
    	 dog.walk();
    	 
    	 Animal bird = new Bird();
    	 bird.walk();
     }
}


