class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum, ans = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long sum = mid + calc(mid - 1, index) + calc(mid - 1, n - index - 1);

            if (sum <= maxSum) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private long calc(int peak, int length) {
        if (peak >= length) {
            long first = peak - length + 1;
            return (long)(peak + first) * length / 2;
        } else {
            long triangle = (long)peak * (peak + 1) / 2;
            return triangle + (length - peak);
        }
    }
}
