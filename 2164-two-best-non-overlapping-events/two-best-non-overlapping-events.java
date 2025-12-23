import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;

        // Sort events by start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // Copy events and sort by end time
        int[][] endSorted = events.clone();
        Arrays.sort(endSorted, (a, b) -> a[1] - b[1]);

        // prefixMax[i] = max value among events[0..i] in endSorted
        int[] prefixMax = new int[n];
        prefixMax[0] = endSorted[0][2];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], endSorted[i][2]);
        }

        int ans = 0;

        // Try each event as the second event
        for (int[] e : events) {
            int start = e[0];
            int value = e[2];

            // Binary search: last event ending before start
            int l = 0, r = n - 1, idx = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (endSorted[mid][1] < start) {
                    idx = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            int total = value;
            if (idx != -1) {
                total += prefixMax[idx];
            }

            ans = Math.max(ans, total);
        }

        return ans;
    }
}
