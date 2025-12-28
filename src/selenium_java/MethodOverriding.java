package selenium_java;

public class MethodOverriding extends MethodOverloading{
	
	public static void MethodOverload(String a) {
		System.out.println("Override one");		
	}
	public static void MethodOverload(String a, String b) {
		System.out.println("Override two");
	}
	public static void MethodOverload(String a, String b, String c) {
		System.out.println("Override three");
	}

	public static void main(String[] args) {
		MethodOverloading.MethodOverload("one");
		MethodOverloading.MethodOverload("one", "two");
		MethodOverloading.MethodOverload("one", "two", "three");
		//MethodOverriding.MethodOverload("jagadhes");
	}

}
