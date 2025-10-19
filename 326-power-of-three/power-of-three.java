class Solution {
    public boolean isPowerOfThree(int n) {
        // 3^19 = 1162261467 is the largest power of 3 that fits in 32-bit int
        return n > 0 && 1162261467 % n == 0;
    }
}
