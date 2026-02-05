class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                int move = nums[i];
                int newIndex = ((i + move) % n + n) % n; // handles circular + negatives
                result[i] = nums[newIndex];
            }
        }
        return result;
    }
}
