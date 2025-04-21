public class Solution {
    /**
     * @param s: A string
     * @param wordSet: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> set) {
        // write your code here
        final int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[len] = true;
        for (int i = len - 1; i >= 0; i--) {
            for (String word : set) {
                if (i + word.length() <= len && word.equals(s.substring(i, i + word.length())) && dp[i + word.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}