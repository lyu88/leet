public class Solution {
    /**
     * @param s: the given string
     * @return: whether this string is valid
     */
    public boolean checkValidString(String s) {
        // Write your code here
        int numMax = 0;
        int numMin = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                numMax--;
                if (numMax < 0) {
                    return false;
                }
                numMin = Math.max(0, numMin - 1);
            } else if (c == '(') {
                numMax++;
                numMin++;
            } else {
                numMax++;
                numMin = Math.max(0, numMin - 1);
            }
        }
        return numMin == 0;
    }
}