import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        // Min-heap storing {height, x, y}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int ans = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int height = curr[0], x = curr[1], y = curr[2];
            ans = Math.max(ans, height);

            // Reached bottom-right cell
            if (x == n - 1 && y == n - 1) {
                return ans;
            }

            // Mark visited
            if (visited[x][y]) continue;
            visited[x][y] = true;

            // Check all 4 directions
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    pq.offer(new int[]{grid[nx][ny], nx, ny});
                }
            }
        }

        return ans; // Should never reach here
    }
}
