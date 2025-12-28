package selenium_java;

public class FindOddNumbers {

	public static void main(String[] args) {
		int[] number = {0,1,2,3,4,5,6,7,8,9};
		int size = number.length;
		for(int i=0; i<size; i++) {
			if (number[i]%2!=0) {
				System.out.println("odd number is " + number[i]);
			}else {
				System.out.println("even number is " + number[i]);
			}

		}

	}

}
