class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from last digit backwards
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;   // no carry needed
                return digits; // return directly
            }
            digits[i] = 0; // set current digit to 0 (carry over)
        }

        // If all digits were 9, e.g., [9,9,9] → [1,0,0,0]
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
