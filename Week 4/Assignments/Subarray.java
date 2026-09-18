import java.util.HashMap;
import java.util.Map;

class Subarray {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        
        // Map stores (Prefix Sum -> Frequency of that Prefix Sum)
        Map<Integer, Integer> prefixSumFrequencies = new HashMap<>();
        
        // Base case: A prefix sum of 0 has occurred exactly 1 time (the empty prefix).
        // This is required to correctly count subarrays that start from index 0 and sum to k.
        prefixSumFrequencies.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            
            // The logic: currentSum - earlierPrefixSum = k
            // Therefore: earlierPrefixSum = currentSum - k
            // We check how many times we've seen this exact earlierPrefixSum.
            int requiredPrefix = currentSum - k;
            if (prefixSumFrequencies.containsKey(requiredPrefix)) {
                count += prefixSumFrequencies.get(requiredPrefix);
            }
            
            // Add the current sum to our map, or increment its existing count
            prefixSumFrequencies.put(currentSum, prefixSumFrequencies.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}