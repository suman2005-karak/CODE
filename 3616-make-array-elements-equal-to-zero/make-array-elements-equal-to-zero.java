class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // Try moving left (-1) and right (+1)
                if (simulate(nums.clone(), i, -1)) count++;
                if (simulate(nums.clone(), i, 1)) count++;
            }
        }

        return count;
    }

    private boolean simulate(int[] arr, int curr, int dir) {
        int n = arr.length;
        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += dir; // move same direction
            } else {
                arr[curr]--; // decrement
                dir *= -1;   // reverse direction
                curr += dir; // move one step in new direction
            }
        }

        // Check if all became 0
        for (int x : arr) {
            if (x != 0) return false;
        }
        return true;
    }
}
