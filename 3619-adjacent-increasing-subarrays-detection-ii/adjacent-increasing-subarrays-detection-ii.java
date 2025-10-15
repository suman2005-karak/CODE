class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int maxK = 0;           // Maximum k value found
        int previousLength = 0; // Length of previous increasing sequence
        int currentLength = 0;  // Length of current increasing sequence
        int n = nums.size();    // Use size() for List instead of length
        
        for (int i = 0; i < n; i++) {
            // Extend current increasing sequence
            currentLength++;
            
            // Check if sequence breaks (end of array or non-increasing)
            // Use get(i) to access List elements instead of array indexing
            if (i == n - 1 || nums.get(i) >= nums.get(i + 1)) {
                // Update maxK considering both scenarios:
                // 1. Split current sequence in half
                // 2. Use min of previous and current sequences
                maxK = Math.max(maxK, 
                               Math.max(currentLength / 2, 
                                       Math.min(previousLength, currentLength)));
                
                // Move current to previous, reset current
                previousLength = currentLength;
                currentLength = 0;
            }
        }
        
        return maxK;
    }
}
