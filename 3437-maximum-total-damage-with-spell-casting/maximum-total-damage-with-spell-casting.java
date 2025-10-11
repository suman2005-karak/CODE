import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        // Sort to enable binary search and grouping
        Arrays.sort(power);
        
        int n = power.length;
        Long[] memo = new Long[n];
        Map<Integer, Integer> count = new HashMap<>();
        int[] nextValid = new int[n];
        
        // Count frequencies and compute next valid indices
        for (int i = 0; i < n; i++) {
            count.put(power[i], count.getOrDefault(power[i], 0) + 1);
            
            // Find first index where power[j] > power[i] + 2
            int target = power[i] + 3;
            int idx = Arrays.binarySearch(power, target);
            nextValid[i] = idx < 0 ? -idx - 1 : idx;
        }
        
        return dfs(0, power, count, nextValid, memo);
    }
    
    private long dfs(int i, int[] power, Map<Integer, Integer> count, 
                     int[] nextValid, Long[] memo) {
        if (i >= power.length) return 0;
        if (memo[i] != null) return memo[i];
        
        // Option 1: Skip all occurrences of power[i]
        long skip = dfs(i + count.get(power[i]), power, count, nextValid, memo);
        
        // Option 2: Take all occurrences of power[i]
        long take = (long) power[i] * count.get(power[i]) 
                    + dfs(nextValid[i], power, count, nextValid, memo);
        
        return memo[i] = Math.max(skip, take);
    }
}
