class Solution {
    public boolean canPermutePalindrome(String s) {
        final int count = 256;
        int[] countNum = new int[256];
        for (int i = 0; i < s.length(); i++) {
        	countNum[s.charAt(i)]++;
        }
        int sum = 0;
        for (int i = 0; i < count; i++) {
        	sum += countNum[i] % 2;
        }
        return sum <= 1 ? true : false;
    }
}