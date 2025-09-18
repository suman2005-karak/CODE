class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // Convert to 1-indexed positions
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;  // move left pointer forward to increase sum
            } else {
                right--; // move right pointer backward to decrease sum
            }
        }

        return new int[] {-1, -1}; // should never happen (guaranteed solution)
    }
}
