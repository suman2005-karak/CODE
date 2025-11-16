class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        
        int x = arr[0], y = arr[1], z = arr[2];
        
        int gap1 = y - x - 1;
        int gap2 = z - y - 1;
        
        int minMoves = 0;
        int maxMoves = gap1 + gap2;

        if (gap1 == 0 && gap2 == 0) {
            minMoves = 0;
        } else if (gap1 <= 1 || gap2 <= 1) {
            minMoves = 1;
        } else {
            minMoves = 2;
        }

        return new int[]{minMoves, maxMoves};
    }
}
