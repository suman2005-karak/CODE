class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrank = numBottles;
        int empty = numBottles;
        
        while (empty >= numExchange) {
            int newBottles = empty / numExchange;   // how many new bottles we can get
            totalDrank += newBottles;
            empty = newBottles + (empty % numExchange); // remaining empties + new empty ones
        }
        
        return totalDrank;
    }
}
