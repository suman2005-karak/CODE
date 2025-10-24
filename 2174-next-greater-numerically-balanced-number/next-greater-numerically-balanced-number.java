class Solution {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; i <= 1224444; i++) {
            if (isBeautiful(i)) return i;
        }
        return -1; // Should never happen given the constraints
    }

    private boolean isBeautiful(int num) {
        int[] count = new int[10];
        int temp = num;

        while (temp > 0) {
            count[temp % 10]++;
            temp /= 10;
        }

        for (int d = 0; d < 10; d++) {
            if (count[d] != 0 && count[d] != d) return false;
        }

        return true;
    }
}
