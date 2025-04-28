class Solution {
    public int numDecodings(String s) {
        final int len = s.length();
        int dp0 = 1;
        int dp1 = s.charAt(len - 1) == '0' ? 0 : 1;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp0 = dp1;
                dp1 = 0;
            } else {
                int result = dp1;
                int val = Integer.valueOf(s.substring(i, i+2));
                if (val >= 10 && val <= 26) {
                    result += dp0;
                }
                dp0 = dp1;
                dp1 = result;
            }
        }
        return dp1;
    }
}