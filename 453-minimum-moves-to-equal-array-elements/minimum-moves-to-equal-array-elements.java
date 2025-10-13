class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        long sum = 0; // use long to avoid overflow
        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }
        return (int)(sum - (long)nums.length * min);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minMoves(new int[]{1, 2, 3})); // Output: 3
        System.out.println(sol.minMoves(new int[]{1, 1, 1})); // Output: 0
    }
}
