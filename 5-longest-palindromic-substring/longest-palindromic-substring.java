public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.longestPalindrome("babad"));  // "bab" or "aba"
        System.out.println(sol.longestPalindrome("cbbd"));   // "bb"
        System.out.println(sol.longestPalindrome("5re44"));  // "44"
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        String res = "";
        
        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome
            String p1 = expand(s, i, i);
            if (p1.length() > res.length()) res = p1;
            
            // Even length palindrome
            String p2 = expand(s, i, i + 1);
            if (p2.length() > res.length()) res = p2;
        }
        return res;
    }

    private String expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
