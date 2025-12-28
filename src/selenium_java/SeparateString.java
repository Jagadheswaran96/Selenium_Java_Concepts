package selenium_java;

public class SeparateString {
	
	public static void separateValue(String input) {
		StringBuffer digit = new StringBuffer();
		StringBuffer letter = new StringBuffer();
		for(int i=0; i<input.length(); i++) {
			if(Character.isDigit(input.charAt(i))) {
				digit.append(input.charAt(i));
			}else
				letter.append(input.charAt(i));
		}
		System.out.println(digit);
		System.out.println(letter);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String value = "T5G4Y7D9";
		separateValue(value);
		

	}

}
