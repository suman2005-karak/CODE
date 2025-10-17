class Solution {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        // find the largest factor <= sqrt(area)
        while (w > 0) {
            if (area % w == 0) {
                int l = area / w;
                return new int[]{l, w}; // ensure L >= W
            }
            w--;
        }
        // fallback (never really reached because w will reach 1)
        return new int[]{area, 1};
    }
}
