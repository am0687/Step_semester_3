import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Sum {
    public int[][] threeSum(int[] nums) {
        // Step 1: Sort the array to enable the two-pointer technique 
        // and make duplicate detection straightforward.
        Arrays.sort(nums);
        List<int[]> resultList = new ArrayList<>();
        int n = nums.length;
        
        // Iterate up to the third-to-last element
        for (int i = 0; i < n - 2; i++) {
            // Optimization: If the smallest number is positive, 
            // no three numbers can sum to zero.
            if (nums[i] > 0) break;
            
            // Skip duplicate values for the first number (nums[i])
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Step 2: Use two pointers moving inward
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Valid triplet found
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});
                    
                    // Skip duplicates for the second number (left pointer)
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for the third number (right pointer)
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Move both pointers inward to look for the next valid pair
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Sum is too small, we need a larger number
                    left++;
                } else {
                    // Sum is too large, we need a smaller number
                    right--;
                }
            }
        }
        
        // Convert the dynamic list to a 2D array to match the requested signature
        return resultList.toArray(new int[resultList.size()][]);
    }
}