package selenium_java;

import java.util.HashMap;

public class FindSumArrayIndex {
    public static void main(String[] args) {
        int[] arr = {2, 7, 3, 4, 5, 6, 7};
        int target = 9;
        findSubarrayWithSum(arr, target);
    }

    public static void findSubarrayWithSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum == target) {
                System.out.println("Subarray found from index 0 to " + i);
                return;
            }

            if (map.containsKey(currentSum - target)) {
                System.out.println("Subarray found from index " + (map.get(currentSum - target) + 1) + " to " + i);
                return;
            }

            map.put(currentSum, i);
        }

        System.out.println("No subarray with the given sum found.");
    }
}
