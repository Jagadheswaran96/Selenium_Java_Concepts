package selenium_java;

public class SeparateCharactersAndNumbersFromString3 {
	
	public static void separator(String value) {
		StringBuffer numberBuffer = new StringBuffer();
		StringBuffer characterBuffer = new StringBuffer();
		StringBuffer alphabeticalBuffer = new StringBuffer();
		for (int i = 0; i < value.length(); i++) {
			if (Character.isAlphabetic(value.charAt(i)))
				alphabeticalBuffer.append(value.charAt(i));
			else if(Character.isDigit(value.charAt(i)))
				numberBuffer.append(value.charAt(i));
			else
				characterBuffer.append(value.charAt(i));
 		}
		System.out.println(numberBuffer);
		System.out.println(characterBuffer);
		System.out.println(alphabeticalBuffer);
	}	
	public static void main(String[] args) {
		String value = "qwerty!@#$%%^123456";
		separator(value);
	}
}