class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ones = 0;
        
        // Step 1: Count how many 1's we already have
        for (int x : nums) {
            if (x == 1) ones++;
        }
        
        // If we already have some 1's, we just need to make all others 1
        if (ones > 0) return n - ones;
        
        // Step 2: Try to find smallest subarray whose GCD == 1
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        
        // If no subarray has GCD == 1, impossible
        if (minLen == Integer.MAX_VALUE) return -1;
        
        // Step 3: Once we find one 1, it takes (minLen - 1) to make that happen,
        // and then (n - 1) to make all others 1.
        return (minLen - 1) + (n - 1);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
