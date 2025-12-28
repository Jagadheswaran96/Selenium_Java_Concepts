package selenium_java;

import java.util.Arrays;

public class ReverseWordInString {

	public static void main(String[] args) {
		String input = "reverse a word";
        String s[] = input.split(" ");
        System.out.println(Arrays.toString(s));
        String res = "";
        for (int i = s.length - 1; i >= 0; i--) {
            res += s[i] + " ";
        }
        System.out.println(res);
        System.out.println(res.substring(0, res.length() - 1));

	}

}
