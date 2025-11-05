import java.util.*;

class Solution {
    private TreeSet<int[]> topX = new TreeSet<>((a, b) -> 
        a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); // (freq, val)
    private TreeSet<int[]> remaining = new TreeSet<>(topX.comparator());
    private Map<Integer, Integer> freq = new HashMap<>();
    private long currentSum = 0;

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] answer = new long[n - k + 1];

        for (int i = 0; i < n; i++) {
            // Add new element
            remove(nums[i]);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            add(nums[i]);

            int windowStart = i - k + 1;
            if (windowStart < 0) continue;

            // Balance: move from remaining to topX
            while (!remaining.isEmpty() && topX.size() < x) {
                int[] largest = remaining.pollLast();
                topX.add(largest);
                currentSum += (long) largest[0] * largest[1];
            }

            // Balance: move from topX to remaining
            while (topX.size() > x) {
                int[] smallest = topX.pollFirst();
                currentSum -= (long) smallest[0] * smallest[1];
                remaining.add(smallest);
            }

            answer[windowStart] = currentSum;

            // Remove leftmost element
            remove(nums[windowStart]);
            freq.put(nums[windowStart], freq.get(nums[windowStart]) - 1);
            if (freq.get(nums[windowStart]) == 0) freq.remove(nums[windowStart]);
            add(nums[windowStart]);
        }

        return answer;
    }

    private void remove(int val) {
        if (!freq.containsKey(val) || freq.get(val) == 0) return;
        
        int[] element = {freq.get(val), val};
        if (topX.remove(element)) {
            currentSum -= (long) element[0] * element[1];
        } else {
            remaining.remove(element);
        }
    }

    private void add(int val) {
        if (!freq.containsKey(val) || freq.get(val) == 0) return;
        
        int[] element = {freq.get(val), val};
        if (!topX.isEmpty() && compare(element, topX.first()) > 0) {
            topX.add(element);
            currentSum += (long) element[0] * element[1];
        } else {
            remaining.add(element);
        }
    }

    private int compare(int[] a, int[] b) {
        if (a[0] != b[0]) return a[0] - b[0];
        return a[1] - b[1];
    }
}
