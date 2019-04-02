class Solution {
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode dummy = new ListNode(99);
        ListNode tail = dummy;
        final int k = lists.length;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));
        for (ListNode node : lists) {
            if (node != null) minHeap.add(node);
        }
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                minHeap.add(node.next);
            }
        }
        tail.next = null;
        return dummy.next;
    }

    public ListNode sortedMerge(ListNode a, ListNode b) {
        
        ListNode result = null;
        if (a == null) { return b; }
        if (b == null) { return a; }
        
        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        // Merging of two linked lists can be done in O(N) time with O(1) space.
        // This can be extended to K lists by pairing off the lists. After each merge
        // is done we have K/2 lists remaining each of size 2 * N. After the next merge
        // we have K/4 lists of size 4 * N. We repeat till only one list is left.
        // This is a divide and conquer O(NlogN) algorithm taking constant space.
        if (lists.length == 0) { return null; }
        if (lists.length == 1) { return lists[0]; }
        int last = lists.length - 1;
        
        // Outer loop for merging of k lists
        while (last != 0) {
            
            int i = 0, j = last;
            // Merge from outside inwards
            while (i < j) {
                
                lists[i] = sortedMerge(lists[i], lists[j]);
                i++;
                j--;
                
                if (i >= j) {
                    last = j; // Terminate outer loop all are merged
                }
            }
            
        }
        return lists[0];
    }
}