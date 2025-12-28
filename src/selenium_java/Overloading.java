package selenium_java;

public class Overloading {
	
	public String name(String name) {
		return name;
	}
	public String name(String name, String name2) {
		return name+name2;
	}

	public static void main(String[] args) {
		
		Overloading overloading=new Overloading();
		System.out.println("name is" + overloading.name("jagadhes"));
		System.out.println("names are" + overloading.name("jagadhes", "selenium"));
		
	}

}
