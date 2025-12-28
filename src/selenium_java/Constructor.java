package selenium_java;

public class Constructor {

	//	1. Constructor is a block of code that initialize the newly created object
	//	2. Constructor name must be same as its class name
	//	3. must not have explicit return type
	//	4. cannot be abstract, static, final, synchronized
	//	5. type of Constructor -> default, no arguments, parameterized

	//	List of wrapper classes in Java
	//	Integer: Wraps an int value.
	//	Long: Wraps a long value.
	//	Double: Wraps a double value.
	//	Boolean: Wraps a boolean value.
	//	Character: Wraps a char value.
	//	Byte: Wraps a byte value.
	//	Short: Wraps a short value.
	//	Float: Wraps a float value.
	
	/////// Note: When there are more methods with same name with diff arguments, 
	//it will pick only argumented method(which has more arguments) not every methods

	//	1) default constructor -> it will provide values like 0, null, etc... based on the type

	String name;
	int number;
	long number2;
	double number3;
	boolean result;
	char number4;
	byte number5;
	short number6;
	float number7;
	Integer number8;
	Long number9;
	Double number10;
	Boolean result2;
	Character number11;
	Byte number12;
	Short number13;
	Float number14;

	//	2) No arguments constructor -> User-defined constructor

	int length;
	String text;

	Constructor() {
		length=10;
		text="User-defined constructor without argument";
	}
	
	// 3) Parameterized constructor -> User-defined constructor with arguments
	
	int area;
	String areaname;

	Constructor(int count, String name) {
		area=count;
		areaname=name;
	}
	
	public void parameterizedConstructor() {
		System.out.println(area+areaname);
	}

	public static void main(String[] args) {
		Constructor constructor = new Constructor(100, "India");
		System.out.println(constructor.name); 
		System.out.println(constructor.number); 
		System.out.println(constructor.number2);
		System.out.println(constructor.number3);
		System.out.println(constructor.result);
		System.out.println(constructor.number4); 
		System.out.println(constructor.number5);
		System.out.println(constructor.number6);
		System.out.println(constructor.number7);
		System.out.println(constructor.number8); 
		System.out.println(constructor.number9);
		System.out.println(constructor.number10);
		System.out.println(constructor.result2);
		System.out.println(constructor.number11); 
		System.out.println(constructor.number12);
		System.out.println(constructor.number13);
		System.out.println(constructor.number14);
		System.out.println(constructor.length);
		System.out.println(constructor.text);
		constructor.parameterizedConstructor();

	}
}