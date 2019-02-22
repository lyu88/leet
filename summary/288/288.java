class ValidWordAbbr {
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String str : dictionary) {
            String a = abbrev(str);
        	if (map.containsKey(a)){
        		StringInfo stringInfo = map.get(a);
        		stringInfo._isUnique = false;
                map.put(a, stringInfo);
        	}
            else {
            	StringInfo stringInfo = new stringInfo(str, true);
            	map.put(a, stringInfo);
            }
        }
    }
    
    public boolean isUnique(String word) {
        String a = abbrev(word);
        if (!map.containsKey(a) || map.get(a)._isUnique && word.equals(map.get(a)._fullStr))
        	return true;
        return false;
    }

	private String abbrev(String word) {
		if (word == null || word.length() <= 2)
			return word;
		return word.substring(0,1) + Integer.toString(word.length() - 2) + word.substring(word.length() - 1);
	}

	private class StringInfo {
		String _fullStr;
		boolean _isUnique;
		public StringInfo(String fullStr, boolean isUnique) {
			_fullStr = fullStr;
			_isUnique = isUnique;
		}
	}

    private Map<String, StringInfo> map;
}