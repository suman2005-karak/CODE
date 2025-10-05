import java.util.*;

class Solution {
    private int m, n;
    private int[][] heights;
    private final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // Start DFS from Pacific borders (top row & left column)
        for (int i = 0; i < m; i++) dfs(i, 0, pacific, heights[i][0]);
        for (int j = 0; j < n; j++) dfs(0, j, pacific, heights[0][j]);
        
        // Start DFS from Atlantic borders (bottom row & right column)
        for (int i = 0; i < m; i++) dfs(i, n - 1, atlantic, heights[i][n - 1]);
        for (int j = 0; j < n; j++) dfs(m - 1, j, atlantic, heights[m - 1][j]);
        
        // Cells that can reach both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    
    private void dfs(int r, int c, boolean[][] visited, int prevHeight) {
        // Out of bounds / visited / cannot flow uphill
        if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c] || heights[r][c] < prevHeight)
            return;
        
        visited[r][c] = true;
        for (int[] d : dirs) {
            dfs(r + d[0], c + d[1], visited, heights[r][c]);
        }
    }
}
