class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];

        for (int len = 2; len <= n; len++) {  // length of range
            for (int start = 1; start + len - 1 <= n; start++) {
                int end = start + len - 1;
                dp[start][end] = Integer.MAX_VALUE;

                for (int x = start; x <= end; x++) {
                    int cost = x + Math.max(
                        (x > start ? dp[start][x - 1] : 0),
                        (x < end ? dp[x + 1][end] : 0)
                    );
                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }

        return dp[1][n];
    }
}
