class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        // Find min and max in array
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        // After operation, difference can shrink by 2*k
        int diff = max - min - 2 * k;
        
        return Math.max(0, diff); // cannot be negative
    }
}
