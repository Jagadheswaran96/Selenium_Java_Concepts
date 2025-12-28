package selenium_java;

public class FindSecondLargestNumberInAnArray {

	//Find 2nd Largest Number in Array using Arrays
	/*public static int findSecondLargestNumber(int[] a,int total) {
		Arrays.sort(a);
		return a[total-2];
	}

	public static void main(String[] args) {
		int[] a = {22,87,66,25,12,49};
		System.out.println("The second largest number is" + " " + getSecondLargest(a, 6));
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
	/*public static void main(String[] args) {
		int[] a = {22,3,44,88,99,66,77,11};
		Arrays.parallelSort(a);
		//System.out.println(Arrays.toString(a));
		int secondLargestNumber = a[a.length-2];
		System.out.println(secondLargestNumber);
	}*/
	
	public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        int secondLargest = findSecondLargest(arr);
        System.out.println("The second largest element is: " + secondLargest);
    }

    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }
}
