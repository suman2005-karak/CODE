class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int left = 1, right = x / 2, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sq = (long) mid * mid; // avoid overflow

            if (sq == x) {
                return mid;
            } else if (sq < x) {
                ans = mid;  // store possible answer
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
