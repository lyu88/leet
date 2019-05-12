class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
    	Set<String> dict = new HashSet<String>(Arrays.asList(words));
    	List<String> ret = new ArrayList<>();
    	for (String word : words) {
            dict.remove(word);
    		if (wordBreak(word, dict)) {
    			ret.add(word);
    		}
            dict.add(word);
    	}
    	return ret;
    }

    public boolean wordBreak(String s, Set<String> dict) {

        final int n = s.length();
        boolean[] allResults = new boolean[n + 1];

        allResults[n] = true;
        for (int startIndex = n - 1; startIndex >= 0; --startIndex) {
            for (int endIndex = startIndex; endIndex < n; ++endIndex) {
                if (dict.contains(s.substring(startIndex, endIndex + 1)) && allResults[endIndex + 1]) {
                    allResults[startIndex] = true;
                    break;
                }
            }
        }
        return allResults[0];
    }
}