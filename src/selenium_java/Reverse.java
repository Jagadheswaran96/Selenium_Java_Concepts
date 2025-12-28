package selenium_java;

public class Reverse {

	public static void main(String[] args) {

		String value = "Cognizant";
		int size = value.length();
		for (int i = size-1; i >=0; i--) {
			char value2 = value.charAt(i);
			System.out.print(value2);
		}

	}

}
