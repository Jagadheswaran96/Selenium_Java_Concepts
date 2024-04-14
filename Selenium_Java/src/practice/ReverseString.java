package practice;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Software Testing Material";
		char array[] = name.toCharArray();
		int size = name.length();
		
		for(int i=size-1;i>=0;i--) {
			System.out.print(array[i]);
		}
		System.out.println();
		
		StringBuffer a = new StringBuffer("Software Testing Material");
		System.out.println(a.reverse());
		System.out.println();
		
		String input="Software Testing Material";
		StringBuilder input1 = new StringBuilder();
		input1.append(input);
		input1=input1.reverse();
		for (int i=0;i<input1.length();i++)
		System.out.print(input1.charAt(i));
	}

}