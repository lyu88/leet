
// recursive looks clumsy
class Solution {
    public int scoreOfParentheses(String s) {
        if (s.isEmpty()){
            return 0;
        }
        if (s.equals("()")) {
            return 1;
        }
        if (s.startsWith("()")) {
            return 1 + scoreOfParentheses(s.substring(2));
        }
        int i = 1, tag = 1;
        while (tag > 0) {
            char c = s.charAt(i++);
            if (c == '(') {
                tag++;
            } else {
                tag--;
            }
        }
        return 2*scoreOfParentheses(s.substring(1,i-1)) + scoreOfParentheses(s.substring(i));
    }
}

//高手
public int scoreOfParentheses(String S) {
    int res = 0, l = 0;// layers
    for (int i = 0; i < S.length(); ++i) {
        if (S.charAt(i) == '(') l++; else l--;
        if (S.charAt(i) == ')' && S.charAt(i - 1) == '(') res += 1 << l;
    }
    return res;
}