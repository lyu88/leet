class Solution {
    public int longestPalindrome(String s) {
        final int size = 256;
        int[] freqArray = new int[size];
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	freqArray[c]++;
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
        	sum += freqArray[i]/2*2;
        }
        return sum < s.length() ? sum+1 : sum;
    }
}