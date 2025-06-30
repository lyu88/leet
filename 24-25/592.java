class Solution {
    public String fractionAddition(String expression) {
        int sign = 1;
        final int n  = expression.length();
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == '-') {
                sign = -1;              
            } else if (c == '+') {
                sign = 1;
            } else {
                int num = 0;
                while ( Character.isDigit(expression.charAt(i))) {
                    num = 10*num + expression.charAt(i) - '0';
                    i++;
                }
                i++;
                int den = 0;
                while (i < n && Character.isDigit(expression.charAt(i))) {
                    den = 10*den + expression.charAt(i) - '0';
                    i++;
                }
                i--;
                stack.push(new Node(sign*num, den));
            }
        }
        while (stack.size() > 1) {
            Node a = stack.pop();
            Node b = stack.pop();
            stack.push(calc(a, b));
        }
        int num = stack.peek().num;
        int den = stack.peek().den;
        int gcd = gcd(Math.abs(num), den);
        return "" + num/gcd + "/" + den/gcd;
    }

    Node calc(Node a, Node b) {
        int lcm = lcm(a.den, b.den);
        int num = lcm/a.den*a.num + lcm/b.den*b.num;
        return new Node(num, lcm);
    }

    int gcd(int a, int b) {
        while (b > 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    int lcm(int a, int b) {
        return a * b / gcd(a,b);
    }

    class Node {
        int num;
        int den;
        Node(int num, int den) {
            this.num = num;
            this.den = den;
        }
    }
}