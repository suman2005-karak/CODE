class Solution {
    public int largestPerimeter(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Traverse from the end
        for (int i = nums.length - 1; i >= 2; i--) {
            // Check triangle condition
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }

        // Step 3: If no valid triangle found
        return 0;
    }
}
