package selenium_java;

import java.util.StringJoiner;

public class StringJoiners {

	public static void main(String[] args) {
		StringJoiner str = new StringJoiner(":", "[", "]");
		str.add("jaga");
		str.add("mani");
		System.out.println(str);
	}

}
