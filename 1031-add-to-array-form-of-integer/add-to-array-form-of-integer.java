import java.util.*;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;
        int carry = 0;

        // Process from the least significant digit
        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
                i--;
            }

            result.add(k % 10); // current digit
            k /= 10; // carry handled automatically
        }

        // The digits were added in reverse order
        Collections.reverse(result);
        return result;
    }
}
