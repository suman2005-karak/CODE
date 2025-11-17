class Solution {
    public int countPrimeSetBits(int left, int right) {
        // primes up to 20
        boolean[] prime = new boolean[21];
        prime[2] = prime[3] = prime[5] = prime[7] = prime[11] = true;
        prime[13] = prime[17] = prime[19] = true;
        
        int count = 0;

        for (int num = left; num <= right; num++) {
            int bits = Integer.bitCount(num);  // fast built-in method
            if (prime[bits]) count++;
        }
        
        return count;
    }
}
