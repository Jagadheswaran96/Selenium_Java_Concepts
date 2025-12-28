package selenium_java;

import java.util.Arrays;
import java.util.Collections;

public class SortingElements {

	public static void main(String[] args) {

		String[] value= {"name1","name2","name3","name4"};		
		System.out.println("values are" + "  " + value[1] + " " + value[2]);

		int[] values= {4,2,1,5,3};
		System.out.println(Arrays.toString(values));
		int length=values.length;
		System.out.println(length);		
		//using bubble sort algorithm
		for (int i = 0; i < length - 1; i++) {  // Outer loop runs (n-1) times
		    for (int j = 0; j < length - i - 1; j++) {  // Inner loop reduces after each pass
		        if (values[j] > values[j + 1]) {
		            int temp = values[j];
		            values[j] = values[j + 1];
		            values[j + 1] = temp;
		        }
		    }
		}
		
		System.out.println(Arrays.toString(values));
		
		//using parallel sort built in method
		Arrays.parallelSort(values);
		System.out.println(Arrays.toString(values));
		
		//using sort built in method
		Arrays.sort(values);
		System.out.println(Arrays.toString(values));
		
		//using collections.reverseorder built in method
		Integer[] values1= {4,2,1,5,3};
		Arrays.sort(values1,Collections.reverseOrder());
		System.out.println(Arrays.toString(values1));
	}

}
