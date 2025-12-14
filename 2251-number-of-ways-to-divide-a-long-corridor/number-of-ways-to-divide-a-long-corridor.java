class Solution {
    public int numberOfWays(String corridor) {
        final long MOD = 1_000_000_007L;

        int seatCount = 0;
        long ways = 1;
        int plantsBetween = 0;
        boolean countingPlants = false;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seatCount++;

                // When we encounter the first seat of a new pair
                if (seatCount % 2 == 1) {
                    if (countingPlants) {
                        ways = (ways * (plantsBetween + 1)) % MOD;
                        plantsBetween = 0;
                    }
                    countingPlants = true;
                }
            } else if (c == 'P' && countingPlants && seatCount % 2 == 0) {
                plantsBetween++;
            }
        }

        // Total seats must be even and non-zero
        if (seatCount == 0 || seatCount % 2 != 0) {
            return 0;
        }

        return (int) ways;
    }
}
