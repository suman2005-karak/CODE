class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total = numBottles; // drink all initial bottles
        int empty = numBottles;

        while (empty >= numExchange) {
            // exchange
            empty -= numExchange;
            numExchange++; // requirement increases
            total++; // drink the new bottle
            empty++; // one more empty from drinking
        }

        return total;
    }
}
