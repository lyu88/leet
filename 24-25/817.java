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
 // runtime not good
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        ListNode pre = null;
        int cnt = nums.length;
        while (head != null) {
            if (pre != null && set.contains(pre.val) && set.contains(head.val)) {
                cnt--;
            }
            pre = head;
            head = head.next;
        }
        return cnt;
    }
}