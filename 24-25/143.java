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
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int start = 0, end = list.size() - 1;
        ListNode node = new ListNode();
        while (start < end) {
            node.next = list.get(start);
            list.get(start).next = list.get(end);
            node = list.get(end);
            start++; end--;
        }
        if (start == end) {
            node.next = list.get(start);
            node = list.get(start);
        }
        node.next = null;
    }
}