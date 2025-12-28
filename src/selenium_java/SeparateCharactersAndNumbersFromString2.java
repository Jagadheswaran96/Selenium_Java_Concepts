package selenium_java;

public class SeparateCharactersAndNumbersFromString2 {

	public static void main(String[] args) {
		String num = "jagadhes2459";
		System.out.println(num.replaceAll("[1-9]", ""));
		System.out.println(num.replaceAll("[a-z]", ""));
		System.out.println(num.replaceAll("[a1-z9]", ""));
	}

}
