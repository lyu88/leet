class Solution {
	final int _size = 256;
	final char _offsite = 0;

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> results = new ArrayList<String>();
        for (String word : words) {
        	if (mappable(word, pattern) && mappable(pattern, word)) {
        		results.add(word);
        	}
        }
        return results;
    }

    private boolean mappable(String s, String t) {
    	final int len = s.length();
    	char[] map = new char[_size];
    	for (int i = 0; i < len; i++) {
    		char a = s.charAt(i);
    		if (map[a - _offsite] > 0) {
    			if (map[a - _offsite] != t.charAt(i)) {
    				return false;
    			}
    		} else {
    			map[a - _offsite] = t.charAt(i);
    		}
    	}
    	return true;
    }
}