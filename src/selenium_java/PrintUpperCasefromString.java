package selenium_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintUpperCasefromString {

	public static void main(String[] args) {

		String input = "Coding Task In Infosys Interview";
		String string = input.replaceAll(" ", "");

		Set<Character> hashSet = new HashSet<>();
		List<Object> list = new ArrayList<>();

		for (int i=0; i<string.length(); i++) {
			char ch = string.charAt(i);
			if (!hashSet.contains(ch)) {
				hashSet.add(ch);
				if (Character.isUpperCase(ch)) {
					list.add(ch);
					//list.add(Character.toLowerCase(ch));
				}
			}			
		}
		System.out.println(hashSet);
		System.out.println(list);

	}

}
