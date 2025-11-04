import java.util.*;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        // Count frequency of each number
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : deck) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Find the GCD of all frequencies
        int gcd = 0;
        for (int freq : countMap.values()) {
            gcd = findGCD(gcd, freq);
        }

        // If the GCD is greater than 1, we can form groups of that size
        return gcd > 1;
    }

    // Helper function to find GCD using Euclid's algorithm
    private int findGCD(int a, int b) {
        if (b == 0) return a;
        return findGCD(b, a % b);
    }
}
