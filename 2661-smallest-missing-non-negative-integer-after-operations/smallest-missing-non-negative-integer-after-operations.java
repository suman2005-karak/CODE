import java.util.*;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        // Map to count frequency of each remainder (mod value)
        Map<Integer, Integer> remainderCount = new HashMap<>();
        
        for (int num : nums) {
            // Normalize remainder to [0, value-1]
            int rem = ((num % value) + value) % value;
            remainderCount.put(rem, remainderCount.getOrDefault(rem, 0) + 1);
        }
        
        int mex = 0;
        while (true) {
            int rem = mex % value;
            // If remainder count exists and still usable, decrement and move ahead
            if (remainderCount.getOrDefault(rem, 0) > 0) {
                remainderCount.put(rem, remainderCount.get(rem) - 1);
                mex++;
            } else {
                break;
            }
        }
        
        return mex;
    }
}
