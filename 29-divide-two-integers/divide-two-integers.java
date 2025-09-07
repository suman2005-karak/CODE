class Solution {
    public static int divide(int dividend, int divisor) {
        // Step 1: Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Step 2: Determine sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Step 3: Convert to long to prevent overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;

        // Step 4: Subtract using bit shifting
        while (a >= b) {
            long temp = b, multiple = 1;
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;
            result += multiple;
        }

        // Step 5: Apply sign
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));   // Output: 3
        System.out.println(divide(7, -3));   // Output: -2
        System.out.println(divide(-2147483648, -1)); // Output: 2147483647
    }
}
