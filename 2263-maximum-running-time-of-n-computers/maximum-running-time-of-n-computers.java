class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long left = 0;
        long right = 0;

        for (long b : batteries)
            right += b;

        right /= n; // maximum possible time

        while (left < right) {
            long mid = (left + right + 1) / 2;

            long total = 0;
            for (long b : batteries) {
                total += Math.min(b, mid);
            }

            if (total >= mid * n) {
                left = mid;  // mid is feasible
            } else {
                right = mid - 1;  // mid too large
            }
        }

        return left;
    }
}
