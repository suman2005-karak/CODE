class Solution {
    public boolean isFascinating(int n) {

        // Step 1: Concatenate n, 2n, and 3n
        String s = "" + n + (2 * n) + (3 * n);

        // Step 2: Length must be exactly 9
        if (s.length() != 9) {
            return false;
        }

        // Step 3: Track digits
        boolean[] seen = new boolean[10];

        for (char ch : s.toCharArray()) {
            int digit = ch - '0';

            // No zero allowed
            if (digit == 0) {
                return false;
            }

            // Digit must be unique
            if (seen[digit]) {
                return false;
            }

            seen[digit] = true;
        }

        return true;
    }
}
