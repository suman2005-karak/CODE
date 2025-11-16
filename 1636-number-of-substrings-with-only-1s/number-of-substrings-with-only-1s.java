class Solution {
    public int numSub(String s) {
        long mod = 1000000007;
        long count = 0; // current consecutive 1's
        long ans = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;                 // extend block of 1’s
                ans = (ans + count) % mod;  // add new substrings
            } else {
                count = 0;   // reset on '0'
            }
        }

        return (int) ans;
    }
}

