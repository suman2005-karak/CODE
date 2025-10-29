class Solution {
    public int smallestNumber(int n) {
        int bits = Integer.toBinaryString(n).length();   // Number of bits in n
        int allOnes = (1 << bits) - 1;                   // Number with all bits set for this length

        if (n <= allOnes) {
            return allOnes;                              // n fits within current bit-length
        } else {
            return (1 << (bits + 1)) - 1;                // Need next bit-length (all 1s)
        }
    }
}
