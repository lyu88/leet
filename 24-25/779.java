

class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        if (k % 2 == 0) return 1 - kthGrammar(n - 1, k / 2);
        else return kthGrammar(n - 1, (k + 1) / 2);
    }
}
// think of the problem like this tree
/*        0
      /       \
     0          1
   /   \      /    \
   0     1    1      0
 / \     / \   / \   / \
 0  1   1   0  1  0  0  1
*/


// MLE
// n = 30, k = 434991989
class Solution {
    public int kthGrammar(int n, int k) {
        String pre = "0";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < pre.length(); j++) {
                if (pre.charAt(j) == '0') {
                    sb.append("01");
                } else {
                    sb.append("10");
                }
            }
            pre = sb.toString();
        }
        return pre.charAt(k - 1) - '0';
    }
}