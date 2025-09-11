class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // if needle is longer than haystack, it can never occur
        if (m > n) return -1;

        // check each possible starting index
        for (int i = 0; i <= n - m; i++) {
            // substring of haystack with length m
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
