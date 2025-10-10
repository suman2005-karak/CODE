class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        
        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        // Process 4 bits at a time (since 1 hex digit = 4 bits)
        while (num != 0) {
            // & 0xf extracts the last 4 bits
            int val = num & 0xf;
            sb.append(hexChars[val]);
            // >>> is unsigned right shift (preserves 0 bits for negatives)
            num >>>= 4;
        }

        return sb.reverse().toString();
    }
}
