package selenium_java;

class ReverseInteger {
	
	static int reverse(int n){ 
		int reverse = 0; // reversed number
		int remainder;   // remainder 
		while(n>0){  
			remainder = n%10;
			reverse = (reverse*10) + remainder;
			n = n/10;
		}
		return reverse;
	}

	public static void main (String[] args) {
		int n = 100;

		System.out.print("Reversed Number is "+ reverse(n));
		System.out.println();

		//2nd method
		StringBuilder builder = new StringBuilder();
		builder.append(n);
		System.out.println(builder.reverse());

		//3rd method
		StringBuffer buffer = new StringBuffer();
		buffer.append(n);
		System.out.println(buffer.reverse());
	}	    

}
