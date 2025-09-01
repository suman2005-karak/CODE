import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return Collections.emptyList();

        String[] phone = {
            "",    "",    "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        List<String> result = new ArrayList<>();
        result.add(""); // start with empty string

        for (char d : digits.toCharArray()) {
            List<String> next = new ArrayList<>();
            for (String s : result) {
                for (char c : phone[d - '0'].toCharArray()) {
                    next.add(s + c);
                }
            }
            result = next; // move to next step
        }

        return result;
    }
}
