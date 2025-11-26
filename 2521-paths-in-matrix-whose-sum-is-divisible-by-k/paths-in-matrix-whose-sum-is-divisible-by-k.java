class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int MOD = 1_000_000_007;

        int[][] prev = new int[n][k]; // previous row
        int[][] curr = new int[n][k]; // current row

        // Initialize start cell
        prev[0][grid[0][0] % k] = 1;

        // First row: can only come from left
        for (int j = 1; j < n; j++) {
            int val = grid[0][j] % k;
            for (int r = 0; r < k; r++) {
                if (prev[j - 1][r] > 0) {
                    int newR = (r + val) % k;
                    prev[j][newR] = (prev[j][newR] + prev[j - 1][r]) % MOD;
                }
            }
        }

        // Process remaining rows
        for (int i = 1; i < m; i++) {
            // reset curr row
            for (int j = 0; j < n; j++)
                Arrays.fill(curr[j], 0);

            int valFirst = grid[i][0] % k;

            // First column: can only come from top
            for (int r = 0; r < k; r++) {
                if (prev[0][r] > 0) {
                    int newR = (r + valFirst) % k;
                    curr[0][newR] = (curr[0][newR] + prev[0][r]) % MOD;
                }
            }

            // Fill entire row
            for (int j = 1; j < n; j++) {
                int val = grid[i][j] % k;

                for (int r = 0; r < k; r++) {
                    // from top
                    if (prev[j][r] > 0) {
                        int newR = (r + val) % k;
                        curr[j][newR] = (curr[j][newR] + prev[j][r]) % MOD;
                    }
                    // from left
                    if (curr[j - 1][r] > 0) {
                        int newR = (r + val) % k;
                        curr[j][newR] = (curr[j][newR] + curr[j - 1][r]) % MOD;
                    }
                }
            }

            // move curr → prev for next iteration
            int[][] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n - 1][0];
    }
}
