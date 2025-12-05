class Solution {
    public int numberOfCuts(int n) {
        if (n == 1) return 0;       // No cuts needed
        if (n % 2 == 0) return n / 2;  // Even slices
        return n;                   // Odd slices
    }
}
