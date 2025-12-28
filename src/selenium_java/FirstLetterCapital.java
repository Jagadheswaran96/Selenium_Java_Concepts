package selenium_java;

import java.util.Arrays;

public class FirstLetterCapital {

	public static void main(String[] args) {
		String message = "i am java";
		System.out.println(message);
		
		char[] characters = message.toCharArray();
		System.out.println(characters);
		
		System.out.println(Arrays.toString(characters));
		
		boolean foundSpace = true;
		for (int i = 0; i < characters.length; i++) {
			if (Character.isLetter(characters[i])) {
				if (foundSpace) {
					characters[i] = Character.toUpperCase(characters[i]);
					foundSpace = false;
				}				
			}
			else {
				foundSpace = true;
			}
		}
		message = String.valueOf(characters);
		System.out.println(message);
	}
}
