class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int maxEnergy = Integer.MIN_VALUE;
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // If jumping k steps forward stays within bounds
            if (i + k < n) {
                energy[i] += energy[i + k];
            }
            // Keep track of the best total energy we can get
            maxEnergy = Math.max(maxEnergy, energy[i]);
        }
        
        return maxEnergy;
    }
}
