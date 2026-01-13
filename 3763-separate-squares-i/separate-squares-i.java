class Solution {

    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        // Compute total area and search bounds
        for (int[] s : squares) {
            double side = s[2];
            totalArea += side * side;
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + side);
        }

        double target = totalArea / 2.0;

        // Binary search for answer
        for (int i = 0; i < 60; i++) { // sufficient for 1e-5 precision
            double mid = (low + high) / 2.0;
            double areaBelow = areaBelowLine(squares, mid);

            if (areaBelow < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private double areaBelowLine(int[][] squares, double h) {
        double area = 0;

        for (int[] s : squares) {
            double y = s[1];
            double l = s[2];

            if (h <= y) {
                continue; // fully above
            } else if (h >= y + l) {
                area += l * l; // fully below
            } else {
                area += (h - y) * l; // partially below
            }
        }
        return area;
    }
}
