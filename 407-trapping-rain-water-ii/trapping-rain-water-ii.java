import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m < 3 || n < 3) return 0; // no space to trap water

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        // Step 1: Add all boundary cells into PQ
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = visited[m - 1][j] = true;
        }

        // Directions for BFS
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int water = 0;

        // Step 2: Process cells
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], h = cur[2];

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) continue;

                visited[nx][ny] = true;

                // If neighbor is lower, trap water
                if (heightMap[nx][ny] < h) {
                    water += h - heightMap[nx][ny];
                }

                // Push the neighbor with updated boundary height
                pq.offer(new int[]{nx, ny, Math.max(heightMap[nx][ny], h)});
            }
        }

        return water;
    }
}
