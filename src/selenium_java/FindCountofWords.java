package selenium_java;

public class FindCountofWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String message = "Automation Tester Selenium";
		int length = message.length();
		int count = 1;
		for (int j = 0; j < length; j++) {			
		if((message.charAt(j)==' ') && (message.charAt(j+1)!=' ')){
			count++;
		}
		}
		System.out.println(count);
		
		//using split method
		String words = "One Two Three Four";
		int countWords = words.split("\\s").length;
		System.out.println(countWords);
	}
}
