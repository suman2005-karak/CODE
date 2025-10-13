import java.util.*;

class Solution {
    // helper: check if two words are anagrams
    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    public List<String> removeAnagrams(String[] words) {
        Stack<String> stack = new Stack<>();

        for (String word : words) {
            if (!stack.isEmpty() && isAnagram(stack.peek(), word)) {
                // remove the anagram word
                continue;
            } else {
                stack.push(word);
            }
        }

        return new ArrayList<>(stack);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeAnagrams(new String[]{"abba","baba","bbaa","cd","cd"})); 
        // Output: [abba, cd]

        System.out.println(sol.removeAnagrams(new String[]{"a","b","c","d","e"})); 
        // Output: [a, b, c, d, e]
    }
}
