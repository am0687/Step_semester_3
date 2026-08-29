import java.util.Arrays;

public class twoSums {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {}; 
    }

    public static void main(String[] args) {
        twoSums solver = new twoSums();
        
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Input: nums = [2, 7, 11, 15], target = 9");
        System.out.println("Output: " + Arrays.toString(solver.twoSum(nums1, target1)));
        
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Input: nums = [3, 2, 4], target = 6");
        System.out.println("Output: " + Arrays.toString(solver.twoSum(nums2, target2)));
    }
}
