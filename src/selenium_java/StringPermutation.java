package selenium_java;

import java.util.HashSet;
import java.util.Set;

public class StringPermutation {
    public static void main(String[] args) {
        String input = "world";
        Set<String> result = new HashSet<>();
        generatePermutations(input, "", result);

        // Print all unique permutations
        for (String perm : result) {
            System.out.println(perm);
        }
        System.out.println(result.size());
    }

    public static void generatePermutations(String string, String prefix, Set<String> result) {
        if (string.isEmpty()) {
            result.add(prefix);
            return;
        }

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            String remaining = string.substring(0, i) + string.substring(i + 1);
            generatePermutations(remaining, prefix + ch, result);
        }
    }
}
