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
// one pass
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode node = dummy;
        int i = 1;
        while (i < left) {
            node = node.next;
            i++;
        }
        ListNode tail = node;
        ListNode cur = node.next;
        ListNode tail2 = cur;
        ListNode next = cur.next;
        while (i < right) {
            ListNode tmp = next.next;
            next.next = cur;
            i++;
            cur = next;
            next = tmp;
        }
        tail.next = cur;
        tail2.next = next;
        return dummy.next;
    }
}