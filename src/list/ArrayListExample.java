package list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
	
//	Arraylist class is implementation for list interface.
//	Duplicate values are allowed
//	Insertion order is maintained
//	Null is not allowed.
//	Underlying DC is resizable array or growable array.
//	Can use heterogeneous objects like int, string if generics are is not sued.
//	Arraylist is not synchronized so it is not thread safe.
//	Default capacity is 10.
//	Fill ratio or load factor is 1% or 100%.
//	Growth rate is current size + current size/2.
//	It implements random access, serializable and cloneable interfaces.
//		Serializable is nothing but changing the object to sharable in network
//	Best suited for search opeartions but not for insertion and deletion.
//		a)Becoz, when we insert new element to arraylist, it will create a another arraylist with new element and old 
//		arraylist goes to carpage memory
//		b) when we delete, it will remove that element and re-arrange the places of remaining element so it is considered as
//		time consuming opeartion
		

	public static void main(String[] args) {
		
		List<String> list=new ArrayList<>();
		ArrayList<String> list2=new ArrayList<>();
		list.add("name");
		System.out.println(list);
		list2.add("name");
		System.out.println(list2);
	}

}
