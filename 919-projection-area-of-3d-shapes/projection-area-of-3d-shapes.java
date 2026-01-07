class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xy = 0, yz = 0, zx = 0;

        // XY-plane (top view)
        for (int i = 0; i < n; i++) {
            int rowMax = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    xy++;
                }
                rowMax = Math.max(rowMax, grid[i][j]);
            }
            yz += rowMax; // YZ-plane (front view)
        }

        // ZX-plane (side view)
        for (int j = 0; j < n; j++) {
            int colMax = 0;
            for (int i = 0; i < n; i++) {
                colMax = Math.max(colMax, grid[i][j]);
            }
            zx += colMax;
        }

        return xy + yz + zx;
    }
}
