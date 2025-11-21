class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int result = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int left = s.indexOf(ch);
            int right = s.lastIndexOf(ch);

            if (left != -1 && right != -1 && right > left) {
                boolean[] seen = new boolean[26];

                for (int i = left + 1; i < right; i++) {
                    seen[s.charAt(i) - 'a'] = true;
                }

                for (boolean b : seen) {
                    if (b) result++;
                }
            }
        }

        return result;
    }
}
