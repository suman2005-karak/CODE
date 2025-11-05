class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // rec = [x1, y1, x2, y2]
        // Two rectangles overlap if they do NOT lie completely apart

        // If one rectangle is completely to the left or right OR
        // completely above or below the other, they don’t overlap.
        return !(rec1[2] <= rec2[0] ||  // rec1 is left of rec2
                 rec1[0] >= rec2[2] ||  // rec1 is right of rec2
                 rec1[3] <= rec2[1] ||  // rec1 is below rec2
                 rec1[1] >= rec2[3]);   // rec1 is above rec2
    }
}
