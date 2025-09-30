class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n; // already valid

        int i = 2; // pointer for placement
        for (int j = 2; j < n; j++) {
            if (nums[j] != nums[i - 2]) { // check if more than 2 duplicates
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
