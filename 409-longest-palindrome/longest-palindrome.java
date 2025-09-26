import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        // Count frequencies of each character
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean oddFound = false;

        for (int count : freq.values()) {
            if (count % 2 == 0) {
                length += count;  // use all even counts
            } else {
                length += count - 1; // use largest even part
                oddFound = true;
            }
        }

        // If we had any odd counts, we can put 1 char in the middle
        if (oddFound) {
            length += 1;
        }

        return length;
    }
}
