class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] s = new char[n];
        char c = 'a';
        
        for (int i = 0; i < n; i++) {
            if (s[i] == 0) {
                if (c > 'z') return "";
                for (int j = i; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        s[j] = c;
                    }
                }
                c++;
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int val = 0;
                if (s[i] == s[j]) {
                    val = 1;
                    if (i + 1 < n && j + 1 < n) {
                        val += lcp[i + 1][j + 1];
                    }
                }
                if (lcp[i][j] != val) {
                    return "";
                }
            }
        }
        
        return new String(s);
    }
}