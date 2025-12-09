class Solution {
    public int specialTriplets(int[] nums) {
        final long MOD = 1_000_000_007L;
        int n = nums.length;

        int maxVal = 100000;
        int[] right = new int[maxVal + 1];
        for (int x : nums) right[x]++;

        int[] left = new int[maxVal + 1];

        long ans = 0;

        for (int j = 0; j < n; j++) {
            int mid = nums[j];
            right[mid]--;   // remove current j from right

            int target = mid * 2;
            if (target <= maxVal) {
                long leftCount = left[target];     // nums[i] == 2 * nums[j]
                long rightCount = right[target];   // nums[k] == 2 * nums[j]

                ans = (ans + (leftCount * rightCount) % MOD) % MOD;
            }

            left[mid]++;  // add current j to left
        }

        return (int) ans;
    }
}
