package selenium_java;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		
	/*	ArrayList<String> arrayList=new ArrayList<String>();
		boolean arr=arrayList.add("string 1");
		boolean arr2=arrayList.add("string 2");
		boolean arr3=arrayList.add("string 3");
		System.out.println(arr);*/
		
		ArrayList<String> arrayList=new ArrayList<String>();
		arrayList.add("string 1");
		arrayList.add("string 2");
		arrayList.add("string 3");
		arrayList.add("");
		arrayList.add("");
		arrayList.add(0, null);
		arrayList.remove(1);
		arrayList.add("string 4");
		arrayList.add(2, null);
		System.out.println(arrayList.contains("string 2"));
		System.out.println(arrayList);
		
	}
}
