package selenium_java;

public class PrintName1000Times {

	public static void main(String[] args) {
		String name = "Jagadheswaran";
		String replace = "J";
		replace = replace.replaceAll("J", "JJJJJJJJJJ");
		replace = replace.replaceAll("J", "JJJJJJJJJJ");
		replace = replace.replaceAll("J", "JJJJJJJJJJ");
		String names = replace.replaceAll("J", name + "\n");
		System.out.println(names);
		int count = names.length();
		System.out.println(count);
	}

}
