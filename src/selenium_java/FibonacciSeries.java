package selenium_java;

public class FibonacciSeries {
	
	public static void main(String args[]) {
		
		// Fibonacci series is nothing but print the sum of previous two numbers
		int previous = 0, current = 1;
		int next;
		int count = 10; // Number of Fibonacci numbers to be printed		
		System.out.println(previous + " " + current); // To print 0 and 1
		
		for (int i = 2; i < count; i++) { // loop starts from 2. We have already printed 0 and 1 in the previous step
			next = previous + current;
			System.out.print(next + " ");
			previous = current;
			current = next;
			//if (next%2!=0) {
			System.out.print("prime fibonacci numbers are " + next);
			//}
		}
	}
}