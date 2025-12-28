package selenium_java;

import java.util.Scanner;

public class PrintName {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the value :");
		int value = scanner.nextInt();
		scanner.close();
		System.out.println("the value entered is :" + value);
		
		
		
	}

}
