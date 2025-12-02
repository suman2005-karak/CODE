class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;

        while (n > 0) {
            int digit = n % 10;   // get last digit
            sum += digit;
            product *= digit;
            n /= 10;              // remove last digit
        }

        return product - sum;
    }
}
