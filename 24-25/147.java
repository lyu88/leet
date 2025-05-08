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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0, head);
        ListNode cur = head.next;
        ListNode lastSorted = head;
        while (cur != null) {
            if (cur.val >= lastSorted.val) {
                lastSorted = cur;
            } else {
                head = dummyHead;
                while (head.next.val <= cur.val) {
                    head = head.next;
                }
                lastSorted.next = cur.next;
                cur.next = head.next;
                head.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummyHead.next;
    }
}