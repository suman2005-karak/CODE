class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;

        for (int op = 0; op < k; op++) {
            int minIndex = 0;

            // find first minimum element
            for (int i = 1; i < n; i++) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }

            // multiply the minimum element
            nums[minIndex] *= multiplier;
        }

        return nums;
    }
}
