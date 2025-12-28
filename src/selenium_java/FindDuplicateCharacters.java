package selenium_java;

public class FindDuplicateCharacters {

	public static void main(String[] args) {  
		String string1 = "Great responsibility";  
		int count;  

		//Converts given string into character array  
		char string[] = string1.toCharArray();  

		System.out.println("Duplicate characters in a given string: ");  
		//Counts each character present in the string  
		for(int i = 0; i <string.length; i++) {  
			count = 1;  
			for(int j = i+1; j <string.length; j++) {  
				if(string[i] == string[j] && string[i] != ' ') {  
					count++;  
					//Set string[j] to 0 to avoid printing visited character  
					string[j] = '0';  
				}  
			}  
			//A character is considered as duplicate if count is greater than 1  
			if(count > 1 && string[i] != '0')  
				System.out.print(string[i]);  
		}
		
		System.out.println();
		
		for(int i = 0; i < string1.length(); i++) {  
            for(int j = i + 1; j < string1.length(); j++) {  
                if(string1.charAt(i) == string1.charAt(j) && string[i] != '0')
                    System.out.print(string[i]);
            }  
        } 
	}  
} 

