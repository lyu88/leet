class Solution {
    public String pushDominoes(String dominoes) {
        final int n = dominoes.length();
        char[] arr = dominoes.toCharArray();
        Node pre = new Node(-1, 'L');
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c != '.') {
                Node cur = new Node(i, c);
                if (c == 'L') {
                    if (pre.c == 'L') {
                        for (int j = pre.index + 1; j < i; j++) {
                            arr[j] = 'L';
                        }
                    } else {
                        int left = pre.index + 1;
                        int right = i - 1;
                        while (left < right) {
                            arr[left++] = 'R';
                            arr[right--] = 'L';
                        }
                    }
                } else {
                    if (pre.c == 'R') {
                        for (int j = pre.index + 1; j < i; j++) {
                            arr[j] = 'R';
                        }
                    }    
                }
                pre = cur;
            }
        }
        if (pre.c == 'R') {
            for (int i = pre.index + 1; i < n; i++) {
                arr[i] = 'R';
            }
        }
        return new String(arr);
    }
    
    private class Node {
        int index;
        char c;
        public Node(int index, char c) {
            this.index = index;
            this.c = c;
        }
    }
}