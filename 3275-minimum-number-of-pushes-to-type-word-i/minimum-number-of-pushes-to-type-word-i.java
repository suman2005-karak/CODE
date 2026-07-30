class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int pushes = 0;
        int cost = 1;
        int used = 0;

        for (int i = 0; i < n; i++) {
            pushes += cost;
            used++;

            if (used == 8) {
                used = 0;
                cost++;
            }
        }
        return pushes;
    }
}
