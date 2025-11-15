class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] result = new int[rows * cols][2];
        int idx = 0;

        boolean[][] visited = new boolean[rows][cols];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{rCenter, cCenter});
        visited[rCenter][cCenter] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            result[idx++] = new int[]{r, c};

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return result;
    }
}
