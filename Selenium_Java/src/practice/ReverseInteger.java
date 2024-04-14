package practice;

class ReverseInteger {
	    // Function to reverse the number
	    static int reverse(int n){ 
	      int rev = 0; // reversed number
	      int rem;   // remainder 
	      while(n>0){  
	        rem = n%10;
	        rev = (rev*10) + rem;
	        n = n/10;
	      }
	      return rev;
	    }
	   // Driver Function
	    public static void main (String[] args) {
	        int n = 12345;
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
