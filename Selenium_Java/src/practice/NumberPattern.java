package practice;

public class NumberPattern {

	public static void main(String[] args) {
		/*
		 * for (int x = 1; x <= 5; x++) { for (int y = 1; y <= x; y++) {
		 * System.out.print(y+" "); //System.out.print("*"); } System.out.println(); }
		 */
		int rows = 5; // You can change the number of rows here
		for (int i = 1; i <= rows; i++) {
			// Printing spaces
			for (int j = 1; j <= rows - i; j++) {
				System.out.print(" ");
			}
			// Printing stars
			for (int k = 1; k <= i * 2 - 1; k++) {
				System.out.print(k);
			}
			// Move to the next line
			System.out.println();
		}
	}
}
