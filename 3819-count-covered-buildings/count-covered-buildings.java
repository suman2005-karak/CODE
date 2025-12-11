class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int m = buildings.length;

        // Using HashMaps because n can be up to 1e5
        Map<Integer, Integer> rowMinY = new HashMap<>();
        Map<Integer, Integer> rowMaxY = new HashMap<>();
        Map<Integer, Integer> colMinX = new HashMap<>();
        Map<Integer, Integer> colMaxX = new HashMap<>();

        // Step 1: Fill min & max for rows and columns
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            rowMinY.put(x, Math.min(rowMinY.getOrDefault(x, Integer.MAX_VALUE), y));
            rowMaxY.put(x, Math.max(rowMaxY.getOrDefault(x, Integer.MIN_VALUE), y));

            colMinX.put(y, Math.min(colMinX.getOrDefault(y, Integer.MAX_VALUE), x));
            colMaxX.put(y, Math.max(colMaxX.getOrDefault(y, Integer.MIN_VALUE), x));
        }

        // Step 2: Count covered buildings
        int covered = 0;

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            boolean left = rowMinY.get(x) < y;
            boolean right = rowMaxY.get(x) > y;
            boolean above = colMinX.get(y) < x;
            boolean below = colMaxX.get(y) > x;

            if (left && right && above && below) {
                covered++;
            }
        }

        return covered;
    }
}
