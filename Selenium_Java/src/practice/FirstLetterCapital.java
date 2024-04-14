package practice;

public class FirstLetterCapital {

	public static void main(String[] args) {
		String message = "i am java";
		char[] characters = message.toCharArray();
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
