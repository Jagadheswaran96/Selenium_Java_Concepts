package selenium_java;

public class Static {
	
	public static void staticMethod() {
		System.out.println("static method");
	}
	public void nonStaticMethod() {
		System.out.println("non static method");
		staticMethod();
	}
	public void nonStaticMethod2() {
		System.out.println("non static method 2");
		nonStaticMethod();
	} 
	static {
		System.out.println("n number of static block can be present in a class");
	}
	static {
		System.out.println("n number of static block can be present in a class");
	}
	static {
		System.out.println("n number of static block can be present in a class");
	}
	public static void main(String[] args) {
		Static static1=new Static();
		staticMethod();
		static1.nonStaticMethod();
		static1.nonStaticMethod2();
	}

}
