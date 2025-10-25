class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int total = 0;
        
        // Sum for complete weeks
        // Week 1 = 28, Week 2 = 35, Week 3 = 42 ...
        // Formula for sum of first k weeks: 7 * (k*(k+1)/2) + 21*(k-1)*k/2
        total += (weeks * (2 * 28 + (weeks - 1) * 7)) / 2;
        
        // Remaining days in incomplete week
        int start = weeks + 1;  // Monday deposit for the last partial week
        for (int i = 0; i < days; i++) {
            total += start + i;
        }
        
        return total;
    }
}
