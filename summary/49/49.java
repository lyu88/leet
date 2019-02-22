class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    	Map<String, ArrayList<String>> resultMap = new HashMap<>();
    	for (String str : strs) {
    		String s = sortAnagram(str);
    		if (resultMap.containsKey(s)) {
    			resultMap.put(s, resultMap.get(s).add(str));
    		} else {
    			resultMap.put(s, new ArrayList<String>());
    		}
    	}
    	return new ArrayList<>(map.values());
    }

    private String sortAnagram(String str) {
    	final int numCount = 26;
    	int[] count = new int[numCount];
    	for (int i = 0; i < str.length; i++) {
    		count[str1.charAt(i) - 'a']++;
    	}
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < numCount; i++) {
    		if (count[i] == 0)
    			continue;
    		String s = Character.toString('a' + i);
    		sb.append(s.repeat(count[i]));
    	}
    	return sb.toString();
    }

}