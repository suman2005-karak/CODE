class Solution {
    public boolean isPowerOfFour(int n) {
        // 1. n must be positive
        // 2. n must be a power of 2 (only one bit set)
        // 3. That bit must be in an odd position
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
