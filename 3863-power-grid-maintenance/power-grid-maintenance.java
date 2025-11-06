import java.util.*;

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // Step 1: DSU setup
        int[] parent = new int[c + 1];
        for (int i = 1; i <= c; i++) parent[i] = i;

        for (int[] e : connections) {
            union(e[0], e[1], parent);
        }

        // Step 2: Build groups of stations per connected component
        Map<Integer, TreeSet<Integer>> compStations = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = find(i, parent);
            compStations.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        // Step 3: Track offline stations
        boolean[] offline = new boolean[c + 1];
        List<Integer> resultList = new ArrayList<>();

        // Step 4: Process each query
        for (int[] q : queries) {
            int type = q[0], x = q[1];
            int root = find(x, parent);

            if (type == 1) { // maintenance check
                if (!offline[x]) {
                    resultList.add(x);
                } else {
                    TreeSet<Integer> online = compStations.get(root);
                    resultList.add((online == null || online.isEmpty()) ? -1 : online.first());
                }
            } else if (type == 2) { // go offline
                if (!offline[x]) {
                    offline[x] = true;
                    TreeSet<Integer> online = compStations.get(root);
                    if (online != null) online.remove(x);
                }
            }
        }

        // Step 5: Convert List<Integer> to int[]
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    // DSU helpers
    private int find(int x, int[] parent) {
        if (x != parent[x]) parent[x] = find(parent[x], parent);
        return parent[x];
    }

    private void union(int a, int b, int[] parent) {
        int ra = find(a, parent), rb = find(b, parent);
        if (ra != rb) parent[rb] = ra;
    }
}
