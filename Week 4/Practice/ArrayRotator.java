import java.util.Arrays;

public class ArrayRotator {
    public int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        
        k = k % nums.length;
        int[] newArray = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i]; 
        }
        
        return newArray; 
    }

    public static void main(String[] args) {
        ArrayRotator rotator = new ArrayRotator();
        
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Input: nums = [1, 2, 3, 4, 5, 6, 7], k = 3");
        System.out.println("Output: " + Arrays.toString(rotator.rotateArray(nums1, k1)));
        
        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.println("Input: nums = [1, 2], k = 3");
        System.out.println("Output: " + Arrays.toString(rotator.rotateArray(nums2, k2)));
    }
}