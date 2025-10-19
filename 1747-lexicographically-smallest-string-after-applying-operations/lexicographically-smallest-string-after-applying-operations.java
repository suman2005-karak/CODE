import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String smallest = s;

        queue.offer(s);
        seen.add(s);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur.compareTo(smallest) < 0) {
                smallest = cur;
            }

            // Operation 1: Add 'a' to all digits at odd indices
            char[] arr = cur.toCharArray();
            for (int i = 1; i < arr.length; i += 2) {
                arr[i] = (char) ((arr[i] - '0' + a) % 10 + '0');
            }
            String added = new String(arr);
            if (seen.add(added)) queue.offer(added);

            // Operation 2: Rotate right by 'b'
            String rotated = cur.substring(cur.length() - b) + cur.substring(0, cur.length() - b);
            if (seen.add(rotated)) queue.offer(rotated);
        }

        return smallest;
    }
}
