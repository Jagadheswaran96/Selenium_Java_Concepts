package selenium_java;

public class ReverseSkipSpecial {

	public static void main(String[] args) {
		
		String input = "$ABC#123@PQ";
		char[] chars = input.toCharArray();
		int left = 0;
		int right = chars.length-1;
		while (left < right) {
			if (!Character.isLetterOrDigit(chars[left])) {
				left++;
			} else if (!Character.isLetterOrDigit(chars[right])) {
				right--;
			} else {
				char temp = chars[left];
				chars[left] = chars[right];
				chars[right] = temp;
				left++;
				right--;
			}
		}
		System.out.println(new String(chars));
		System.out.println(chars);
	}

}
