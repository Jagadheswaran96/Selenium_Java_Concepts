package selenium_java;

public class MethodOverloading {
	
	public static void MethodOverload(String a) {
		System.out.println("a = " + a);		
	}
	public static void MethodOverload(String a, String b) {
		System.out.println("a = " + a + " " + "b = " + b);
	}
	public static void MethodOverload(String a, String b, String c) {
		System.out.println("a = " + a + " " + "b = " + b + " " + "c =" + c);
	}
	
	//static methods can be accessed into another static method without create an object
	public static void main(String[] args) {
		MethodOverloading.MethodOverload("Jagadhes");
		MethodOverloading.MethodOverload("Jagadhes","Siva");
		MethodOverloading.MethodOverload("Jagadhes","Siva","JASI");
	}

}

