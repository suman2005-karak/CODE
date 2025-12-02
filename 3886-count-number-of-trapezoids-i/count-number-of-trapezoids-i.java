import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();

        // Count points by y-coordinate
        for (int[] p : points) {
            map.put(p[1], map.getOrDefault(p[1], 0) + 1);
        }

        long S = 0;  // sum of segments for each y
        long T = 0;  // sum of squared segments

        for (int c : map.values()) {
            if (c >= 2) {
                long seg = (long)c * (c - 1) / 2; // C(c,2)
                seg %= MOD;

                S = (S + seg) % MOD;
                T = (T + (seg * seg) % MOD) % MOD;
            }
        }

        // total trapezoids = (S^2 - T) / 2
        long result = (S * S % MOD - T + MOD) % MOD;
        result = result * inv2() % MOD;

        return (int) result;
    }

    // modular inverse of 2 under MOD (since MOD is prime)
    private long inv2() {
        return (MOD + 1) / 2;
    }
}
