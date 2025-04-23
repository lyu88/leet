public class Solution {
    /**
     * @param n: the nth
     * @return: the nth sequence
     */
    public String countAndSay(int n) {
        // write your code here
        if (n == 1) {
            return "1";
        }
        String pre = countAndSay(n - 1);
        int count = 0;
        char r = (char)-1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pre.length(); i++) {
            char c = pre.charAt(i);
            if (i >= 1 && c != pre.charAt(i - 1)) {
                sb.append(count).append(r);
                count = 1;
            } else {
                count++;
            }
            r = c;
        }
        sb.append(count).append(r);
        return sb.toString();
    }
}