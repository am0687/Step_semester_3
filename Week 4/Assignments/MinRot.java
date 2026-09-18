class MinRot {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        // Loop terminates when left == right, pointing exactly to the minimum.
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Compare the middle element to the rightmost element in our window
            if (nums[mid] > nums[right]) {
                // If mid is greater than the right end, the array "drops" somewhere 
                // to the right of mid. The minimum must be strictly to the right.
                left = mid + 1;
            } else {
                // If mid is less than or equal to the right end, the right half 
                // is properly sorted. The minimum is either at mid or to its left.
                right = mid;
            }
        }
        
        return nums[left];
    }
}