class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return group(countAndSay(n-1));
    }

    private String group(String s) {
        char c = 0;
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                num++;
            } else {
                if (num > 0) {
                    sb.append(num).append(c);
                }
                c = s.charAt(i);
                num = 1;
            }
        }
        sb.append(num).append(c);
        return sb.toString();
    }
}


// iterative solution
class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            res = rle(res);
        }
        return res;
    }


    String rle(String s) {
        char ct = s.charAt(0);
        int num = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ct) {
                num++;
            } else {
                sb.append(num).append(ct);
                ct = c;
                num = 1;
            }
        }
        sb.append(num).append(ct);
        return sb.toString();
    }
}

// 0622 别忘了尾子
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String pre = countAndSay(n-1);
        return rle(pre);
    }

    String rle(String s) {
        char c = s.charAt(0);
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            char d = s.charAt(i);
            if (d == c) {
                cnt++;
            } else {
                sb.append(cnt).append(c);
                cnt = 1;
                c = d;
            }
        }
        sb.append(cnt).append(c);
        return sb.toString();
    }
}