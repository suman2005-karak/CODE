class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        // Sort by end increasing, if tie then by start decreasing
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        int p1 = -1, p2 = -1;  // last two selected points
        int count = 0;

        for (int[] in : intervals) {
            int start = in[0], end = in[1];

            boolean in1 = (p1 >= start && p1 <= end);
            boolean in2 = (p2 >= start && p2 <= end);

            if (in1 && in2) {
                // already 2 points in interval
                continue;
            }

            if (in2) {
                // only p2 inside → add one more point (end)
                p1 = p2;
                p2 = end;
                count += 1;
            } else {
                // no points inside → add (end-1) and end
                p1 = end - 1;
                p2 = end;
                count += 2;
            }
        }

        return count;
    }
}
