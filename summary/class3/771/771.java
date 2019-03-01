class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] jewelMap = new boolean[256];
        for (int i = 0; i < J.length(); i++) {
        	char c = J.charAt(i);
        	jewelMap[c] = true;
        }
        int ret = 0;
        for (int i = 0; i < S.length(); i++) {
        	char c = S.charAt(i);
        	if (jewelMap[c]) ret++;
        }
        return ret;
    }
}