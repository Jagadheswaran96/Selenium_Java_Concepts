package selenium_java;

public class ReverseString {

	public static void main(String[] args) {
		String name = "12345";
		char array[] = name.toCharArray();
		int size = name.length();
		System.out.println(size);
		for(int i=size-1;i>=0;i--) {
			System.out.print(array[i]);
		}

		System.out.println();

		for(int i=name.length()-1; i>=0; i--) {
			System.out.print(name.charAt(i));
		}

		System.out.println();

		StringBuffer a = new StringBuffer("12345");
		System.out.println(a.reverse() + " - reversed using string buffer");

		StringBuilder string = new StringBuilder("12345");
		string.append(string);
		System.out.println(string.reverse() + " - reversed using string builder");
		
		System.out.println("Reversed String: " + reverse("Hello, World!"));

	}
	//using a recursive method
	public static String reverse(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

}