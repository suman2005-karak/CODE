class Solution {
    int count = 0;
    long k;
    List<Integer>[] g;
    long[] values;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;
        this.values = new long[n];
        for(int i = 0; i < n; i++) this.values[i] = values[i];

        g = new ArrayList[n];
        for(int i = 0; i < n; i++) g[i] = new ArrayList<>();

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        dfs(0, -1);
        return count;
    }

    // returns subtree sum modulo k
    private long dfs(int node, int parent) {
        long sum = values[node];

        for (int nxt : g[node]) {
            if (nxt == parent) continue;
            sum += dfs(nxt, node);
        }

        // If subtree sum divisible by k, we form a component
        if (sum % k == 0) {
            count++;
            return 0;  // cut here → parent gets no leftover
        }

        return sum;
    }
}
