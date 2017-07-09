	
import java.lang.reflect.*;

public class REFLECTION {
	public static void main(String[] args) {
   		TestClass testclass = new TestClass();
   		Field[] fields = testclass.getClass().getFields();
   		Method[] methods = testclass.getClass().getMethods();
		for(Method method: methods){
			System.out.println("Method: " +   method.getName());
			
			int modifiers = method.getModifiers();
			if(Modifier.isPublic(modifiers)) {
				System.out.println("Is public");
			}
			if(Modifier.isFinal(modifiers)) {
				System.out.println("Is final");
			}
			if(Modifier.isNative(modifiers)) {
				System.out.println("Is native");
			}
			if(Modifier.isProtected(modifiers)) {
				System.out.println("Is protected");
			}
			if(Modifier.isPrivate(modifiers)) {
				System.out.println("Is private");
			}
		} 

		for(Field field: fields){
			System.out.println("Field: " + field.getModifiers() + " " + field.getName());
		} 

   		Class[] interfaces = testclass.getClass().getInterfaces();
    }
    
}

