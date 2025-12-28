package selenium_java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountWordsUsingHashMap {

	public static void main(String[] args) {
		CountWordsUsingHashMap hashMap = new CountWordsUsingHashMap();
		hashMap.countWords("Count 0-9 words using HashMap");
	}
	
	public void countWords(String input) {
		input = input.replaceAll("[^a-zA-Z ]", "");
		System.out.println(input);
        String[] words = input.split("\\s+");
        System.out.println("It is the default toString() representation of the array -> " + words);
        System.out.println(Arrays.toString(words));
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> hashMap = new HashMap<>();
        for(String word:words) {
        	map.put(word,0);
        	hashMap.put(word, hashMap.getOrDefault(word, 0)+1);
        }
        System.out.println(map);
        System.out.println(map.entrySet());
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.size());
        map.clear();
        System.out.println(map);
        System.out.println(hashMap);
        System.out.println(hashMap.entrySet());
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.values());
        System.out.println(hashMap.size());
        for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
        	System.out.println(entry.getKey());
        	System.out.println(entry.getValue());
        	System.out.println(entry.getKey()+entry.getValue());
        }
	}

}
