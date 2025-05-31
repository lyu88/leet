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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        int in = 0;
        while (l1 != null && l2 != null) {
            int sum = (l1.val + l2.val + in) % 10;
            in = (l1.val + l2.val + in) / 10;
            l1.val = sum;
            node.next = l1;
            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }
        while (l1 != null) {
            int sum = (l1.val + in) % 10;
            in = (l1.val + in) / 10;
            l1.val = sum;
            node.next = l1;
            l1 = l1.next;
            node = node.next;
        }
        while (l2 != null) {
            int sum = (l2.val + in) % 10;
            in = (l2.val + in) / 10;
            l2.val = sum;
            node.next = l2;
            l2 = l2.next;
            node = node.next;
        }
        if (in == 1) {
            node.next = new ListNode(1);
        }
        return dummy.next;
    }
}