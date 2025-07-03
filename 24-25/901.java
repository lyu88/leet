class StockSpanner {

    Stack<int[]> mono;

    public StockSpanner() {
        mono = new Stack<>();
    }
    
    public int next(int price) {
        int cnt = 1;
        while (!mono.isEmpty() && mono.peek()[0] <= price) {
            cnt += mono.pop()[1];
        }
        mono.push(new int[]{price, cnt});
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

// pay attention to the reason why we can use the mono stack
class StockSpanner {

    Stack<Node> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        if (stack.isEmpty() || stack.peek().val > price) {
            stack.push(new Node(price, 1));
            return 1;
        } else {
            int days = 1;
            while (!stack.isEmpty() && stack.peek().val <= price) {
                days += stack.pop().days;
            }
            stack.push(new Node(price, days));
            return days;
        }
    }

    class Node {
        int val;
        int days;
        Node(int val, int days) {
            this.val = val;
            this.days = days;
        }
    }
}