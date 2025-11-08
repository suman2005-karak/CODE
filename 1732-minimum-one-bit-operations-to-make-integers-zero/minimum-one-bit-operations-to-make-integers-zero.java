class Solution {
    public int minimumOneBitOperations(int n) {
        // Inverse Gray code formula
        int result = 0;
        
        // Keep XORing with right-shifted values until n becomes 0
        while (n > 0) {
            result ^= n;  // Accumulate XOR
            n >>= 1;      // Right shift by 1 bit
        }
        
        return result;
    }
}
