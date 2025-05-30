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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return dfs(head);
    }

    private ListNode dfs(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode tail = node.next;
        ListNode head = dfs(tail);
        tail.next = node;
        node.next = null;
        return head;
    }
}