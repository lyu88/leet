// 还非得2 passes
// AI 斧正，就是计数
public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLen = 0;

        // Left to right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else right++;
            
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }

        // Right to left
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') left++;
            else right++;
            
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }

        return maxLen;
    }

// wrong still the case ()(()
class Solution {
    public int longestValidParentheses(String s) {
        int stack = 0, cnt = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack++;
            } else {
                if (stack == 0) {
                    cnt = 0;
                } else {
                    stack--;
                    cnt += 2;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}

// wrong because case ()()
class Solution {
    public int longestValidParentheses(String s) {
        final int n = s.length();
        int[] right = new int[n];
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                cnt++;
            }
            right[i] = cnt;
        }
        int max = 0;
        cnt = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cnt++;
            }
            max = Math.max(max, 2 * Math.min(cnt, right[i]));
        }
        return max;
    }
}