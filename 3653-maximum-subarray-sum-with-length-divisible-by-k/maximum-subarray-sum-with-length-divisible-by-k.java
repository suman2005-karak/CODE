class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // best min prefix for every remainder group
        long[] best = new long[k];
        for (int i = 0; i < k; i++) best[i] = Long.MAX_VALUE;

        long ans = Long.MIN_VALUE;

        for (int i = 0; i <= n; i++) {
            int r = i % k;

            // we can form a valid subarray only if we already saw a prefix with same remainder
            if (best[r] != Long.MAX_VALUE) {
                ans = Math.max(ans, prefix[i] - best[r]);
            }

            // store minimum prefix sum in this remainder group
            best[r] = Math.min(best[r], prefix[i]);
        }

        return ans;
    }
}
