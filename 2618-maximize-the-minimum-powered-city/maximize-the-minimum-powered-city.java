class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        
        // Calculate initial power for each city using difference array
        long[] power = new long[n];
        long[] diff = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);
            diff[left] += stations[i];
            diff[right + 1] -= stations[i];
        }
        
        // Convert difference array to actual power values
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            power[i] = sum;
        }
        
        // Binary search on the answer
        long left = 0, right = (long) 2e14; // Upper bound considering constraints
        long result = 0;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (canAchieve(power, n, r, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private boolean canAchieve(long[] power, int n, int r, int k, long minPower) {
        long[] currentPower = power.clone();
        long[] additions = new long[n + 1]; // Difference array for new stations
        long added = 0;
        long stationsUsed = 0;
        
        for (int i = 0; i < n; i++) {
            // Apply previous additions using difference array
            added += additions[i];
            currentPower[i] += added;
            
            if (currentPower[i] < minPower) {
                // Calculate deficit
                long deficit = minPower - currentPower[i];
                
                if (stationsUsed + deficit > k) {
                    return false; // Not enough stations
                }
                
                // Place stations at the rightmost position that can cover city i
                int pos = Math.min(n - 1, i + r);
                stationsUsed += deficit;
                added += deficit;
                
                // Mark where this station's effect ends
                int endPos = Math.min(n, pos + r + 1);
                additions[endPos] -= deficit;
            }
        }
        
        return true;
    }
}
