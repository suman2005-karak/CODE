class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 1;

        // 1️⃣ Strictly increasing
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }
        if (i == 1 || i == n) return false;

        // 2️⃣ Strictly decreasing
        int decStart = i;
        while (i < n && nums[i] < nums[i - 1]) {
            i++;
        }
        if (i == decStart || i == n) return false;

        // 3️⃣ Strictly increasing again
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }

        return i == n;
    }
}
