class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int area = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int height = grid[i][j];
                if (height > 0) {
                    // Each cube contributes 6 faces, but internal touching surfaces remove 2 per contact
                    area += height * 6 - (height - 1) * 2;

                    // Subtract faces shared with top neighbor
                    if (i > 0) {
                        area -= 2 * Math.min(height, grid[i - 1][j]);
                    }

                    // Subtract faces shared with left neighbor
                    if (j > 0) {
                        area -= 2 * Math.min(height, grid[i][j - 1]);
                    }
                }
            }
        }

        return area;
    }
}
