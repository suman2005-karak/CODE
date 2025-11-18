class Solution {
    public int titleToNumber(String columnTitle) {
        long result = 0;  // use long to avoid overflow during calculation
        
        for (int i = 0; i < columnTitle.length(); i++) {
            int val = columnTitle.charAt(i) - 'A' + 1;
            result = result * 26 + val;
        }
        
        return (int) result;
    }
}
