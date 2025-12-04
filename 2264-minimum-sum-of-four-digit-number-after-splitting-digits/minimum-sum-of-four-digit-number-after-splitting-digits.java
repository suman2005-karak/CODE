class Solution {
    public int minimumSum(int num) {
        int[] digits = new int[4];
        int idx = 0;

        // extract digits
        while (num > 0) {
            digits[idx++] = num % 10;
            num /= 10;
        }

        // sort digits
        Arrays.sort(digits);

        // build two numbers greedily
        int new1 = digits[0] * 10 + digits[2];
        int new2 = digits[1] * 10 + digits[3];

        return new1 + new2;
    }
}
