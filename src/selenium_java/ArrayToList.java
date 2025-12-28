package selenium_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToList {
	
	//there are multiple way as below:
	/*
	 * 1.Using Arrays.asList() Method 2.Using Collections.addAll() Method 3.Using
	 * Java 8 Stream API 4.Using Guava Lists.newArrayList() Method
	 */
	//this is using native method
	public static void main(String args[]) {   
	//creating an array   
		String array[] = { "Golf", "Soccer", "Baseball", "Volleyball", "Tennis", "Badminton", "Rugby", "Archery", "Skiing"};   
	//prints the array before conversion  
	System.out.println("Array before conversion: "+ Arrays.toString(array)); 
	//calling the generic function that converts Array into List  
	List<String> list = ArrayToListConversion(array);   
	//print the List   
	System.out.println("Array as List: " + list);
	System.out.println("Array as List using method 2: "+ Arrays.asList(array)); 
	}       
	//creating a generic function that converts the Array into List  
	public static <T> List<T> ArrayToListConversion(T array[]) {   
	//creating the constructor of the List interface  
	List<T> list = new ArrayList<>();   
	//using for-each loop to iterate over the array  
	for (T t : array)   
	{   
	//adding each element to the List  
	list.add(t);   
	}   
	//returns the list converted into Array  
	return list;   
	}    
}
