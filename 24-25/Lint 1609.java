/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: the head node
     * @return: the middle node
     */
    public ListNode middleNode(ListNode head) {
        // write your code here.
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) {
            return slow;
        }
        return slow.next;
    }
}