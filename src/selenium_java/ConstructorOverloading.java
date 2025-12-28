package selenium_java;

public class ConstructorOverloading {
	
	ConstructorOverloading(String name){
		System.out.println("this is constructor" + name);
	}
	ConstructorOverloading(int a){
		System.out.println("this is 2nd constructor" + a);
	}

	public static void main(String[] args) {
		new ConstructorOverloading(10); 
		new ConstructorOverloading("selenium");
		
	}

}
