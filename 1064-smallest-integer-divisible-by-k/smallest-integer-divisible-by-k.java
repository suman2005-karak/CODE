class Solution {
    public int smallestRepunitDivByK(int k) {
        // If k is even or multiple of 5, it will never divide a number made of only 1s
        if (k % 2 == 0 || k % 5 == 0) return -1;

        int remainder = 0;
        for (int length = 1; length <= k; length++) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) return length;
        }
        return -1; // Should never reach here unless k has forbidden factors
    }
}
