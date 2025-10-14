import java.util.*;

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        boolean[] inc = new boolean[n];

        // Check if subarray of length k starting at i is strictly increasing
        for (int i = 0; i + k <= n; i++) {
            boolean increasing = true;
            for (int j = i + 1; j < i + k; j++) {
                if (nums.get(j) <= nums.get(j - 1)) {
                    increasing = false;
                    break;
                }
            }
            inc[i] = increasing;
        }

        // Check if there are two adjacent strictly increasing subarrays
        for (int i = 0; i + 2 * k <= n; i++) {
            if (inc[i] && inc[i + k]) {
                return true;
            }
        }

        return false;
    }
}
