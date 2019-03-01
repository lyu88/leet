class Solution {
    public char findTheDifference(String s, String t) {
        final int size = 26;
        final char offset = 'a';
        int[] freqArray = new int[size];
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	freqArray[c - offset]++;
        }
        for (int i = 0; i < t.length(); i++) {
        	char c = s.charAt(i);
        	if (freqArray[c - offset] == 0) {
        		return c;
        	}
        }
        return '';
    }
}