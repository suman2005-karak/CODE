class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;  // number of devices in previous non-empty row
        int result = 0;

        for (String row : bank) {
            int count = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') count++;
            }

            if (count > 0) {
                result += prev * count;  // beams between prev and current row
                prev = count;  // update previous row
            }
        }

        return result;
    }
}
