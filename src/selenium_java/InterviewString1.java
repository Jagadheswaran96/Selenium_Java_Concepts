package selenium_java;

public class InterviewString1 {
	
	public static String compressString(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                result.append(input.charAt(i - 1));
                if (count > 1) {
                    result.append(count);
                }
                count = 1; // Reset the count
            }
        }

        // Append the last character and its count
        result.append(input.charAt(input.length() - 1));
        if (count > 1) {
            result.append(count);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "aaAAbbCCddd";
        String compressed = compressString(input);
        System.out.println(compressed); // Output: a2A2b2C2d3
    }

//	public static void main(String[] args) {
//
//			String input = "aaAAbbCCddd";
//			
//			for (int i = 0; i < input.length(); i++) {
//				if () {
//					
//				}
//				
//			}
//	}

}
