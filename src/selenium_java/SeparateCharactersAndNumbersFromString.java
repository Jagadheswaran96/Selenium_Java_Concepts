package selenium_java;

public class SeparateCharactersAndNumbersFromString {

	static void splitString(String str){
		StringBuffer alphabetic = new StringBuffer();
		StringBuffer number = new StringBuffer();
		StringBuffer specialCharacter = new StringBuffer();
		for (int i=0; i<str.length(); i++){
			if (Character.isDigit(str.charAt(i)))
				number.append(str.charAt(i));
			else if(Character.isLetter(str.charAt(i)))
				alphabetic.append(str.charAt(i));
			else
				specialCharacter.append(str.charAt(i));
		}
		System.out.println(alphabetic);
		System.out.println(number);
		System.out.println(specialCharacter);
	}
	public static void main(String args[]){
		String str = "jagadhes@mani#eesa123$vishnu";
		splitString(str);
	}
}