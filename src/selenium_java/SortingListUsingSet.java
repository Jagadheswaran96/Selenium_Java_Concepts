package selenium_java;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SortingListUsingSet {

	public static void main(String args[]) { 
		int[] count = {11, 22, 33, 44, 66, 55};
		Set<Integer> hset = new HashSet<Integer>();
		try{
			for(int i = 0; i < count.length; i++){
				hset.add(count[i]);
			}
			System.out.println(hset);

			TreeSet<Integer> treeset = new TreeSet<Integer>(hset);
			System.out.println("The sorted list is:");
			System.out.println(treeset);

			Arrays.sort(count);
			System.out.println(count); // it prints memory location reference
			System.out.println(Arrays.toString(count));

		} catch(Exception e){
			// e.printStackTrace();
		}
	}
}