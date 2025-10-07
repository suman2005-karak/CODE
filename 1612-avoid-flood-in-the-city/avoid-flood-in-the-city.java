import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> fullLakes = new HashMap<>(); // lake → last day it rained
        TreeSet<Integer> dryDays = new TreeSet<>(); // indices where rains[i] == 0

        for (int i = 0; i < n; i++) {
            int lake = rains[i];

            if (lake == 0) {
                dryDays.add(i); // store this dry day
                ans[i] = 1; // temporary fill (can change later)
            } else {
                ans[i] = -1; // raining day, must mark -1

                if (fullLakes.containsKey(lake)) {
                    // Find next available dry day after last time this lake was filled
                    Integer dryDay = dryDays.higher(fullLakes.get(lake));

                    if (dryDay == null) {
                        // No available dry day to prevent flood
                        return new int[0];
                    }

                    ans[dryDay] = lake; // dry this lake on that day
                    dryDays.remove(dryDay);
                }

                fullLakes.put(lake, i); // mark lake as full
            }
        }
        return ans;
    }
}
