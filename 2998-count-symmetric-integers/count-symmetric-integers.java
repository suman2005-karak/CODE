class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int num = low; num <= high; num++) {
            String s = String.valueOf(num);
            int len = s.length();

            // Skip odd-length numbers
            if (len % 2 != 0) continue;

            int mid = len / 2;
            int leftSum = 0, rightSum = 0;

            for (int i = 0; i < mid; i++) {
                leftSum += s.charAt(i) - '0';
            }

            for (int i = mid; i < len; i++) {
                rightSum += s.charAt(i) - '0';
            }

            if (leftSum == rightSum) {
                count++;
            }
        }

        return count;
    }
}
