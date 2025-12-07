class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int total = n * n;

        long xorAll = 0;

        // XOR all numbers from 1 to n^2
        for (int i = 1; i <= total; i++) xorAll ^= i;

        // XOR with all numbers in the grid
        for (int[] row : grid) {
            for (int val : row) xorAll ^= val;
        }

        // xorAll = a ^ b  (repeating ^ missing)

        // Find rightmost set bit to separate into two groups
        long rightMostBit = xorAll & -xorAll;

        long bucket1 = 0, bucket2 = 0;

        // Divide 1..n^2 into two xor buckets
        for (int i = 1; i <= total; i++) {
            if ((i & rightMostBit) != 0) bucket1 ^= i;
            else bucket2 ^= i;
        }

        // Divide grid values into same two buckets
        for (int[] row : grid) {
            for (int val : row) {
                if ((val & rightMostBit) != 0) bucket1 ^= val;
                else bucket2 ^= val;
            }
        }

        // Now bucket1 and bucket2 are the two numbers — but we need to identify which is repeated
        int a = 0, b = 0;
        int count1 = 0;

        // Count occurrences of bucket1
        for (int[] row : grid) {
            for (int val : row) {
                if (val == bucket1) count1++;
            }
        }

        // If bucket1 occurs twice => bucket1 = repeating
        if (count1 == 2) {
            a = (int) bucket1;
            b = (int) bucket2;
        } else {
            a = (int) bucket2;
            b = (int) bucket1;
        }

        return new int[]{a, b};
    }
}
