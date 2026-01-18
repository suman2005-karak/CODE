class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] row = new int[m + 1][n + 1];
        int[][] col = new int[m + 1][n + 1];

        // Build prefix sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i + 1][j + 1] = row[i + 1][j] + grid[i][j];
                col[i + 1][j + 1] = col[i][j + 1] + grid[i][j];
            }
        }

        int maxSize = Math.min(m, n);

        // Try largest size first
        for (int k = maxSize; k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {

                    int target = row[i + 1][j + k] - row[i + 1][j];
                    boolean valid = true;

                    // Check rows
                    for (int r = i; r < i + k && valid; r++) {
                        int sum = row[r + 1][j + k] - row[r + 1][j];
                        if (sum != target) valid = false;
                    }

                    // Check columns
                    for (int c = j; c < j + k && valid; c++) {
                        int sum = col[i + k][c + 1] - col[i][c + 1];
                        if (sum != target) valid = false;
                    }

                    // Check diagonals
                    int d1 = 0, d2 = 0;
                    for (int t = 0; t < k; t++) {
                        d1 += grid[i + t][j + t];
                        d2 += grid[i + t][j + k - 1 - t];
                    }

                    if (valid && d1 == target && d2 == target) {
                        return k;
                    }
                }
            }
        }
        return 1;
    }
}
