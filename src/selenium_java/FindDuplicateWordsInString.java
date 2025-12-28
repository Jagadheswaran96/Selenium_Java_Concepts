package selenium_java;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateWordsInString
{
	public static void main(String[] args){
		String test = "jagadheswaran delivered the product to jagadheswaran";
		//String test = " ";(to print empty set)
		System.out.println("input : " + test);
		Set<String> duplicates = duplicateWords(test);
		System.out.println("output : " + duplicates);
	}

	public static Set<String> duplicateWords(String input){
		/*
		 * if(input == null || input.isEmpty()){ return Collections.emptySet(); }
		 */
		Set<String> duplicates = new HashSet<>();
		String[] words = input.split(" ");
		Set<String> set = new HashSet<>();
		for(String word : words){ 
			if(!set.add(word)){
				duplicates.add(word);
			}
		}
		return duplicates;
	}
}
