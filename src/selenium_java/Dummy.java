package selenium_java;

public class Dummy {
	
	int a;
	String b;
	float c;
	long e;
	double f;
	char d;
	boolean g;

	public static void main(String[] args) {
		int array[] = new int [5];
		System.out.println(array);
		Dummy dummy = new Dummy();
		System.out.println("garpage value for int is "+dummy.a);
		System.out.println("garpage value for string is "+dummy.b);
		System.out.println("garpage value for float is "+dummy.c);
		System.out.println("garpage value for long is "+dummy.e);
		System.out.println("garpage value for double is "+dummy.f);
		System.out.println("garpage value for char is "+dummy.d);
		System.out.println("garpage value for boolean is "+dummy.g);
	}

}
