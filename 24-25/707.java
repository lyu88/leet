class MyLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    ListNode head;
    int len;
    public MyLinkedList() {
        head = null;
        len = 0;
    }
    
    public int get(int index) {
        if (index >= len) {
            return -1;
        }
        ListNode node = head;
        int i = 0;
        while (i < index) {
            node = node.next;
            i++;
        }
        return node.val;
    }
    
    public void addAtHead(int val) {
        ListNode tmp = new ListNode(val);
        tmp.next = head;
        head = tmp;
        len++;
    }
    
    public void addAtTail(int val) {
        if (len == 0) {
            head = new ListNode(val);
        } else {
            int i = 0;
            ListNode node = head;
            while (i < len - 1) {
                node = node.next;
                i++;
            }
            node.next = new ListNode(val);
        } 
        len++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > len) {
            return ;
        }
        if (index == 0) {
            addAtHead(val);
        } else if (index == len) {
            addAtTail(val);
        } else {
            int i = 0;
            ListNode node = head;
            while (i < index - 1) {
                node = node.next;
                i++;
            }
            ListNode next = node.next;
            node.next = new ListNode(val);
            node.next.next = next;
            len++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index >= len) {
            return ;
        }
        if (index == 0) {
            head = head.next;
        } else if (index == len - 1) {
            int i = 0;
            ListNode node = head;
            while (i < len - 2) {
                node = node.next;
                i++;
            }
            node.next = null;
        } else {
            int i = 0;
            ListNode node = head;
            while (i < index - 1) {
                node = node.next;
                i++;
            }
            ListNode next = node.next.next;
            node.next = next;
        }
        len--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */