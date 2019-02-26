class Solution {
    public boolean isAnagram(String s, String t) {
    	final int count = 26;
    	final char offset = 'a';
		if (s.length() != t.length()) {
			return false;
		}
		int[] countNum = new int[count];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			countNum[c - offset]++;
			c = t.charAt(i);
			countNum[c - offset]++;
		}
		for (int i = 0; i < count; i++) {
			if (countNum[i] != 0) return false;
		}
		return true;
    }


    public boolean canConstruct(String ransomNote, String magazine) {
        final int count = 26;
        final char offset = 'a';
        int[] countNum = new int[count];
		for (int i = 0; i < ransomNote.length(); i++) {
			char c = ransomNote[i];
			countNum[c - offset]++;
		}
		for (int i = 0; i < magazine.length(); i++) {
			char c = magazine[i];
			if (countNum[c - offset] > 0) {
				countNum[c - offset]--;
				diff--;
			}
			if (diff == 0) return true;
		}
		return false;
    }
}