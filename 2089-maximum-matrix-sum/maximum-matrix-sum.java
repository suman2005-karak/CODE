class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sumAbs = 0;
        int negCount = 0;
        int minAbs = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int val : row) {
                if (val < 0) negCount++;
                sumAbs += Math.abs(val);
                minAbs = Math.min(minAbs, Math.abs(val));
            }
        }

        // If number of negatives is even, all can be made positive
        if (negCount % 2 == 0) {
            return sumAbs;
        }

        // Otherwise, one smallest absolute value stays negative
        return sumAbs - 2L * minAbs;
    }
}
