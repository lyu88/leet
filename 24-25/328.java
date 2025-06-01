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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode();
        ListNode oddNode = oddDummy;
        ListNode evenDummy = new ListNode();
        ListNode evenNode = evenDummy;
        int i = 1;
        while (head != null) {
            if (i % 2 == 1) {
                oddNode.next = head;
                oddNode = oddNode.next;
            } else {
                evenNode.next = head;
                evenNode = evenNode.next;
            }
            head = head.next;
            i++;
        }
        evenNode.next = null;
        oddNode.next = evenDummy.next;
        return oddDummy.next;
    }
}