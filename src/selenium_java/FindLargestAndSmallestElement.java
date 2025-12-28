package selenium_java;

import java.util.Arrays;

public class FindLargestAndSmallestElement {

	public static void main(String[] args) {
		int[] a = {54,-48,79,31,69};
		int size = a.length;
		System.out.println("Size is" + " " + size);
		int largest = a[0];
		int smallest = a[0];
		for (int i = 1; i < size; i++) {
			if (a[i]>largest) {
				largest = a[i];
			} else if(a[i]<smallest){
				smallest = a[i];
			}
		}
		System.out.println("Given an array is" + " " + Arrays.toString(a));
		System.out.println("Largest number is" + " " + largest);
		System.out.println("Smallest number is" + " " + smallest);
		
		Arrays.parallelSort(a);
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println(a[0]);
		System.out.println(a[a.length-1]);
	}

}
