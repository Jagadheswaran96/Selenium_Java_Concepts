package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindSecondLargestNumberInAnArray {

	//Find 2nd Largest Number in Array using Arrays
	/*public static int findSecondLargestNumber(int[] a,int total) {
		Arrays.sort(a);
		return a[total-2];
	}

	public static void main(String[] args) {
		int[] a = {22,87,66,25,12,49};
		System.out.println("The second largest number is" + " " + findSecondLargestNumber(a, 6));
	}*/

	//Find 2nd Largest Number in Array using Collections
	/*public static int getSecondLargest(Integer[] a, int total){  

		List<Integer> list=Arrays.asList(a);  
		Collections.sort(list);  
		int element=list.get(total-2);  
		return element;  
	}  
	public static void main(String args[]){  
		Integer a[]={1,2,5,6,3,2};  
		Integer b[]={44,66,99,77,33,22,55};  
		System.out.println("Second Largest: "+getSecondLargest(a,6));  
		System.out.println("Second Largest: "+getSecondLargest(b,7));  
	}*/
	
	//simple solution
	public static void main(String[] args) {
		int[] a = {22,3,44,88,99,66,77,11};
		Arrays.parallelSort(a);
		//System.out.println(Arrays.toString(a));
		int secondLargestNumber = a[a.length-2];
		System.out.println(secondLargestNumber);
	}
}
