import java.util.*;

class Solution {
    private int[] prefix;
    private int totalSum;
    private Random random;

    public Solution(int[] w) {
        prefix = new int[w.length];
        random = new Random();

        prefix[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefix[i] = prefix[i - 1] + w[i];
        }
        totalSum = prefix[w.length - 1];
    }

    public int pickIndex() {
        // Random number from 1 to totalSum
        int target = random.nextInt(totalSum) + 1;

        // Binary search
        int left = 0, right = prefix.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefix[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
