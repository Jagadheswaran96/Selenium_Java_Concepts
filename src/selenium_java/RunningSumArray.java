package selenium_java;

public class RunningSumArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = new int[nums.length];
        result[0] = nums[0];
        
        for (int i=1; i<nums.length; i++) {
        	result[i] = result[i-1] + nums[i];
        }
        
        for (int output : result) {
        System.out.print(output+" ");
        }
    }

}
