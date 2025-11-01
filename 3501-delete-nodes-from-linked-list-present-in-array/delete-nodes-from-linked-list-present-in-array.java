/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.*;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Step 1: Store all nums values in a HashSet for O(1) lookup
        Set<Integer> removeSet = new HashSet<>();
        for (int num : nums) {
            removeSet.add(num);
        }

        // Step 2: Use a dummy node to simplify edge case removal (like head itself)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 3: Traverse the linked list
        ListNode current = dummy;
        while (current.next != null) {
            if (removeSet.contains(current.next.val)) {
                // Skip the node if its value is in nums
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        // Step 4: Return the modified list
        return dummy.next;
    }
}