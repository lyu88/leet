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