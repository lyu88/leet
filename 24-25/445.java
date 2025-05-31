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
        List<Integer> list1 = new ArrayList<>();
        ListNode head1 = l1, head2 = l2;
        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        List<Integer> list2 = new ArrayList<>();
        while (l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }
        int i = list1.size() -1, j = list2.size() - 1;
        Stack<Integer> stack = new Stack<>();
        int in = 0;
        while (i >= 0 && j >= 0) {
            int sum = (list1.get(i) + list2.get(j) + in) % 10;
            in = (list1.get(i) + list2.get(j) + in) / 10;
            stack.push(sum);
            i--; j--;
        }
        while (i >= 0) {
            int sum = (list1.get(i) + in) % 10;
            in = (list1.get(i) + in) / 10;
            stack.push(sum);
            i--; 
        }
        while (j >= 0) {
            int sum = (list2.get(j) + in) % 10;
            in = (list2.get(j) + in) / 10;
            stack.push(sum);
            j--;
        }
        if (list1.size() >= list2.size()) {
            return apply(head1, stack, in);
        } else {
            return apply(head2, stack, in);
        }
    }

    ListNode apply(ListNode l, Stack<Integer> stack, int in) {
        ListNode dummy = new ListNode(in);
        ListNode node = dummy;
        node.next = l;
        while (!stack.isEmpty()) {
            node = node.next;
            node.val = stack.pop();
        }
        if (in == 1) {
            return dummy;
        }
        return dummy.next;
    }
}