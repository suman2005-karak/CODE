class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - i;
            int total = left * right;
            int odd = total / 2;
            
            if (total % 2 == 1) odd++;  // if total is odd, one extra odd-length subarray
            
            sum += arr[i] * odd;
        }
        
        return sum;
    }
}
