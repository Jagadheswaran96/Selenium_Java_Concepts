package selenium_java;

public class FindCountofCharacters {

	public static void main(String[] args) {
		String text = "java";
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			if(text.charAt(i) != ' ')    
                count++;    
		}
		System.out.println("count is:" + " " + count);
	}

}
